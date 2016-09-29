package ru.levelp.utils;

import com.google.gson.Gson;
import ru.levelp.api.RequestContainer;
import ru.levelp.api.ResponseContainer;

public class JsonUtil {
    private static final JsonUtil instance = new JsonUtil();
    private Gson gson = new Gson();

    private JsonUtil() {

    }

    public static JsonUtil getInstance() {
        return instance;
    }

    public RequestContainer jsonToRequest(String json) {
        return gson.fromJson(json, RequestContainer.class);
    }

    public String responseToJson(ResponseContainer object) {
        return gson.toJson(object);
    }

}
