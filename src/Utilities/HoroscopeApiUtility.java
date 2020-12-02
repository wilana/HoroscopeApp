package Utilities;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class HoroscopeApiUtility {
    private static String rapidApiKeyName = "x-rapidapi-key";
    private static String rapidApiKeyValue = "c0a77e70f0mshd6add42bee1793bp15d37ejsn0b7319d01ef5";


    /**
     * Creates JSON file of horoscope details associated with day and sign
     * @param day date for horoscope
     * @param sign sign for horoscope
     */
    public static void getHoroscopeFromSearch(String day, String sign) throws IOException, InterruptedException {
        clearFileContents("./src/JSONFiles/horoscopeSearch.json");

        String searchURL = "https://sameer-kumar-aztro-v1.p.rapidapi.com/?day=" + day + "&sign=" + sign ;
        HttpClient client = HttpClient.newHttpClient();
        // used sample code from https://rapidapi.com/sameer.kumar/api/aztro to help
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(searchURL))
                .header(rapidApiKeyName, rapidApiKeyValue)
                .header("x-rapidapi-host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("./src/JSONFiles/horoscopeSearch.json")));
    }

    /**
     * Returns just the sign, no format
     * @param year birth year
     * @param month birth month
     * @param day birth date
     */
    public static void getSignFromSearch(String year, String month, String day) throws IOException, InterruptedException {
        clearFileContents("./src/JSONFiles/signSearch.json");

        String date = year + "-" + month + "-" + day;

        String searchURL = "https://zodiac-sign.p.rapidapi.com/sign?date=" + date ;
        HttpClient client = HttpClient.newHttpClient();
        // used sample code from https://rapidapi.com/hajderr/api/zodiac-sign?endpoint=apiendpoint_91d0edd4-a719-41e7-855f-d71246ac993c
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(searchURL))
                .header(rapidApiKeyName, rapidApiKeyValue)
                .header("x-rapidapi-host", "zodiac-sign.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("./src/JSONFiles/signSearch.json")));
    }

    /**
     * Creates JSON file with all signs and their associated dates
     */
    public static void getAllSigns() throws IOException, InterruptedException {
        String searchURL = "https://zodiac-sign.p.rapidapi.com/signs";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(searchURL))
                .header(rapidApiKeyName, rapidApiKeyValue)
                .header("x-rapidapi-host", "zodiac-sign.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("./src/JSONFiles/allSigns.json")));
    }

    /**
     * Deletes file so overwriting won't be a problem
     * @param filePath
     */
    private static void clearFileContents (String filePath)
    {
        File file = new File(filePath);
        if (file.exists())
            file.delete();
    }
}


