package com.futureapps.listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by saad on 3/26/2017.
 */
public class listAdp extends BaseAdapter {
ArrayList<String> arrayList=new ArrayList();
    Context cnt;
    public listAdp(Activity cnt, ArrayList<String> arrayList){
this.arrayList=arrayList;
        this.cnt=cnt;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
       view=layoutInflater.inflate(R.layout.list_activity,null);
        final TextView t1=(TextView) view.findViewById(R.id.t1);
        t1.setText(arrayList.get(i));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shareBody = t1.getText().toString();
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Enter Subject");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                ((MainActivity)cnt).startActivity(Intent.createChooser(sharingIntent,"Share via"));
            }
        });

        return view;
    }
}
