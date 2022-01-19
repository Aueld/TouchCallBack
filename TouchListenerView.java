package com.example.ch01;

// 1.5.4

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class TouchListenerView extends View implements View.OnTouchListener {
    private Paint paint;

    private float cx, cy;
    private boolean check = false;

    public TouchListenerView(Context context) {
        super(context);
        paint = new Paint();
        cx = 100;
        cy = 100;
        setOnTouchListener(this);//리스너등록
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(check)
            canvas.drawCircle(cx, cy, 100, paint);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN
                || event.getAction() == MotionEvent.ACTION_MOVE) {
            Log.d("TouchCallbackView:",
                    "화면 누름");
            check = true;

            cx = event.getX();
            cy = event.getY();

            invalidate();
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            check = false;
            Log.d("TouchCallbackView:",
                    "화면에서 손가락 떼었음");

            invalidate();
        }

        return true;
    }
}