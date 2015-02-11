package algorithms.warmup.game_of_throne_i;

import java.util.Scanner;

public class Solution {
	
	public static final String POSITIVE_MSG = "YES";
	public static final String NEGATIVE_MSG = "NO";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] letters = in.nextLine().toCharArray();
		
		int[] occurences = new int[26]; // automatic initialization
		for (char letter : letters) {
			occurences[letter - 'a']++;
		}
		if (letters.length % 2 == 0) {
			// even
			for (int i = 0; i < 26; i++) {
				if (occurences[i] % 2 != 0) {
					System.out.println(NEGATIVE_MSG);
					return;
				}
			}
		} else {
			// odd
			int oddOccurences = 0;
			for (int i = 0; i < 26; i++) {
				if (occurences[i] % 2 != 0) {
					oddOccurences++;
				}
				if (oddOccurences > 1) {
					System.out.println(NEGATIVE_MSG);
					return;
				}
			}
		}
		System.out.println(POSITIVE_MSG);
	}

}
