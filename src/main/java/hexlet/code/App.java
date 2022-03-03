package hexlet.code;

import hexlet.code.differ.Differ;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Parameters(index = "0", description = "path to first file")
    private Path filepath1;

    @Parameters(index = "1", description = "path to second file")
    private Path filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        try {
            String fileContent1 = Files.readString(filepath1);
            String fileContent2 = Files.readString(filepath2);
            String diff = Differ.generate(fileContent1, fileContent2);
            System.out.println(diff);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
