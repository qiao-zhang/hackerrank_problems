package algorithms.warmup.manasa_and_stones;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	private static Set<Integer> getPossibleValues(int n, int a, int b) {
		Set<Integer> values = new TreeSet<>();
		values.add(0);
		for (int i = 2; i <= n; i++) {
			Set<Integer> newValues = new TreeSet<>();
			for (Integer value : values) {
				newValues.add(value + a);
				newValues.add(value + b);
			}
			values = newValues;
		}
		return values;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		for (int i = 0; i < testNum; i++) {
			int n = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			
			Set<Integer> possibleValues = getPossibleValues(n, a, b);
			for (Integer value : possibleValues) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

}
