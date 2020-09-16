package com.cathy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pali {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String palindrome;
	
	public Pali(String input, String palindrome) {
		name = input;
		this.palindrome = palindrome;
	}

	public String getPalindrome() {
		return palindrome;
	}

	public void setPalindrome(String palindrome) {
		this.palindrome = palindrome;
	}
	
}
