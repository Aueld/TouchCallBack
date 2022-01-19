package com.example.ch01;

//1.5.5
//1.5.6
//1.5.7

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class LongClickView extends View implements View.OnTouchListener, View.OnLongClickListener {

    private int radius;
    private Paint paint;
    private float cx, cy;
    private boolean check = false;


    public LongClickView(Context context) {
        super(context);
        setOnTouchListener(this);
        setOnLongClickListener(this);
        radius = 100;
        cx = 100;
        cy = 100;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(check)
            canvas.drawCircle(cx, cy, radius, paint);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN
                || event.getAction() == MotionEvent.ACTION_MOVE) {

            check = true;

            cx = event.getX();
            cy = event.getY();

            invalidate();
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            check = false;
            radius = 100;
            invalidate();
        }

        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        //radius = 200;
        invalidate();
        EThread eThread = new EThread();
        eThread.start();
        return false;
    }

    private class EThread extends Thread{
        private int temp;
        public EThread(){
            temp = 0;
        }

        // 연습문제 1.5.6
//        public void run() {
//            try {
//                Thread.sleep(100);
//                radius = 100;
//                invalidate();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        // 연습문제 1.5.7
        public void run(){
            temp = 0;
            while(temp <= 200){
                temp++;
                try {
                    Thread.sleep(10);
                    if(temp <= 100)
                        radius++;
                    else
                        radius--;
                    invalidate();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}