package hexlet.code;

import com.fasterxml.jackson.databind.JsonMappingException;
import hexlet.code.differ.Differ;
import hexlet.code.differ.Parser;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import hexlet.code.utils.Utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void testEqualsJsonWithStylishFormatter() throws Exception {
        Path filePath1 = Path.of("src/test/resources/file1.json");
        Path filePath2 = Path.of("src/test/resources/file2.json");
        String result = Files.readString(Path.of("src/test/resources/stylishResult12.diff"));

        String fileContent1 = Files.readString(filePath1);
        String fileContent2 = Files.readString(filePath2);
        String diff = Differ.generate(fileContent1, fileContent2,
                Utils.getFileExtension(filePath1.toString()), StylishFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsJsonWithPlainFormatter() throws Exception {
        Path filePath1 = Path.of("src/test/resources/file1.json");
        Path filePath2 = Path.of("src/test/resources/file2.json");
        String result = Files.readString(Path.of("src/test/resources/plainResult12.diff"));

        String fileContent1 = Files.readString(filePath1);
        String fileContent2 = Files.readString(filePath2);
        String diff = Differ.generate(fileContent1, fileContent2,
                Utils.getFileExtension(filePath1.toString()), PlainFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithStylishFormatter() throws Exception {
        Path filePath1 = Path.of("src/test/resources/file1.yml");
        Path filePath2 = Path.of("src/test/resources/file2.yml");
        String result = Files.readString(Path.of("src/test/resources/stylishResult12.diff"));

        String fileContent1 = Files.readString(filePath1);
        String fileContent2 = Files.readString(filePath2);
        String diff = Differ.generate(fileContent1, fileContent2,
                Utils.getFileExtension(filePath1.toString()), StylishFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithPlainFormatter() throws Exception {
        Path filePath1 = Path.of("src/test/resources/file1.yml");
        Path filePath2 = Path.of("src/test/resources/file2.yml");
        String result = Files.readString(Path.of("src/test/resources/plainResult12.diff"));

        String fileContent1 = Files.readString(filePath1);
        String fileContent2 = Files.readString(filePath2);
        String diff = Differ.generate(fileContent1, fileContent2,
                Utils.getFileExtension(filePath1.toString()), PlainFormatter.NAME);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsJsonWithJsonFormatter() throws Exception {
        Path filePath1 = Path.of("src/test/resources/file1.json");
        Path filePath2 = Path.of("src/test/resources/file2.json");

        String fileContent1 = Files.readString(filePath1);
        String fileContent2 = Files.readString(filePath2);
        String diff = Differ.generate(fileContent1, fileContent2,
                Utils.getFileExtension(filePath1.toString()), JsonFormatter.NAME);

        assertThat(diff.isEmpty()).isFalse();
    }

    @Test
    public void testEmpty() throws Exception {
        String result = "{}";

        //json
        String diffJson = Differ.generate("{}", "{}", "json", StylishFormatter.NAME);
        assertThat(diffJson).isEqualTo(result);

        //yaml
        Exception thrown = assertThrows(
                JsonMappingException.class,
                () -> Differ.generate("", "", "yml", StylishFormatter.NAME)
        );

        assertTrue(thrown.getMessage().contains("No content to map due to end-of-input"));
    }

    @Test
    public void testParseJson() throws Exception {
        Path filePath = Path.of("src/test/resources/file1.json");
        String fileContent = Files.readString(filePath);

        Map<String, Object> map = Parser.parseJson(fileContent);
        assertThat(map.isEmpty()).isFalse();
    }

    @Test
    public void testParseYml() throws Exception {
        Path filePath = Path.of("src/test/resources/file1.yml");
        String fileContent = Files.readString(filePath);

        Map<String, Object> map = Parser.parseYml(fileContent);
        assertThat(map.isEmpty()).isFalse();
    }
}
