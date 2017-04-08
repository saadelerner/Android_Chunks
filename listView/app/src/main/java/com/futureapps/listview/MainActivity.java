package com.futureapps.listview;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView) findViewById(R.id.list);
        ContentResolver contentResolver=getContentResolver();
        Cursor cursor=contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                new String[] {ContactsContract.Contacts.DISPLAY_NAME},null,null,null );
        assert cursor != null;
        while (!cursor.isAfterLast()){
            Log.e("TAG","-- "+cursor.getString(0));
            cursor.moveToNext();
        }
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=0;i<=10;i++){
        arrayList.add(String.valueOf(i));
        }
        listAdp listadp=new listAdp(this,arrayList);
        listView.setAdapter(listadp);

    }
}
