package com.creatures.mysqlrecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String db_name = "ngo_events";

    public DatabaseManager(@Nullable Context context) {
        super(context, db_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String create_query = "create table events_details(e_id integer primary key autoincrement, e_name text, e_des text)";
        db.execSQL(create_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String update_query = "drop table if exists event_details";
        db.execSQL(update_query);
        onCreate(db);
    }

    public String add_info(String e_name, String e_des)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("e_name",e_name);
        contentValues.put("e_des",e_des);
        float d_store_result = database.insert("events_details",null,contentValues);

        if (d_store_result==-1)
        {
             return "Fail";
        }
        else
        {
            return "Successfully Done";
        }
    }

    public Cursor readalldata()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String select_query = "select * from events_details order by e_id desc";
        Cursor cursor = database.rawQuery(select_query,null);
        return cursor;

    }

}
