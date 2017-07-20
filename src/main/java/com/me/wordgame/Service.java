package com.me.wordgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Service {

	ThreadLocal<List<String>> resultList = new ThreadLocal<List<String>>();
	// static List<String> result = new ArrayList<String>();
	private Set<String> wordSet = new HashSet<String>();

	public Service() {
		loadWordsInSet();
	}

	public List<String> getAllWords(String word) {

		perm(word);
		return resultList.get();
	}

	public void loadWordsInSet() {
		try {
			Resource resource = new ClassPathResource("wordlist.txt");
			BufferedReader in = new BufferedReader(new FileReader(resource.getFile()));
			String str;
			while ((str = in.readLine()) != null) {
				wordSet.add(str);
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public ArrayList<String> perm(String s) {
		// The result
		ArrayList<String> res = new ArrayList<String>();
		// If input string's length is 1, return {s}
		if (s.length() == 1) {
			res.add(s);
		} else if (s.length() > 1) {
			int lastIndex = s.length() - 1;
			// Find out the last character
			String last = s.substring(lastIndex);
			// Rest of the string
			String rest = s.substring(0, lastIndex);
			// Perform permutation on the rest string and
			// merge with the last character
			res = merge(perm(rest), last);
			addToResult(res);
		}
		return res;
	}

	public ArrayList<String> merge(ArrayList<String> list, String c) {
		ArrayList<String> res = new ArrayList<String>();
		// Loop through all the string in the list
		for (String s : list) {
			// For each string, insert the last character to all possible postions
			// and add them to the new list
			for (int i = 0; i <= s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				res.add(ps);
			}
		}
		return res;
	}

	public void addToResult(List<String> perms) {
		List<String> result = resultList.get();
		if (result == null) {
			resultList.set(new ArrayList<String>());
		}
		for (String s : perms) {
			if (wordSet.contains(s)) {
				resultList.get().add(s);
			}
		}
	}
}
