package utils;

import java.io.*;

public class FileUtils {
    public static String getApiKey() {
        try {
            String propertiesFileName = System.getProperty("user.dir") + File.separator + "config.properties";
            FileReader propertiesFile = new FileReader(propertiesFileName);
            BufferedReader br = new BufferedReader(propertiesFile);
            String line;
            while((line = br.readLine()) != null) {
                if (line.contains("apiKey")) {
                    return line.split("=")[1];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
