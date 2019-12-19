package com.uom.androidapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AccessToken extends AsyncTask<Void, Void, Response>{



    @Override
    protected Response doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Response response = null;

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_id=198E37FF-338C-452D-A9E4-1F6831286ED1&client_secret=AABEB6CB-4B8F-49E7-9DE4-1DE1AF0A15ED&grant_type=authorization_code&redirect_uri=https://developer.nbg.gr/oauth2/redoc-callback");
        Request request = new Request.Builder()
                .url("https://my.nbg.gr/identity/connect/token")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        Log.i("onResponse", response.toString());
    }

/*
    @Override
    protected Void doInBackground(Void... voids) {

        OkHttpClient client;
        client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
         RequestBody body = RequestBody.create(mediaType, "client_id=00000000-0000-0000-0000-000000000000&client_secret=00000000-0000-0000-0000-000000000000&grant_type=authorization_code&redirect_uri=https%3A%2F%2Fmy_applications_redirect_uri%2F"); equest request = new Request.Builder()
                .url("https://my.nbg.gr/identity/connect/token")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();


//For the client_credentials flow use this Body Request:

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded"); RequestBody body = RequestBody.create(mediaType, "client_id=00000000-0000-0000-0000-000000000000&client_secret=00000000-0000-0000-0000-000000000000&grant_type=client_credentials&scope=scope-1%20scope-2"); Request request = new Request.Builder()
                .url("https://my.nbg.gr/identity/connect/token")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();

//For the refresh_token flow use this Body Request:

        try {
            refreshToken("client_id=00000000-0000-0000-0000-000000000000&client_secret=00000000-0000-0000-0000-000000000000&grant_type=refresh_token&refresh_token=refresh_token_from_previous_refresh_token_request");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void refreshToken(String s) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, s);
        Request request = new Request.Builder()
                .url("https://my.nbg.gr/identity/connect/token")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
    }*/
}
