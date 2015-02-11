package algorithms.warmup.sherlock_and_gcd;

import java.util.Scanner;

public class Solution {
	public static final String POS_MSG = "YES";
	public static final String NEG_MSG = "NO";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		for (int i = 0; i < testNum; i++) {
			int length = in.nextInt(); // N
//			int aNumber = in.nextInt();
//			if (aNumber == 1) {
//				System.out.println(POS_MSG);
//				return;
//			}
//			if (length == 1) {
//				System.out.println(NEG_MSG);
//				return;
//			}
//			int another = in.nextInt();
			boolean hasAnswerFlag = false;
			int[] numbers = new int[length];
			for (int j = 0; j < length; j++) {
				numbers[j] = in.nextInt();
				if (numbers[j] == 1) {
					System.out.println(POS_MSG);
					hasAnswerFlag = true;
					in.nextLine();
					break;
				}
			}
			if (hasAnswerFlag) continue;
			
			for (int j = 0; j < length - 1; j++) {
				for (int k = j+1; k < length; k++) {
//					System.out.println(numbers[j] + " " + numbers[k]);
					if (getGCD(numbers[j], numbers[k]) == 1) {
						System.out.println(POS_MSG);
						hasAnswerFlag = true;
						break;
					}
				}
				if (hasAnswerFlag) break;
			}
			if (hasAnswerFlag) continue;
			
			System.out.println(NEG_MSG);
		}
	}

	private static int getGCD(int j, int k) {
		if (k == 0) return j;
		return getGCD(k, j % k);
	}

}
