package com.example.hacaton2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hacaton2020.Entity.InspectionSheet;
import com.example.hacaton2020.Entity.InspectionSheets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private int id;
    private TextView fieldID;
    private TextView numOfSupports;
    private TextView defectView;
    private TextView deadline;
    private InspectionSheet inspectionSheet;
    private InspectionSheets inspectionSheets;
    List<InspectionSheet> inspectionSheetsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        InspectionSheet inspectionSheet1 = new InspectionSheet(0,"12","Возможно нарушена изоляция","","33.996432%2C45.48094");
        InspectionSheet inspectionSheet2 = new InspectionSheet(1,"3","Возможно неисправно электропитание","","33.996432%2C45.480943");

        inspectionSheetsList = new ArrayList<>();
        inspectionSheetsList.add(inspectionSheet1);
        inspectionSheetsList.add(inspectionSheet2);

        Intent intent = getIntent();

        id = intent.getIntExtra("id",0);

        inspectionSheets = new InspectionSheets(inspectionSheetsList,"33.526402%2C44.556972");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        fieldID = findViewById(R.id.fieldID);
        defectView = findViewById(R.id.defectView);
        numOfSupports = findViewById(R.id.numOfSupports);
        deadline = findViewById(R.id.deadline);

        showInfo();
    }

    public void back(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void goMap(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("https://yandex.ru/maps/959/sevastopol/?ll=%s&z=16",inspectionSheets.getCords())));
        startActivity(intent);


    }

    public void onBlank(View view) {

        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);

    }

    public void showInfo(){

        Iterator iter = inspectionSheetsList.iterator();

        while(iter.hasNext()){
            InspectionSheet inspection_sheet = (InspectionSheet) iter.next();
                if(inspection_sheet.getId()==id){
                    fieldID.setText("ID: "+Integer.toString(inspection_sheet.getId()));
                    defectView.setText("Дефекты: "+inspection_sheet.getDefect());
                    numOfSupports.setText("Номер стойки: "+inspection_sheet.getNumOfSupports());
                    deadline.setText("Дедлайн: "+inspection_sheet.getDeadline());
                }
                else{

                }
        }


    }
}