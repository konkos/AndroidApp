package com.uom.androidapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class API_CALL extends AsyncTask<String, Void, String> {
    private static final String KEY = "6708C63F-8DC9-47BF-B307-26D52EE88B59";
    private static final String TAG = "KOSTAS";


    @Override
    protected String doInBackground(String... strings) {
        Log.d(TAG, "doInBackground starts with: " + strings[0]);
        String postData = downloadJSON(strings[0]);
        if(postData == null){
            Log.e(TAG, "doInBackground: Error downloading from url " + strings[0] );
        }
        return postData;
    }

    private String downloadJSON(String urlPath) {
        StringBuilder sb = new StringBuilder();

        try{
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            int reponseCode = connection.getResponseCode();
            Log.d(TAG, "downloadJSON: Response code was " + reponseCode);

            if(reponseCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = reader.readLine();
                while(line != null){
                    sb.append(line).append("\n");
                    line = reader.readLine();
                }
                reader.close();
            }
        } catch (MalformedURLException e) {
            Log.e(TAG, "downloadJSON: not correct URL: "+urlPath , e);
        } catch (IOException e) {
            Log.e(TAG, "downloadJSON: io error ",e);
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.i("POSTEXECUTE",s.toString());
    }
}
