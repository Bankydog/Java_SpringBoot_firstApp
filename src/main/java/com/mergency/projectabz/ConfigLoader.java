package com.mergency.projectabz;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigLoader {
    public static void loadEnv() {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });
    }
}
