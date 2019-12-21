package com.uom.androidapp;

import android.os.AsyncTask;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class PireausCall extends AsyncTask<Void, Void, Void> {
/*
    OkHttpClient client;
    RequestBody requestBody;
    Request request;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        client = new OkHttpClient();

        requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("somParam", "someValue")
                .build();


        request = new Request.Builder()
                .url("https://api.rapidlink.piraeusbank.gr/piraeusbank/production/v2.1/oauth/external/introspect")
                .post()
                .addHeader("x-ibm-client-id", "565fb41c-616b-4c06-92d0-98e6c0f38103")
                .addHeader("accept", "application/json")
                .build();
    }

    @Override
    protected Void doInBackground(Void... voids) {


        Log.i("Request", request.toString());

        try {
            Response response = client.newCall(request).execute();
            Log.i("Request", response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/



    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.rapidlink.piraeusbank.gr/piraeusbank/production/v2.1/oauth/oauth2/authorize?response_type=query&client_id=565fb41c-616b-4c06-92d0-98e6c0f38103&scope=REPLACE_THIS_VALUE")
                .get()
                .addHeader("accept", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();
            Log.i("Response",response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
