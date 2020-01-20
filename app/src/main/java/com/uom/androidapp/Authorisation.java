package com.uom.androidapp;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;


public class Authorisation extends AsyncTask<Void, Void, Void>{
    @Override
    protected Void doInBackground(Void... voids) {
        //URL url = new URL("");
        return null;
    }

   /* @Override
    protected Response doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody =
        Request request = new Request.Builder()
                .url("https://my.nbg.gr/identity/connect/authorize?client_id=198E37FF-338C-452D-A9E4-1F6831286ED1&response_type=code&scope=get-token-api-v1&redirect_uri=https://developer.nbg.gr/oauth2/redoc-callback")
                .post()
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }*/

    /*@Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        Log.i("Response",response.toString());
        Log.i("Response",response.headers().toString());
    }*/
}
