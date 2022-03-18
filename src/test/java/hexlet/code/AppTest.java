package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    public void testEqualsJsonWithStylishFormatter() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String result = Files.readString(Path.of("src/test/resources/stylishResult12.diff"));
        String diff = Differ.generate(filepath1, filepath2, StylishFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsJsonWithPlainFormatter() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String result = Files.readString(Path.of("src/test/resources/plainResult12.diff"));
        String diff = Differ.generate(filepath1, filepath2, PlainFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithStylishFormatter() throws Exception {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file2.yml";
        String result = Files.readString(Path.of("src/test/resources/stylishResult12.diff"));
        String diff = Differ.generate(filepath1, filepath2, StylishFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithPlainFormatter() throws Exception {
        String filepath1 = "src/test/resources/file1.yml";
        String filepath2 = "src/test/resources/file2.yml";
        String result = Files.readString(Path.of("src/test/resources/plainResult12.diff"));

        String diff = Differ.generate(filepath1, filepath2, PlainFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsJsonWithJsonFormatter() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String diff = Differ.generate(filepath1, filepath2, JsonFormatter.NAME);

        assertThat(diff.isEmpty()).isFalse();
    }

    @Test
    public void testParseJson() throws Exception {
        String filepath = "src/test/resources/file1.json";
        String fileContent = Files.readString(Path.of(filepath));

        Map<String, Object> map = Parser.parseJson(fileContent);
        assertThat(map.isEmpty()).isFalse();
    }

    @Test
    public void testParseYml() throws Exception {
        String filepath = "src/test/resources/file1.yml";
        String fileContent = Files.readString(Path.of(filepath));

        Map<String, Object> map = Parser.parseYml(fileContent);
        assertThat(map.isEmpty()).isFalse();
    }

}
