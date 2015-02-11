package algorithms.warmup.chocolate_feast;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		for (int i = 0; i < testNum; i++) {
			int money = in.nextInt(); // N
			int price = in.nextInt(); // C
			int discount = in.nextInt(); // M
			
//			int lowerBound = (money - price) * wrappers / price / (wrappers - 1);
//			int upperBound = money * wrappers / price / (wrappers - 1);
//			
//			for (int x = lowerBound; x <= upperBound; x++) {
//				int bonus = x / wrappers;
//				int regular = money / price;
//				if (bonus + regular > x) {
//					System.out.println(x);
//				}
//			}
			
//			double real_price = price - price / (double) wrappers;
			int chocolates = money / price;
			int wrappers = chocolates;
			while (wrappers >= discount) {
				int extra = wrappers / discount;
				chocolates += extra;
				wrappers = wrappers % discount + extra;
			}
			System.out.println(chocolates);
		}
		
		in.close();
	}

}
