package com.example.forma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DateFormat;
import java.util.Calendar;

public class model {
    private String date,somthg;
    private  String money;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public model(String money) {
        this.money = money;
    }

    public model(String somthg , String money) {
        this.somthg = somthg;
        this.money = money;
        Calendar calendar = Calendar.getInstance();
        date = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    }

    public model(String money, String date, String somthg) {
        this.money = money;
        this.date = date;
        this.somthg = somthg;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSomthg() {
        return somthg;
    }

    public void setSomthg(String somthg) {
        this.somthg = somthg;
    }
    public model() {

    }
}
