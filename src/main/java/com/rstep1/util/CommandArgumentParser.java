package com.rstep1.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class CommandArgumentParser {
    public static Optional<String> parseFilePath(String[] args) {
        if (args.length == 0) {
            System.err.println("Ошибка: укажите путь к файлу");
            System.err.println("Пример: java -jar tickets-analyzer.jar tickets.json");
            return Optional.empty();
        }
        String filePath = args[0];

        if (!Files.exists(Paths.get(filePath))) {
            System.err.println(String.format("Ошибка: файл %s не найден", filePath));
            return Optional.empty();
        }
        return Optional.of(filePath);
    }
}
