package com.oic.app.dialogexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class ActivityDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_custom);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
