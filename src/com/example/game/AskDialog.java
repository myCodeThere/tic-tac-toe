package com.example.game;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;


@SuppressLint("NewApi")
public class AskDialog extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Сыграем еще раз?");
		builder.setPositiveButton("Еще раз", new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				
			}
		});
		builder.setNegativeButton("Хватит", new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				getActivity().finish();
			}
		});

		return builder.create();
	}
}
