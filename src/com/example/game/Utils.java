package com.example.game;

import java.util.List;

public class Utils {
	
	public static boolean checkWinner(List<Integer> list) {
		if (list.contains(1) && list.contains(2) && list.contains(3)) {
			return true;
		} else if (list.contains(4) && list.contains(5) && list.contains(6)) {
			return true;
		} else if (list.contains(7) && list.contains(8) && list.contains(9)) {
			return true;
		} else if (list.contains(1) && list.contains(4) && list.contains(7)) {
			return true;
		} else if (list.contains(2) && list.contains(5) && list.contains(8)) {
			return true;
		} else if (list.contains(3) && list.contains(6) && list.contains(9)) {
			return true;
		} else if (list.contains(1) && list.contains(5) && list.contains(9)) {
			return true;
		} else if (list.contains(3) && list.contains(5) && list.contains(7)) {
			return true;
		} else {
			return false;
		}
	}

}
