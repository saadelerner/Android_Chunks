package com.nextpick.saad.customkeyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import java.util.List;
/**
 * Created by saad on 8/20/2016.
 */
public class MKeyboardView extends KeyboardView {
    public MKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(18);
        paint.setColor(Color.WHITE);
        //get all your keys and draw whatever you want
        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for(Keyboard.Key key: keys) {
            if(key.popupCharacters != null) {
                if(key.label.toString().equals("0")){
                    paint.setTextAlign(Paint.Align.LEFT);

                    paint.setTextSize(10);

                    canvas.drawText("123...", key.x + (key.width / 2) + 10, key.y + 25, paint);

                }else {
                    canvas.drawText(key.popupCharacters.toString(), key.x + (key.width / 2) + 10, key.y + 25, paint);
                } }}
    }

//    @Override
//    protected boolean onLongPress(Keyboard.Key popupKey) {
//        if(popupKey.popupCharacters==null){
//        if(popupKey.label.toString().equals("E"))
//
//        getOnKeyboardActionListener().onKey('ڈ', null);
//        Log.e("Pop Key"," "+popupKey.toString());
//
//
//
//    }else{
//
//            Log.e("Pop Key popup"," "+popupKey.height);
//
//        }
//        return true;
//    }
}
