package com.futureapps.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by saad on 3/19/2017.
 */
public class dbhelper extends SQLiteOpenHelper {
    public dbhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
public dbhelper(Context context){
    super(context,"dbxyz",null,1);


}
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tbQ="CREATE TABLE IF NOT EXISTS jokes" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "txt TEXT)" ;

        sqLiteDatabase.execSQL(tbQ);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
String DropQ="DROP TABLE IF EXISTS jokes";
        sqLiteDatabase.execSQL(DropQ);
        onCreate(sqLiteDatabase);
    }
    public long insert(String table, ContentValues values){

        SQLiteDatabase db=getWritableDatabase();
        return (long) db.insert(table,null,values);

    }
    public Cursor getData(String q){
Cursor cursor=null;
        SQLiteDatabase db=getWritableDatabase();
    cursor=db.rawQuery(q,null);
        cursor.moveToFirst();
        return cursor;


    }
    public long update(String table, ContentValues values,String criteria){

        SQLiteDatabase db=getWritableDatabase();
        return (long) db.update(table,values,criteria,null);

    }
    public long delete(String table, String column_name,String values){

        SQLiteDatabase db=getWritableDatabase();
        return (long) db.delete(table,column_name+"="+values,null);

    }
}
