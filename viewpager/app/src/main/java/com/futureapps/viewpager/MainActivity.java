package com.futureapps.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<HashMap<String,String>> list=new ArrayList<>();

        for(int i=0; i<10;i++){
            HashMap<String,String> Hlist=new HashMap<>();
            Hlist.put("title","JOKE TITLE"+i);
            Hlist.put("joke","JOKE DESCRIPTION"+i);
            list.add(Hlist);
        }
        adapter adp=new adapter(this,list);
        ViewPager pager=(ViewPager) findViewById(R.id.viewpager);

        pager.setAdapter(adp);
       pager.setCurrentItem(4);

    }
}
