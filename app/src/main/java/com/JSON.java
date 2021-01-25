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
            String jsonText2 = "{"+"\"beers\":"+jsonText + "}";
            JSONObject json = new JSONObject(jsonText2);
            return json;
        } finally {
            is.close();
        }
    }
    public static JSONArray getJSONArray(JSONObject json) throws JSONException {

        //JSONObject to JSONArray
        JSONArray jsonArray = json.getJSONArray("beers");

        return jsonArray;
    }

    public static ArrayList<Beer> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Beer> beersList = new ArrayList<Beer>();
        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Beer beer = new Beer(
                    json_data.getString("id"),
                    json_data.getString("name"),
                    json_data.getString("tagline"),
                    json_data.getString("first_brewed"),
                    json_data.getString("description")

            );
            beersList.add(beer);
        }
        return beersList;
    }

    public static ArrayList<Beer> getBeerListByName(ArrayList<Beer> beersList, String drinkName) {
        drinkName= drinkName.substring(0,1).toUpperCase() + drinkName.substring(1).toLowerCase();
        ArrayList<Beer> beerListByName = new ArrayList<Beer>();
        for (Beer beer : beersList) {
            if (beer.getDrinkName().contains(drinkName)) {
                beerListByName.add(beer);
            }
        }
        return beerListByName;
    }

}