package algorithms.strings.bigger_is_greater;

import java.util.Scanner;

public class Solution {
	
	public static final char[] NO_ANSWER_MESSAGE = "no answer".toCharArray();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();    // N
		in.nextLine();    // consume the \n after the number
		
		for (int i = 0; i < testNum; i++) {
			System.out.println(enlarge(in.nextLine()));
		}
		
		in.close();
//		reverse(NO_ANSWER_MESSAGE, 0);
//		System.out.println(NO_ANSWER_MESSAGE);
	}

	private static char[] enlarge(String word) {
		char[] letters = word.toCharArray();
		
		if (letters.length == 1) return NO_ANSWER_MESSAGE;
		
		for (int i = letters.length - 2; i >= 0; i--) {
			for (int j = letters.length - 1; j >= i + 1; j--) {
				if (letters[i] < letters[j]) {
					reverse(letters, i);    // reverse all the elements after the index j (exclusive)
					j = letters.length + i - j;
					char temp = letters[i];
					letters[i] = letters[j];
					letters[j] = temp;
					return letters;
				}
			}
		}
		
		return NO_ANSWER_MESSAGE;
	}

	private static void reverse(char[] letters, int idx) {
		char[] reversedPart = new char[letters.length - idx - 1];
		for (int i = 0; i < reversedPart.length; i++) {
			reversedPart[i] = letters[letters.length - 1 - i];
		}
		for (int i = idx + 1; i < letters.length; i++) {
			letters[i] = reversedPart[i - idx - 1];
		}
	}

}
