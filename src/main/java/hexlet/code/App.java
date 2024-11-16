package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @Parameters(index = "0", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Override
    public Integer call() {
        try {
            String diff = Differ.generate(filepath1, filepath2, format);
            System.out.println(diff);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }

        return SUCCESS_EXIT_CODE;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
