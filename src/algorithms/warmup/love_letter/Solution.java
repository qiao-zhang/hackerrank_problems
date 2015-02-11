package algorithms.warmup.love_letter;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < testNum; i++) {
			char[] letters = in.nextLine().toCharArray();
			int letterToChangeNum = letters.length / 2; // integer division
			int instructionNum = 0;
			for (int idx = 0; idx < letterToChangeNum; idx++) {
				int counterIdx = letters.length - 1 - idx;
				instructionNum += Math.abs((int) letters[counterIdx] - letters[idx]);
			}
			System.out.println(instructionNum);
		}
		
		in.close();
	}
}