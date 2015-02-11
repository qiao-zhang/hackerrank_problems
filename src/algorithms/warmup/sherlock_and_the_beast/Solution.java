package algorithms.warmup.sherlock_and_the_beast;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		for (int i = 0; i < testNum; i++) {
			int digitNum = in.nextInt();
//			System.out.println(i + ": " + digitNum);
			int maxTimesOf3 = digitNum / 3;
//			System.out.println(i + ": " + maxTimesOf3);
			String result = "-1";
			for (int j = maxTimesOf3; j >= 0; j--) {
				int digitNumOf5 = j * 3;
				int digitNumOf3 = digitNum - digitNumOf5;
				if (digitNumOf3 % 5 == 0) {
					StringBuilder sb = new StringBuilder();
					for (int k = 0; k < digitNumOf5; k++) {
						sb.append(5);
					}
					for (int k = 0; k < digitNumOf3; k++) {
						sb.append(3);
					}
					result = sb.toString();
					break;
				}
			}
			System.out.println(result);
		}
		
		in.close();
	}

}
