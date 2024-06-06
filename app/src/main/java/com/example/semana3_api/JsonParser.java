package com.example.semana3_api;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {

    public static String parseUsers(String json) {
        StringBuilder result = new StringBuilder();

        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String username = jsonObject.getString("username");
                String email = jsonObject.getString("email");

                JSONObject addressObject = jsonObject.getJSONObject("address");
                String city = addressObject.getString("city");

                // Append the parsed data to the result StringBuilder
                result.append(username)
                        .append(", ").append(city)
                        .append(", ").append(email)
                        .append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}