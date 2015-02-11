package algorithms.warmup.max_xor;

import java.util.Scanner;

public class Solution {
	
	private static int maxXOR(int small, int big) {
		int smallBitNum = Integer.toBinaryString(small).length();
		int bigBitNum = Integer.toBinaryString(big).length();
		if (smallBitNum < bigBitNum) {
			return (int)Math.pow(2, bigBitNum) - 1;
		} else {
			return maxXOR(small - (int)Math.pow(2, bigBitNum-1), big - (int)Math.pow(2, bigBitNum-1));
		}
		
//		int tmp = ((int) Math.pow(2, bigBitNum - smallBitNum + 1) - 1) * (int) Math.pow(2, smallBitNum);
//		if (big >= )
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int small = in.nextInt();
		in.nextLine();
		int big = in.nextInt();
		System.out.println(maxXOR(small, big));
		
		in.close();
	}

}
