package ru.Kirill99m.Repository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class LocalUserData {
    private static final LocalUserData localDataRepository = new LocalUserData();
    final HashMap<Integer, String> hometown;
    final HashMap<Integer, String> region;

    private LocalUserData() {
        Properties properties = new Properties();
        try (InputStream is = LocalUserData.class.getClassLoader().getResourceAsStream("userData.properties")) {
            properties.load(Objects.requireNonNull(is));
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
        region = new HashMap<>();
        getRandomDataFromFile(properties.getProperty("region"), region);
        hometown = new HashMap<>();
        getRandomDataFromFile(properties.getProperty("city"), hometown);
    }

    static LocalUserData getLocalData() {
        return localDataRepository;
    }

    private static void getRandomDataFromFile(String path, HashMap<Integer, String> dataMap) {
        try (InputStream stream = LocalUserData.class.getClassLoader().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader((Objects.requireNonNull(stream)), StandardCharsets.UTF_8))) {
            String line;
            int i = 0;

            while ((line = reader.readLine()) != null) {
                dataMap.put(i++, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
