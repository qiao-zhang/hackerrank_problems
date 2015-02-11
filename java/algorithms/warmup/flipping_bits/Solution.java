package algorithms.warmup.flipping_bits;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testNum = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		long sum = Long.parseLong("FFFFFFFF", 16);
		
		for (int i = 0; i < testNum; i++) {
			long num = in.nextLong();
			sb.append(sum - num);
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		in.close();
	}

}
