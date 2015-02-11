package algorithms.warmup.utopian_tree;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < testNum; i++) {
			int cycleNum = in.nextInt();
			if (cycleNum == 0)
				sb.append(1).append('\n');
			else {
				int k = (cycleNum + 3) / 2;
				int tmp = (int) Math.pow(2, k) - 1;
				if (cycleNum % 2 == 0)
					sb.append(tmp).append('\n');
				else
					sb.append(tmp-1).append('\n');
			}
				
		}
		
		System.out.println(sb);
		in.close();
	}

}
