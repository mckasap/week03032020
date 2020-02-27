package org.kasapbasi.week03032020;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase db = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);
        db.execSQL("Create Table if not exists MyTablo(id INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                "name varchar(25), surname varchar(25))");

        db.execSQL("Insert Into MyTablo (name, surname) values('CEM','Kasap')");

        db.close();

        db = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);

        Cursor  c= db.rawQuery("Select * from MyTablo",null);

        String firstName;
        if (c != null ) {

            if  (c.moveToFirst()) {
                do {
                    Log.d("SqLITE", ""+c.getCount());
                    firstName = c.getString(c.getColumnIndex("name"));
                     Log.d("SqLITE", firstName);


                }while (c.moveToNext());
            }
        }


    }
}
