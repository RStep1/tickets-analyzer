package com.rstep1.util;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CommandArgumentParser {
    public static String parseFilePath(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Не указан путь к файлу. Пример: java -jar tickets-analyzer.jar tickets.json");
        }
        String filePath = args[0];

        if (!Files.exists(Paths.get(filePath))) {
            throw new IllegalArgumentException(String.format("Файл %s не найден", filePath));
        }
        return filePath;
    }
}
