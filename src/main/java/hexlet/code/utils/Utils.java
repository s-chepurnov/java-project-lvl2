package hexlet.code.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {

    public static String getFileExtension(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("fileName must not be null!");
        }

        String extension = "";

        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }

        return extension;
    }

    public static String readFile(String filepath) throws IOException {
        final String fileContent = Files.readString(Path.of(filepath));
        return fileContent;
    }
}
