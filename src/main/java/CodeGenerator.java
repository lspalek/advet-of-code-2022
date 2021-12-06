import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class CodeGenerator {
    public static void main(String[] args) throws IOException {
        String originalDayNumber = "06";
        String copyDayNumber = "06b";

        var replaceMap = Map.of("Day" + originalDayNumber, "Day" + copyDayNumber,
                "day" + originalDayNumber, "day" + copyDayNumber);
        copyFileAndReplace("src/main/java/Day%s.java", originalDayNumber, copyDayNumber, replaceMap);
        copyFileAndReplace("src/test/java/Day%sTest.java", originalDayNumber, copyDayNumber, replaceMap);
        copyFileAndReplace("src/main/resources/day%s.txt", originalDayNumber, copyDayNumber, null);
        copyFileAndReplace("src/main/resources/day%s-example.txt", originalDayNumber, copyDayNumber, null);

    }

    private static void copyFileAndReplace(String pattern, String originalDayNumber, String copyDayNumber, Map<String, String> replaceMap) throws IOException {
        File originalClass = new File(String.format(pattern, originalDayNumber));
        File copiedClass = new File(String.format(pattern, copyDayNumber));
        com.google.common.io.Files.copy(originalClass, copiedClass);

        replaceStringsInFile(copiedClass, replaceMap);
    }

    private static void replaceStringsInFile(File file, Map<String, String> replaceMap) throws IOException {
        if (replaceMap == null || replaceMap.isEmpty()) return;

        String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        for (Map.Entry<String, String> entry : replaceMap.entrySet()) {
            content = content.replaceAll(entry.getKey(), entry.getValue());
        }
        FileUtils.write(file, content, StandardCharsets.UTF_8);
    }
}
