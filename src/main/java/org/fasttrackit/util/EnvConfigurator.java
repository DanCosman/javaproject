package org.fasttrackit.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dcosman on 23/02/15.
 */
public class EnvConfigurator {
    static String ENVIRONMENT;
    private static Properties env;

    public static String baseUrl() {
        return env.getProperty("baseUrl");
    }

    public static String browser() {
        return env.getProperty("browser");
    }

    public static void setEnviroment() {
        String s = System.getProperty("env");
        if (s != null)
            ENVIRONMENT = s;
        else
            ENVIRONMENT = "staging";

        env = new Properties();
        InputStream stream;
        try {
            stream = new FileInputStream("./src/main/java/org/fasttrackit/util/" + ENVIRONMENT + ".properties");
            env.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
