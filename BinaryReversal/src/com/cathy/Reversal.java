package com.cathy;

public class Reversal {

	public static void main(String[] args) {
		String res = BinaryReversal("47");
		System.out.println(res);
	}
	
	public static String BinaryReversal(String str) {
		if (str == null || str.length() == 0) return ""; //base check
		int val = Integer.parseInt(str); // convert string to integer
		String s = Integer.toString(val, 2); // convert integer to binary string
		int reminder = s.length() % 8; //check whether need to add additional 0
		StringBuilder sb = new StringBuilder();
		if (reminder != 0) {
			for (int i = 0; i < 8 - reminder; i++) sb.append('0');
		}
		sb.append(s);
		return sb.reverse().toString();
	}

}
