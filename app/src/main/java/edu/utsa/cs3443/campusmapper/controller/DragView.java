package edu.utsa.cs3443.campusmapper.controller;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class DragView implements View.OnTouchListener {
    private Context context;
    private ViewGroup main;
    private RelativeLayout drag;

    private int xDelta;
    private int yDelta;

    public DragView(Context context, ViewGroup main) {
        this.context = context;
        this.main = main;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final int x = (int) motionEvent.getRawX();
        final int y = (int) motionEvent.getRawY();

        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();

                xDelta = x - lParams.leftMargin;
                yDelta = y - lParams.topMargin;
                break;

            case MotionEvent.ACTION_UP:
                Toast.makeText(context, "I'm here!", Toast.LENGTH_SHORT).show();
                break;

            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams.leftMargin = x - xDelta;
                layoutParams.topMargin = y - yDelta;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                view.setLayoutParams(layoutParams);
                break;
        }

        main.invalidate();
        return true;
    }
}
