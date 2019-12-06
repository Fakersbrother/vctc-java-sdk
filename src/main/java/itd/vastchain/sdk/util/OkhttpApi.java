package itd.vastchain.sdk.util;

import itd.vastchain.sdk.exception.ApiResponseException;
import itd.vastchain.sdk.exception.VctcException;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkhttpApi {
    public  final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    private String uri;
    private Integer timeout;
    private final Integer DEFAULT_TIMEOUT = 15 * 1000;

    public OkhttpApi(String uri, Integer timeout) {
        this.uri = uri;
        if (timeout == null) {
            this.timeout = DEFAULT_TIMEOUT;
        }
    }

    private String call(Request request) throws VctcException {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .writeTimeout(timeout, TimeUnit.MILLISECONDS).readTimeout(timeout, TimeUnit.MILLISECONDS).build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException ex) {
            throw new ApiResponseException(ex.getMessage(), ex);
        }
    }

    public String post(String bodyJson) throws VctcException {
        RequestBody body = RequestBody.create(JSON_TYPE, bodyJson);
        Request request = new Request.Builder().url(uri)
                .post(body).build();
       return call(request);
    }

    public String get() throws VctcException {
        Request request = new Request.Builder().url(uri)
                .get().build();
        return call(request);
    }
}