package com.example.game;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class GameFieldActivity extends Activity implements OnClickListener {

	int count;
	Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
	List<Integer> usesButtons = new ArrayList<Integer>();
	List<Integer> usersUsesButtons = new ArrayList<Integer>();
	List<Integer> computerUsesButtons = new ArrayList<Integer>();
	List<Integer> usersOneUsesButtons = new ArrayList<Integer>();
	List<Integer> usersTwoUsesButtons = new ArrayList<Integer>();
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_field);

		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);
		b5 = (Button) findViewById(R.id.button5);
		b6 = (Button) findViewById(R.id.button6);
		b7 = (Button) findViewById(R.id.button7);
		b8 = (Button) findViewById(R.id.button8);
		b9 = (Button) findViewById(R.id.button9);
		text = (TextView) findViewById(R.id.text);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		b7.setOnClickListener(this);
		b8.setOnClickListener(this);
		b9.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (getIntent().getExtras().getInt(
				StartActivity.IDENTIF_PLAY_WITH_COMPUTER_KEY) == StartActivity.IDENTIF_PLAY_WITH_COMPUTER) {
			if (count % 2 == 0 && count < 10) {
				switch (v.getId()) {
				case R.id.button1:
					userActionWithComputer(b1, 1);
					computerAction();
					break;
				case R.id.button2:
					userActionWithComputer(b2, 2);
					computerAction();
					break;
				case R.id.button3:
					userActionWithComputer(b3, 3);
					computerAction();
					break;
				case R.id.button4:
					userActionWithComputer(b4, 4);
					computerAction();
					break;
				case R.id.button5:
					userActionWithComputer(b5, 5);
					computerAction();
					break;
				case R.id.button6:
					userActionWithComputer(b6, 6);
					computerAction();
					break;
				case R.id.button7:
					userActionWithComputer(b7, 7);
					computerAction();
					break;
				case R.id.button8:
					userActionWithComputer(b8, 8);
					computerAction();
					break;
				case R.id.button9:
					userActionWithComputer(b9, 9);
					computerAction();
					break;
				default:
					break;
				}
			}
		} else if (getIntent().getExtras().getInt(
				StartActivity.IDENTIF_PLAY_WITH_FRIEND_KEY) == StartActivity.IDENTIF_PLAY_WITH_FRIEND) {
			if (count < 9) {
				switch (v.getId()) {
				case R.id.button1:
					userActionWithFriend(b1, 1);
					break;
				case R.id.button2:
					userActionWithFriend(b2, 2);
					break;
				case R.id.button3:
					userActionWithFriend(b3, 3);
					break;
				case R.id.button4:
					userActionWithFriend(b4, 4);
					break;
				case R.id.button5:
					userActionWithFriend(b5, 5);
					break;
				case R.id.button6:
					userActionWithFriend(b6, 6);
					break;
				case R.id.button7:
					userActionWithFriend(b7, 7);
					break;
				case R.id.button8:
					userActionWithFriend(b8, 8);
					break;
				case R.id.button9:
					userActionWithFriend(b9, 9);
					break;
				}
			}
		}
	}

	public void userActionWithComputer(Button button, int tag) {
		button.setBackgroundColor(Color.GREEN);
		button.setClickable(false);
		count++;
		usesButtons.add(tag);
		usersUsesButtons.add(tag);
		if (Utils.checkWinner(usersUsesButtons)) {
			text.setText("Конец");
		}
	}

	public void computerAction(Button button, int tag) {
		usesButtons.add(tag);
		computerUsesButtons.add(tag);
		button.setBackgroundColor(Color.RED);
		button.setClickable(false);
		count++;
		if (Utils.checkWinner(computerUsesButtons)) {
			text.setText("Конец");
		}
	}

	public void computerAction() {
		if (count < 9) {
			int tag = (int) (Math.random() * 9);
			while (usesButtons.contains(tag + 1)) {
				tag = (int) (Math.random() * 9);
			}
			switch (tag) {
			case 0:
				computerAction(b1, 1);
				break;
			case 1:
				computerAction(b2, 2);
				break;
			case 2:
				computerAction(b3, 3);
				break;
			case 3:
				computerAction(b4, 4);
				break;
			case 4:
				computerAction(b5, 5);
				break;
			case 5:
				computerAction(b6, 6);
				break;
			case 6:
				computerAction(b7, 7);
				break;
			case 7:
				computerAction(b8, 8);
				break;
			case 8:
				computerAction(b9, 9);
				break;
			}
		}
	}
	
	public void userActionWithFriend(Button button, int tag) {
		if (count % 2 == 0) {
			button.setBackgroundColor(Color.RED);
			usersOneUsesButtons.add(tag);
		} else {
			button.setBackgroundColor(Color.GREEN);
			usersTwoUsesButtons.add(tag);
		}
		button.setClickable(false);
		count++;
		usesButtons.add(tag);
		if (Utils.checkWinner(usersOneUsesButtons) || Utils.checkWinner(usersTwoUsesButtons)){
			text.setText("Конец");
		}
	}

	
}
