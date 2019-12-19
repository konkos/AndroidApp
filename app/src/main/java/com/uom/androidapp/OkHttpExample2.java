package com.uom.androidapp;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpExample2 {

    // only one client
    private final OkHttpClient httpClient = new OkHttpClient();

    public void sendGET() throws IOException {

        Request request = new Request.Builder()
                .url("https://developer.nbg.gr/identity/connect/authorize")
                .addHeader("client_id", "6708C63F-8DC9-47BF-B307-26D52EE88B59")  // add request headers
                .addHeader("response_type", "query")
                .addHeader("scope", "openid profile role sandbox-account-info-api-v2")
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    // Get response headers
                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }

                    // Get response body
                    System.out.println(responseBody.string());
                }
            }
        });

    }
}