package algorithms.implementation.sherlock_and_queries;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lengthA = in.nextInt();
		int lengthBC = in.nextInt();
		long[] A = new long[lengthA];
		int[] B = new int[lengthBC];
		long[] C= new long[lengthBC];
		Map<Integer, Long> BC = new HashMap<>();
		int number = 1000000007;
		double hold = 9E13;

		//		System.out.println(number);

		for (int i = 0; i < lengthA; i++) {
			A[i] = in.nextLong();
		}

		for (int i = 0; i < lengthBC; i++) {
			B[i] = in.nextInt();
		}

		for (int i = 0; i < lengthBC; i++) {
			C[i] = in.nextLong();
			if (BC.containsKey(B[i])) {
				BC.put(B[i], BC.get(B[i]) * C[i] % number);
			} else {
				BC.put(B[i], C[i]);
			}
		}

		/////////////////////////////////////////////////
		//		for (int i = 0; i < N; i++) {
		//			System.out.println(A[i]);
		//		}
		//		
		//		for (int i = 0; i < M; i++) {
		//			System.out.println(B[i]);
		//		}
		//		
		//		for (int i = 0; i < M; i++) {
		//			System.out.println(C[i]);
		//		}
		///////////////////////////////////////////////

		in.close();

		for (Integer b : BC.keySet()) {
			for (int j = b - 1; j < lengthA; j += b) {
				A[j] = A[j] * BC.get(b) % number;
//				if (A[j] > hold) A[j] = A[j] % number;
			}
		}
		
//		for (int i = 0; i < lengthBC; i++) {
//			for (int j = B[i] - 1; j < lengthA; j+=B[i]) {       
//				A[j] = A[j] * C[i];
//				if (A[j] > hold) A[j] = A[j] % number;
//			}
//		}

		StringBuilder sb = new StringBuilder();
		for (long a : A) {
		    sb.append(a).append(" ");
		}
		System.out.print(sb.toString());
	}

}
