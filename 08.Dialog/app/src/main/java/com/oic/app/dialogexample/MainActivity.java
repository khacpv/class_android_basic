package com.oic.app.dialogexample;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello, I'm a Toast", Toast.LENGTH_LONG).show();
    }

    public void showDialogAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Hello, Nice to meet you");
        builder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showDialogAlertList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert-List Dialog");
        builder.setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("TAG", "item " + which + " selected");
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showDialogAlertListChoice(View view) {
        final List<Integer> mSelectedItems = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert-Choice Dialog");
        builder.setMultiChoiceItems(R.array.colors_array, null,
            new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    if (isChecked) {
                        mSelectedItems.add(which);
                    } else {
                        mSelectedItems.remove(which);
                    }
                }
            });
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, mSelectedItems.size() + " items selected",
                    Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showDialogCustom(View view) {
        DialogFragment dialogFragment = new CustomDialog();
        dialogFragment.show(getFragmentManager(), "login form");
    }

    public void showDialogActivity(View view) {
        startActivity(new Intent(this, ActivityDialog.class));
    }

    public void showNotification(View view) {
        NotificationCompat.Builder mBuilder =
            new NotificationCompat.Builder(this).setSmallIcon(R.drawable.dialog)
                .setContentTitle("My notification")
                .setContentText("Hello World!");
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, MainActivity.class);

        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(MainActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
            stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
            (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // mNotificationId is a unique integer your app uses to identify the
        // notification. For example, to cancel the notification, you can pass its ID
        // number to NotificationManager.cancel().
        mNotificationManager.notify(999, mBuilder.build());

    }
}
