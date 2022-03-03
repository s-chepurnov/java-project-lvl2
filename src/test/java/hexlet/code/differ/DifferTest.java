package hexlet.code.differ;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DifferTest {

    @Test
    public void testEquals() throws Exception {
        String json1 = Files.readString(Path.of("src/test/resources/file1.json"));
        String json2 = Files.readString(Path.of("src/test/resources/file2.json"));
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

    @Test
    public void testParse() throws Exception {
        String json = Files.readString(Path.of("src/test/resources/file1.json"));
        Map<String, Object> map = Differ.parse(json);
        assertThat(map.isEmpty()).isFalse();

        String emptyJson = "{}";
        Map<String, Object> emptyMap = Differ.parse(emptyJson);
        assertThat(emptyMap.isEmpty()).isTrue();
    }
}
