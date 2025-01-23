
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class weather {
    private static final String BASE_URL = "https://api.openweathermap.org/";
    private static final String API_KEY = "&appid=04afad80f7b95195a3a9e49fa1659949";

    public static void main(String[] args) {
        askZipShowWeather();
    }

    public static void askZipShowWeather() {
        try (Scanner kbReader = new Scanner(System.in)) {
            System.out.println("Enter zip code: ");
            String zip = kbReader.next();
            String data = getWeatherByZipcode(zip);
            System.out.println("Lets check Weather for " + zip + ":");
            System.out.println(data);
        }
    }

    private static String getWeatherByZipcode(String zip) {
        List<String> coords = getCityCoordinates(zip);
        String lat = coords.get(0);
        String lon = coords.get(1);
        String data = getWeatherByCoords(lat, lon);
        return data;
    }

    private static String getWeatherByCoords(String lat, String lon) {
        String params = String.format( "data/2.5/weather?lat=%s&lon=%s", lat, lon);
        String url = BASE_URL + params + API_KEY;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (response != null && response.statusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
        }
        String data = response.body();
        JsonObject obj = JsonParser.parseString(data).getAsJsonObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        data = gson.toJson(obj);
        return data;
    }

    private static List<String> getCityCoordinates(String zip){
        String params = String.format("geo/1.0/zip?zip=%s,US", zip) ;
        String url = BASE_URL + params + API_KEY;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (response != null && response.statusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.statusCode());
        }
        String data = response.body();
        JsonObject obj = JsonParser.parseString(data).getAsJsonObject();
        
        List<String> coords = new ArrayList<>();
        coords.add(obj.get("lat").toString());
        coords.add(obj.get("lon").toString());
        return coords;
    }
}
