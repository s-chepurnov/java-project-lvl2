package hexlet.code.differ;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

    @Test
    public void testEquals() throws Exception {
        String json1 = "{\n"
                + "  \"host\": \"hexlet.io\",\n"
                + "  \"timeout\": 50,\n"
                + "  \"proxy\": \"123.234.53.22\",\n"
                + "  \"follow\": false\n"
                + "}";
        String json2 = "{\n"
                + "  \"timeout\": 20,\n"
                + "  \"verbose\": true,\n"
                + "  \"host\": \"hexlet.io\"\n"
                + "}";
        String diff = Differ.generate(json1, json2);

        String result = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        assertThat(diff).isEqualTo(result);
    }

    @Test
    public void testEmpty() throws Exception {
        String emptyJson1 = "{}";
        String emptyJson2 = "{}";
        String diff = Differ.generate(emptyJson1, emptyJson2);
        String result = "{}";

        assertThat(diff).isEqualTo(result);
    }
}
