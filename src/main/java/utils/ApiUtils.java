package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import config.Config;
import okhttp3.*;

import java.io.IOException;

import static okhttp3.RequestBody.create;

public class ApiUtils {

    public static OkHttpClient client;

    static {
        client = new OkHttpClient();
    }


    public static JsonObject loginDashboard(String username, String password) {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = create(mediaType, String.format("{\"email\": \"%s\",\"password\":\"%s\"}", username, password));
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
