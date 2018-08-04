package com.example.kiwifruit.utils;
import android.content.ContentValues;
import android.database.Cursor;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
/**
 * Created by 邓经纬 on 2018/8/4.
 */
public class apphelper extends SQLiteOpenHelper {

    public static final String CREATE_PLACE="create table place("+
            "id integer primary key autoincrement,"+
            "type integer"+
            "image1 integer"+
            "image2 integer"+
            "introduce text)";
    public static final String CREATE_PRODUCT="create table product("+
            "id integer primary key autoincrement,"+
            "type integer"+
            "image1 integer"+
            "image2 integer"+
            "introduce text)";
    public apphelper(Context context) {
        super(context, "app.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLACE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
