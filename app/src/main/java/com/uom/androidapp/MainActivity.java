package com.uom.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {



    //CHECK FOR AUTHORIZATION INFO
    //https://rapidlink.piraeusbank.gr/node/155

    //Check for apis
    //https://developer.mastercard.com/apis

    /*
    If the application you want to implement is not a web application, and you cannot provide a redirect url to be called,
     there is a technical solution to get the intermediate code.  In a desktop application, a web control must be used to initiate the authorization proccess,
     and a dummy redirect url.  When the user provides his/her credentials and authorizes your application for access, this control will try to redirect to the dummy redirect url,
     which will contain the code as a parameter.  This is the parameter you need to capture, in order to use it for the token call (second step).


    https://www.oauth.com/oauth2-servers/redirect-uris/
    https://www.oauth.com/oauth2-servers/redirect-uris/redirect-uri-registration/
    https://www.oauth.com/oauth2-servers/redirect-uris/redirect-uris-native-apps/
    https://www.oauth.com/oauth2-servers/redirect-uris/redirect-uri-validation/
    https://www.oauth.com/


     *
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new API_CALL().execute("");

       new Api_Call2().execute();


//        /*opens The url provided in a new Browser*/
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=-oDNDnLuIpw"));
//        startActivity(browserIntent);
    }

 /*   private class DownloadData extends AsyncTask<String, Void, String> {
        private static final String TAG = "TeoDownloadDataTask";

        @Override
        protected void onPostExecute(String jsonData) {
            super.onPostExecute(jsonData);
            Log.d(TAG, "onPostExecute: " +jsonData);

        }

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

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line = reader.readLine();
                while(line != null){
                    sb.append(line).append("\n");
                    line = reader.readLine();
                }

                reader.close();

            } catch (MalformedURLException e) {
                Log.e(TAG, "downloadJSON: not correct URL: "+urlPath , e);
            } catch (IOException e) {
                Log.e(TAG, "downloadJSON: io error ",e);
            }

            return sb.toString();
        }*/

}
