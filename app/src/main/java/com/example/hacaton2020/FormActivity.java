package com.example.hacaton2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;

import com.example.hacaton2020.Entity.InspectionSheet;
import com.example.hacaton2020.Entity.InspectionSheets;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity {

    File directory;

    final int REQUEST_CODE_PHOTO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void onSend(View view) {

        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);

    }

    public void goToCam(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);

    }

    private static class GetTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            StringBuilder result = new StringBuilder();
            URL url = null;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = bufferedReader.readLine();
                while (line != null){
                    result.append(line);
                    line = bufferedReader.readLine();
                }
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
            }

            return result.toString();
        }
    }
}