package com.oic.app.dialogexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by khacpham on 8/16/17.
 */

public class CustomDialog extends DialogFragment {

    CustomDialogListener mListener = null;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_custom, null);
        builder.setView(view);

        Button btnOk = (Button)view.findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onBtnOkClick();
                }
            }
        });

            //.setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
            //    @Override
            //    public void onClick(DialogInterface dialog, int which) {
            //        Toast.makeText(getActivity(), "Signing in...",Toast.LENGTH_SHORT).show();
            //        dialog.dismiss();
            //    }
            //})
            //.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            //    @Override
            //    public void onClick(DialogInterface dialog, int which) {
            //        dialog.dismiss();
            //    }
            //});

        return builder.create();
    }

    public void setCustomDialogListener(CustomDialogListener listener){
        this.mListener = listener;
    }

    public interface CustomDialogListener {
        void onBtnOkClick();
    }
}
