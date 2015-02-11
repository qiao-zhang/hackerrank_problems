package algorithms.warmup.sherlock_and_squares;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		for (int i = 0; i < testNum; i++) {
			int lowerBound = in.nextInt();
			int upperBound = in.nextInt();
			
			int floorL = (int) Math.sqrt(lowerBound); // the floor of the square root of the lower bound
			int floorU = (int) Math.sqrt(upperBound); // the floor of the square root of the upper bound
			
			int count = 0;
			for (int j = floorL; j * j < lowerBound; j++) {
				count++;
			}
			
			System.out.println(floorU - floorL + 1 - count);
		}
	}

}
