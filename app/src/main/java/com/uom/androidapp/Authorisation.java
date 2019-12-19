package com.uom.androidapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Authorisation extends AsyncTask<Void, Void, Response>{
    @Override
    protected Response doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://my.nbg.gr/identity/connect/authorize?client_id=198E37FF-338C-452D-A9E4-1F6831286ED1&response_type=code&scope=get-token-api-v1&redirect_uri=")
                .get()
                .build();

        Response response = null;
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
        Log.i("Response",response.toString());
        Log.i("Response",response.headers().toString());
    }
}
