package com.example.hacaton2020.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InspectionSheets {

    private List<InspectionSheet> inspectionSheets;
    private Date date;
    private String cords;

    public InspectionSheets(){
        inspectionSheets = new ArrayList<InspectionSheet>();
        date = new Date();
        cords="";
    }

    public InspectionSheets(List<InspectionSheet> inspectionSheets, String cords){
        this.inspectionSheets = inspectionSheets;
        this.date = new Date();
        this.cords = cords;
    }

    public InspectionSheets(List<InspectionSheet> inspectionSheets, Date date, String cords){
        this.inspectionSheets = inspectionSheets;
        this.date = date;
        this.cords = cords;
    }

    public List<InspectionSheet> getInspectionSheets() {
        return inspectionSheets;
    }

    public void setInspectionSheets(List<InspectionSheet> inspectionSheets) {
        this.inspectionSheets = inspectionSheets;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCords() {
        return cords;
    }

    public void setCords(String cords) {
        this.cords = cords;
    }
}
