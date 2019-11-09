package ru.Kirill99m.Repository;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static io.restassured.RestAssured.get;

public class UserData {
    private static final LocalUserData localData = LocalUserData.getLocalData();
    private static JSONObject jsonUser;
    private static boolean connectionIndicator;

    private static String gender;

    public static void UseApi() {
        try {

            Response response = get("https://randus.org/api.php");
            connectionIndicator = response.getStatusCode() == 200;
            if (connectionIndicator) {
                jsonUser = new JSONObject(response.asString());
            }
        } catch (Exception e) {
            connectionIndicator = false;
            jsonUser = null;
        }
    }

    public static String getHometown() {
        return localData.hometown.get((int) (Math.random() * localData.hometown.size()));
    }

    public static String getGender() {
        return jsonUser.getString("gender").equals("w") ? "Ж" : "М";
    }

    public static String getFirstName() {
        return jsonUser.getString("fname");
    }

    public static String getLastName() {
        return jsonUser.getString("lname");
    }

    public static String getSecondName() {
        return jsonUser.getString("patronymic");
    }

    public static String getCountry() {
        String country = "Россия";
        return country;
    }

    public static String getRegion() {
        return localData.region.get((int) (Math.random() * localData.region.size()));
    }

    public static String getCity() {
        return jsonUser.getString("city");
    }

    public static String getStreet() {
        return jsonUser.getString("street");
    }

    public static int getHomeNumber() {
        return jsonUser.getInt("house");
    }

    public static int getFlatNumber() {
        return jsonUser.getInt("apartment");
    }

    public static int getIndex() {
        return (int) (Math.random() * 100_001 + 100_000);
    }

    public static LocalDate getBirthDate() {
        return LocalDate.parse(jsonUser.getString("date"), DateTimeFormatter.ofPattern("d MMMM yyyy").withLocale(new Locale("ru", "RUS")));
    }


}