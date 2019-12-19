package com.uom.androidapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Sandbox extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... voids) {
/*        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"header\":{\"ID\":\"<ADD STRING VALUE>\",\"application\":\"<ADD STRING VALUE>\"},\"payload\":{\"sandboxId\":\"<ADD STRING VALUE>\"}}");
        Request request = new Request.Builder()
                .url("https://apis.nbg.gr/sandbox/payment.initiation/oauth2/v2/sandbox")
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "SOME_STRING_VALUE")
                .addHeader("client-id", "6708C63F-8DC9-47BF-B307-26D52EE88B59")
                .build();

        Request.Builder response = request.newBuilder().post(request);*/

        URL url = null;
        try {
            url = new URL("https://apis.nbg.gr/sandbox/payment.initiation/oauth2/v2/sandbox/client-id=\"6708C63F-8DC9-47BF-B307-26D52EE88B59\"/content-type=\"application/json\"/authorization=SOME_STRING_VALUE");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            int responseCode = urlConnection.getResponseCode();
            String responseMessage = urlConnection.getResponseMessage();

            Log.i("responseCode", responseCode+"");
            Log.i("responseMessage",responseMessage);
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
