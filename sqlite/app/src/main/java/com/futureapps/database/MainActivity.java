package com.futureapps.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper dbhlper=new dbhelper(MainActivity.this);
//        ContentValues contentValues=new ContentValues();
//        contentValues.put("title","ABC");
//        contentValues.put("txt","update");
     //   dbhlper.insert("jokes",contentValues);
      //  dbhlper.update("jokes",contentValues,"id=2");
    dbhlper.delete("jokes","id","1");
     // Toast.makeText(this,""+dbhlper.insert("jokes",contentValues),Toast.LENGTH_LONG).show();
      String q="select * from jokes";
      Cursor cursor= dbhlper.getData(q);

        if(cursor!=null){

            while(!cursor.isAfterLast()){
                Log.e("MainActivity","----"+cursor.getString(cursor.getColumnIndex("txt")));
                cursor.moveToNext();
            }

        }
    }
}
