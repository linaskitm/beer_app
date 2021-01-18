package com;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JSON {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
    public static JSONArray getJSONArray(JSONObject json) throws JSONException {

        //JSONObject to JSONArray
        JSONArray jsonArray = json.getJSONArray("drinks");

        return jsonArray;
    }

    public static ArrayList<Coctail> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Coctail> coctailsList = new ArrayList<Coctail>();
        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Coctail coctail = new Coctail(
                    json_data.getString("idDrink"),
                    json_data.getString("strDrink"),
                    json_data.getString("strAlcoholic"),
                    json_data.getString("strCategory"),
                    json_data.getString("strGlass"),
                    json_data.getString("strIngredient1"),
                    json_data.getString("strIngredient2"),
                    json_data.getString("strIngredient3")
            );
            coctailsList.add(coctail);
        }
        return coctailsList;
    }

    public static ArrayList<Coctail> getCoctailListByName(ArrayList<Coctail> coctailsList, String drinkName) {
        drinkName= drinkName.substring(0,1).toUpperCase() + drinkName.substring(1).toLowerCase();
        ArrayList<Coctail> coctailListByName = new ArrayList<Coctail>();
        for (Coctail coctail : coctailsList) {
            if (coctail.getDrinkName().contains(drinkName)) {
                coctailListByName.add(coctail);
            }
        }
        return coctailListByName;
    }

}