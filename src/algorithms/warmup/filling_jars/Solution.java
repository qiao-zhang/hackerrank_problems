package algorithms.warmup.filling_jars;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int jarNum = in.nextInt();
		int opNum = in.nextInt();
		
		long totalCandyNum = 0;
		for (int i = 0; i < opNum; i++) {
			int startingIdx = in.nextInt();
			int endingIdx = in.nextInt();
			int jarFilledNum = endingIdx - startingIdx + 1;
			int candyNum = in.nextInt();
			totalCandyNum += candyNum * (long) jarFilledNum;
		}
		
		in.close();
		
		System.out.println(totalCandyNum / jarNum);
	}

}
