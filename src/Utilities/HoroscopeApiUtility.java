package Utilities;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class HoroscopeApiUtility {
    private static String rapidApiKeyName = "rapidapi-key";
    private static String rapidApiKeyValue = "c0a77e70f0mshd6add42bee1793bp15d37ejsn0b7319d01ef5";

    public static void getHoroscopeFromSearch(String day, String sign) throws IOException, InterruptedException {
        String searchURL = "https://sameer-kumar-aztro-v1.p.rapidapi.com/?day=" + day + "&sign=" + sign ;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(searchURL))
                .header("x-rapidapi-key", rapidApiKeyValue)
                .header("x-rapidapi-host", "sameer-kumar-aztro-v1.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("./src/JSONFiles/horoscopeSearch.json")));
    }

    public static void getSignFromSearch(String year, String month, String day) throws IOException, InterruptedException {
        String date = year + "-" + month + "-" + day;

        String searchURL = "https://zodiac-sign.p.rapidapi.com/sign?date=" + date ;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(searchURL))
                .header(rapidApiKeyName, rapidApiKeyValue)
                .build();

        HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("./src/JSONFiles/signSearch.json")));
    }
}


