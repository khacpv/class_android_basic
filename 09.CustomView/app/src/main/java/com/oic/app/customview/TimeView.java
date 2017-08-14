package com.oic.app.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SuppressLint("AppCompatCustomView")
public class TimeView extends TextView {
    private String titleText;
    private boolean color;

    public TimeView(Context context) {
        super(context);
        setTimeView();
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimeView);

        try {
            titleText = typedArray.getString(R.styleable.TimeView_title);
            setTimeView();
            color = typedArray.getBoolean(R.styleable.TimeView_setColor, false);
            decorateText();
        } finally {
            // for reuse
            typedArray.recycle();
        }
    }

    public TimeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setTimeView();
    }

    private void setTimeView() {
        // has the format hour.minuits am/pm
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String time = dateFormat.format(Calendar.getInstance().getTime());

        if (this.titleText != null) {
            setText(this.titleText + " " + time);
        } else {
            setText(time);
        }
    }

    private void decorateText() {
        // when we set setColor attribute to true in the XML layout
        if (this.color) {
            if (!isInEditMode()) {
                // set the characteristics and the color of the shadow
                setShadowLayer(4, 2, 2, Color.rgb(250, 0, 250));
            }
            setBackgroundColor(Color.CYAN);
        } else {
            setBackgroundColor(Color.RED);
        }
    }
}
