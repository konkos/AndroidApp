package com.uom.androidapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Api_Call2 extends AsyncTask<Void, Void, Void > {

    private static final String KEY = "6708C63F-8DC9-47BF-B307-26D52EE88B59";

    @Override
    protected Void doInBackground(Void... voids) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://my.nbg.gr/identity/connect/authorize?client_id="+KEY+"&response_type=code&scope=sandbox-account-info-api-v2&redirect_uri=https://developer.nbg.gr/oauth2/redoc-callback")
                .get()
                .build();

        try {
            Response response = client.newCall(request).execute();
            Log.i("API_RESPONSE",response.toString());
            Log.i("BODY_RESPONSE",response.body().toString());
            Log.i("MESSAGE",response.message().toString());
            Log.i("RESPONSE_CODE",""+response.code());
            Log.i("RESPONSE_HEADER", response.headers().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
