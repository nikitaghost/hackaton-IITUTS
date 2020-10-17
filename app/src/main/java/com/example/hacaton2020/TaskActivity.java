package com.example.hacaton2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hacaton2020.Entity.InspectionSheet;
import com.example.hacaton2020.Entity.InspectionSheets;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    private int id;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        InspectionSheet inspectionSheet1 = new InspectionSheet(0,"12","Возможно нарушена изоляция","","33.996432%2C45.48094");
        InspectionSheet inspectionSheet2 = new InspectionSheet(1,"3","Возможно неисправно электропитание","","33.996432%2C45.480943");

        List<InspectionSheet> inspectionSheetsList = new ArrayList<>();
        inspectionSheetsList.add(inspectionSheet1);
        inspectionSheetsList.add(inspectionSheet2);

        InspectionSheets inspectionSheets = new InspectionSheets(inspectionSheetsList,"33.526402%2C44.556972");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        textView3 = findViewById(R.id.textView3);

        id = 0;
        InspectionSheet inspectionSheet = inspectionSheets.getInspectionSheets().get(id);






    }

    public void back(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void goMap(View view) {



    }

    public void onBlank(View view) {

        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);

    }
}