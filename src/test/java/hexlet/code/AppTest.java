package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import hexlet.code.utils.Utils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    public static final String JSON_FILEPATH1 = "src/test/resources/file1.json";
    public static final String JSON_FILEPATH2 = "src/test/resources/file2.json";
    public static final String YML_FILEPATH1 = "src/test/resources/file1.yml";
    public static final String YML_FILEPATH2 = "src/test/resources/file2.yml";
    public static final String STYLISH_RESULT = "src/test/resources/stylishResult12.diff";
    public static final String PLAIN_RESULT = "src/test/resources/plainResult12.diff";
    public static final String JSON_RESULT = "src/test/resources/jsonResult12.diff";

    @Test
    public void testEqualsJsonWithDefaultFormatter() throws Exception {
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2);
        String result = Utils.readFile(STYLISH_RESULT);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithDefaultFormatter() throws Exception {
        String diff = Differ.generate(YML_FILEPATH1, YML_FILEPATH2);
        String result = Utils.readFile(STYLISH_RESULT);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsJsonWithStylishFormatter() throws Exception {
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2, StylishFormatter.NAME);
        String result = Utils.readFile(STYLISH_RESULT);

        assertThat(diff).isEqualTo(result);

    }

    @Test
    public void testEqualsJsonWithPlainFormatter() throws Exception {
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2, PlainFormatter.NAME);
        String result = Utils.readFile(PLAIN_RESULT);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsJsonWithJsonFormatter() throws Exception {
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2, JsonFormatter.NAME);
        String result = Utils.readFile(JSON_RESULT);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithStylishFormatter() throws Exception {
        String diff = Differ.generate(YML_FILEPATH1, YML_FILEPATH2, StylishFormatter.NAME);
        String result = Utils.readFile(STYLISH_RESULT);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithPlainFormatter() throws Exception {
        String diff = Differ.generate(YML_FILEPATH1, YML_FILEPATH2, PlainFormatter.NAME);
        String result = Utils.readFile(PLAIN_RESULT);

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEqualsYmlWithJsonFormatter() throws Exception {
        String diff = Differ.generate(YML_FILEPATH1, YML_FILEPATH2, JsonFormatter.NAME);
        String result = Utils.readFile(JSON_RESULT);

        assertThat(diff).isEqualTo(result);
    }

}
