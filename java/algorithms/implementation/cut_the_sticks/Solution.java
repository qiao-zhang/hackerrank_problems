package algorithms.implementation.cut_the_sticks;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int stickNum = in.nextInt();
		
		PriorityQueue<Integer> lengths = new PriorityQueue<>();
		for (int i = 0; i < stickNum; i++) {
			lengths.add(in.nextInt());
		}
		
		while (lengths.size() > 0) {
			System.out.println(lengths.size());
			int minLength = lengths.poll();
			while (lengths.peek() != null && lengths.peek() == minLength) {
				lengths.remove();
			}
		}
	}

}
