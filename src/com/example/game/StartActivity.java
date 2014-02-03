package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends Activity implements OnClickListener {

	public static final int IDENTIF_PLAY_WITH_FRIEND = 1;
	public static final String IDENTIF_PLAY_WITH_FRIEND_KEY = "IDENTIF_PLAY_WITH_FRIEND_KEY";
	public static final int IDENTIF_PLAY_WITH_COMPUTER = 2;
	public static final String IDENTIF_PLAY_WITH_COMPUTER_KEY = "IDENTIF_PLAY_WITH_COMPUTER_KEY";

	private Button withComputer, withFriend;
	private TextView hello;
	private BackgroundSound mBackgroundSound = new BackgroundSound();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		mBackgroundSound.execute();

		withComputer = (Button) findViewById(R.id.withComputer);
		withFriend = (Button) findViewById(R.id.withFriend);
		hello = (TextView) findViewById(R.id.hello);
		hello.setPadding(0, getDisplayHeight() / 4, 0, 0);
		hello.setTextSize(20);
		hello.setTextColor(Color.YELLOW);

		withComputer.setOnClickListener(this);
		withFriend.setOnClickListener(this);
	}

	public void onResume() {
		super.onResume();
	}

	public void onDestroy() {
		super.onDestroy();
		mBackgroundSound.cancel(true);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, GameFieldActivity.class);
		switch (v.getId()) {
		case R.id.withComputer:
			intent.putExtra(IDENTIF_PLAY_WITH_COMPUTER_KEY,
					IDENTIF_PLAY_WITH_COMPUTER);
			startActivity(intent);
			break;
		case R.id.withFriend:
			intent.putExtra(IDENTIF_PLAY_WITH_FRIEND_KEY,
					IDENTIF_PLAY_WITH_FRIEND);
			startActivity(intent);
			break;
		}
	}

	public int getDisplayHeight() {
		Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
				.getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		return height;
	}

	public class BackgroundSound extends AsyncTask<Void, Void, Void> {
		@Override
		protected Void doInBackground(Void... params) {
			MediaPlayer player = MediaPlayer.create(StartActivity.this,
					R.raw.music);
			player.setLooping(true); // Set looping
			player.setVolume(100, 100);
			player.start();
			return null;
		}
	}
}
