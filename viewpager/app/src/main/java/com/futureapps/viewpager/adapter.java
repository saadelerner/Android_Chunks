package com.futureapps.viewpager;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

/**
 * Created by saad on 4/2/2017.
 */
public class adapter extends PagerAdapter {
    Context cnt;
    LayoutInflater layoutInflater;
    ArrayList<HashMap<String,String>> list;
    public adapter(Activity cnt, ArrayList<HashMap<String,String>> list){
        this.cnt=cnt;
        this.list=list;


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        Log.e("I am In","I am In");
layoutInflater=(LayoutInflater) cnt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View v=(View) layoutInflater.inflate(R.layout.custom_view,view,false);
        TextView title=(TextView) v.findViewById(R.id.jtitle);
        TextView joke=(TextView) v.findViewById(R.id.joke);
        title.setText(list.get(position).get("title"));
        joke.setText(list.get(position).get("joke"));
        view.addView(v);
        return  v;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
      return (view==(LinearLayout)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((LinearLayout) object);
    }
}
