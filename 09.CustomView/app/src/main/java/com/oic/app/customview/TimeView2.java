package com.oic.app.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by khacpham on 8/18/17.
 */

public class TimeView2 extends View {

    int lineColor;

    public TimeView2(Context context) {
        super(context);
    }

    public TimeView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeView2);

        try {
            lineColor = typedArray.getColor(R.styleable.TimeView2_lineColor, Color.RED);
        } finally {
            // for reuse
            typedArray.recycle();
        }

        mPaintLine = new Paint();
        mPaintLine.setColor(lineColor);

        mPaintRect = new Paint();
        mPaintRect.setStyle(Paint.Style.FILL);
        mPaintRect.setColor(Color.GREEN);

        mPaintText = new Paint();
        mPaintText.setStyle(Paint.Style.FILL);
        mPaintText.setColor(Color.BLUE);
        mPaintText.setTextSize(40);

        setWillNotDraw(false);
    }

    Paint mPaintLine;
    Paint mPaintRect;
    Paint mPaintText;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, 50, 200, 200, mPaintRect);
        canvas.drawLine(0, 0, getWidth(), getHeight(), mPaintLine);

        if (isInEditMode()) {
            canvas.drawText("In Edit mode", getWidth() / 2, getHeight() / 2, mPaintText);
        }

        Log.e("TAG", "draw from :" + x0 + ":" + y0 + " to " + x1 + ":" + y1);
        canvas.drawLine(x0, y0, x1, y1, mPaintLine);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    float x0;
    float y0;

    float x1;
    float y1;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("TAG", "User touch on TimeView2");
                x0 = event.getX();
                y0 = event.getY();
                invalidate();
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.e("TAG", "User move on TimeView2");
                x0 = x1;
                y0 = y1;
                x1 = event.getX();
                y1 = event.getY();
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                Log.e("TAG", "User leave on TimeView2");
                invalidate();
                return true;
        }

        return true;
    }
}
