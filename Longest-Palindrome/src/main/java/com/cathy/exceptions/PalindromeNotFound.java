package com.cathy.exceptions;

public class PalindromeNotFound extends RuntimeException {

	public PalindromeNotFound() {
		super("Could Not Found Palindrome");
	}
}
