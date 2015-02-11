package algorithms.warmup.find_digits;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		for (int testRound = 0; testRound < testNum; testRound++) {
			long number = in.nextLong();
			System.out.println(countDividorDigits(number));
		}
		
		in.close();
	}

	private static int countDividorDigits(long number) {
		int counter = 0;
		long copy = number;
		while (copy > 0) {
			int digit = (int) (copy % 10);
			if ((digit != 0) && (number % digit == 0)) counter++;
			copy = copy / 10;
		}
		return counter;
	}

}
