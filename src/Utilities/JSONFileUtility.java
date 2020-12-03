package Utilities;

import Models.AllSigns;
import Models.Horoscope;
import Models.Sign;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JSONFileUtility {

    /**
     * Take info from jsonFile to create ArrayList of sign objects
     * @param jsonFileName
     * @return
     */
    public static ArrayList<Sign> getSignList(String jsonFileName)
    {
        ArrayList<Sign> signList = new ArrayList<>();
        Gson gson = new Gson();

        try (
                FileReader fileReader = new FileReader(jsonFileName);
                JsonReader jsonReader= new JsonReader(fileReader);
                )
        {
            // get all signs
            Sign[] signs = gson.fromJson(jsonReader, Sign[].class);
            AllSigns allSigns = new AllSigns(signs);
            // save all signs to arrayList
            signList.addAll(Arrays.asList(allSigns.getSigns()));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return signList;
    }

    /**
     * Gets the sign from the top line of the file at fileName
     * @param fileName file to read sign from
     * @return astrological sign
     */
    public static String getSignSearch(String fileName)
    {
        //The Json from getSignFromSearch in HoroscopeApiUtility only saves one word
        String sign = "";
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            sign = scanner.nextLine();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sign;
    }

    public static Horoscope getHoroscope(String jsonFileName)
    {
        ArrayList<Horoscope> horoscopes = new ArrayList<>();
        Gson gson = new Gson();

        try (
                FileReader fileReader = new FileReader(jsonFileName);
                JsonReader jsonReader= new JsonReader(fileReader);
        )
        {
            // get horoscope
            Horoscope horoscope = gson.fromJson(jsonReader, AllSigns.class);
            // save horoscope to arrayList
            horoscopes.addAll(Arrays.asList(horoscope));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        // only return first horoscope
        return horoscopes.get(0);
    }
}
