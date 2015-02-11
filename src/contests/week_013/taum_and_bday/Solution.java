package contests.week_013.taum_and_bday;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testNum = in.nextInt();
		for (int i = 0; i < testNum; i++) {
			long blackNum = in.nextLong();
			long whiteNum = in.nextLong();
			long blackCost = in.nextLong();
			long whiteCost = in.nextLong();
			long convertCost = in.nextLong();
			
			long totalCost = 0;
			if (blackCost > whiteCost + convertCost) {
				totalCost = (whiteCost + convertCost) * blackNum +
						whiteCost * whiteNum;
			} else if (whiteCost > blackCost + convertCost) {
				totalCost = blackCost * blackNum +
						(blackCost + convertCost) * whiteNum;
			} else {
				totalCost = blackCost * blackNum + whiteCost * whiteNum;
			}
			
			System.out.println(totalCost);
		}
		
		in.close();
	}

}
