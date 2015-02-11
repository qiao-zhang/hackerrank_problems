package algorithms.warmup.angry_children;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int pocketNum = in.nextInt();
		int kidNum = in.nextInt();
		
		int[] pockets = new int[pocketNum];
		for (int i = 0; i < pocketNum; i++) {
			pockets[i] = in.nextInt();
		}
		
		Arrays.sort(pockets);
		int minUnfairness = Integer.MAX_VALUE;
		for (int i = 0; i + kidNum -1 < pocketNum; i++) {
			int unfairness = pockets[i+kidNum-1] - pockets[i];
			if (minUnfairness > unfairness) minUnfairness = unfairness;
		}
		
		System.out.println(minUnfairness);
	}

}
