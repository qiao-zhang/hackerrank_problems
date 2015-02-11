package algorithms.warmup.is_fibo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static final String POS = "IsFibo";
	public static final String NEG = "IsNotFibo";
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		
		long maxNumber = 1;
		long[] numbers = new long[testNum];
		for (int test = 0; test < testNum; test++) {
			long number = in.nextLong();
			numbers[test] = number;
			if (maxNumber < number) maxNumber = number;
		}
//		System.out.println("Max: " + maxNumber);
		
		Set<Long> fibs = new HashSet<>();
		long fibA = 0;
		long fibB = 1;
		fibs.add(fibA);
		fibs.add(fibB);
		long fibC = fibA + fibB;
		while (fibC <= maxNumber) {
			fibs.add(fibC);
			fibA = fibB;
			fibB = fibC;
			fibC = fibA + fibB;
		}
		
//		for (Long fib : fibs) System.out.println(fib);
		
		for (int i = 0; i < testNum; i++) {
			if (fibs.contains(numbers[i])) System.out.println(POS);
			else System.out.println(NEG);
		}
	}

}
