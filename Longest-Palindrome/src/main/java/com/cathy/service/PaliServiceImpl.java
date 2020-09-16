package com.cathy.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cathy.entity.Pali;
import com.cathy.exceptions.PalindromeNotFound;
import com.cathy.repository.PaliRepository;

@Service
public class PaliServiceImpl implements PaliService {

	private PaliRepository repository;
	
	public PaliServiceImpl(PaliRepository repository) {
		this.repository = repository;
	}
	
	public String getPali(String input) {
		Optional<Pali>  paliOptional= repository.findByName(input);
		if (paliOptional.isPresent()) return paliOptional.get().getPalindrome();
		String logest = getLongestPalindrome(input);
		Pali entity = new Pali(input, logest);
		repository.save(entity);
		return logest;
	}
	
	//Main Logic
	@Override
	public String getLongestPalindrome(String input) {
		if (input == null || input.length() == 0) throw new PalindromeNotFound();
		int n = input.length();
		int maxLen = 1;
		int start = 0, end = 0;
		for (int i = 1; i < n; i++) {
			int len1 = extendByCenter(input, i, i); //Palindrome with odd length centered with i
			int len2 = extendByCenter(input, i - 1, i); //Palindrome with even length centered with i-1 and i
			if (len1 > maxLen) {
				maxLen = len1;
				start = i - len1 / 2;
				end = i + len1 / 2;
			}
			if (len2 > maxLen) {
				maxLen = len2;
				start = i - len2 / 2;
				end = i - 1 + len2 / 2;
			}
		}
		return input.substring(start, end + 1);
	}
	
	private int extendByCenter (String s, int lo, int hi) {
		int maxLen = 1;
		while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
			maxLen = hi - lo + 1;
			lo--;
			hi++;
		}
		return maxLen;
	}

}
