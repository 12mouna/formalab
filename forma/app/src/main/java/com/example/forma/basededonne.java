package com.example.forma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class basededonne extends SQLiteOpenHelper {
    public basededonne( Context context) {

        super(context, "model", null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String table="CREATE TABLE model(id integer primary key ,somthing text ,money text,date text)";
        db.execSQL(table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete="DROP TABLE IF EXISTS model";
        db.execSQL(delete);
        onCreate(db);

    }
    public void ajoutersomthg(model model){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("somthing",model.getSomthg());
        contentValues.put("money",model.getMoney());
        contentValues.put("date",model.getDate());
        db.insert("model",null,contentValues);
    }
    public ArrayList<model> afficher(){
        SQLiteDatabase db= getReadableDatabase();
        String selectall= "SELECT * FROM model";
        Cursor cursor=db.rawQuery(selectall,null);
        ArrayList<model> models=new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                model model= new model();
                model.setSomthg(cursor.getString(1));
                model.setId(cursor.getInt(0));
                model.setMoney(cursor.getString(2));
                model.setDate(cursor.getString(3));
                models.add(model);
            }while(cursor.moveToNext());
        }

        return  models;

    }
    public void remove(int id){
        SQLiteDatabase db=getWritableDatabase();
        db.delete("model","id="+Integer.toString(id),null);}
    public Float total()
    {    Float s =0f ;

        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM model";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<model> models=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                s+=cursor.getFloat(2);
            }
            while(cursor.moveToNext());
        }

        return s ;}
    public String firstdate() {
        String h = "";
        SQLiteDatabase db = getReadableDatabase();
        String s = "SELECT * FROM model";
        Cursor cursor= db.rawQuery(s,null);
        cursor.moveToFirst();
        h= cursor.getString(3);
        return h ;


    }
}

