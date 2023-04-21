package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.*;
import config.Config;

import java.io.IOException;

public class ApiUtils {

    public static OkHttpClient client;

    static {
        client = new OkHttpClient();
    }


    public static JsonObject loginDashboard(String username, String password) {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, String.format("{\"email\": \"%s\",\"password\":\"%s\"}", username, password));
        Request request = new Request.Builder()
                .addHeader("content-type", "application/json")
                .url(Config.BACKEND_URL + "/api/v1/auth/customer")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return JsonParser
                    .parseString(response.body().string())
                    .getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
