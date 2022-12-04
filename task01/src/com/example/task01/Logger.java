package com.example.task01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Logger {
    private static List<Logger> logs = new ArrayList<>();
    private String name;
    private String message;
    public String getName() {
        return name;
    }
    public static Logger getLogger(String name) {
        for (Logger log: logs) {
            if (Objects.equals(log.name, name))
                return log;
        }
        return null;
    }

}
