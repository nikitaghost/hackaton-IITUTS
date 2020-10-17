package com.example.hacaton2020;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hacaton2020.Entity.InspectionSheet;
import com.example.hacaton2020.Entity.InspectionSheets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLinearLayout;
    private int connection = 0;
    private View.OnClickListener buttonsOnClick;

    private InspectionSheets inspectionSheets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);

        InspectionSheet inspectionSheet1 = new InspectionSheet(0,"12","Возможно нарушена изоляция","","33.996432%2C45.48094");
        InspectionSheet inspectionSheet2 = new InspectionSheet(1,"3","Возможно неисправно электропитание","","33.996432%2C45.480943");

        List<InspectionSheet> inspectionSheetsList = new ArrayList<>();
        inspectionSheetsList.add(inspectionSheet1);
        inspectionSheetsList.add(inspectionSheet2);

        inspectionSheets = new InspectionSheets(inspectionSheetsList,"33.526402%2C44.556972");

        addButtons(inspectionSheets);

    }



    private void addButtons(InspectionSheets inspectionSheets){

        Button[] buttons = new Button[inspectionSheets.getInspectionSheets().size()];
        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new Button(this);
            buttons[i].setId(i);
            buttons[i].setMaxWidth(100);
            buttons[i].setMinHeight(10);
            buttons[i].setTextSize(20);
            buttons[i].setTextAlignment(2);
            final int finalI = inspectionSheets.getInspectionSheets().get(i).getId();
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TaskActivity.class);
                    intent.putExtra("id", finalI);
                    startActivity(intent);

                }
            });

            buttons[i].setTransformationMethod(null);
            buttons[i].setText(String.format("Распоряжение №%d.",inspectionSheets.getInspectionSheets().get(i).getId()));
            mainLinearLayout.addView(buttons[i]);

        }
    }

    public void logout(View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }


    private static class GetTask extends AsyncTask<String, Void, String>{

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