package com.example.hacaton2020.Entity;

import java.util.Date;

public class InspectionSheet {

    private int id;
    private String numOfSupports;
    private String defect;
    private String deadline;
    private String cords;



    public InspectionSheet(){

        id = 0;
        numOfSupports = "";
        defect = "";
        deadline = "";
        cords = "";

    }

    public InspectionSheet(int id, String numOfSupports, String defect, String deadline, String cords){

        this.id = id;
        this.numOfSupports = numOfSupports;
        this.defect = defect;
        this.deadline = deadline;
        this.cords = cords;

    }

    public int getId() {
        return id;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDefect() {
        return defect;
    }

    public String getNumOfSupports() {
        return numOfSupports;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public void setNumOfSupports(String numOfSupports) {
        this.numOfSupports = numOfSupports;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCords() {
        return cords;
    }

    public void setCords(String cords) {
        this.cords = cords;
    }
}
