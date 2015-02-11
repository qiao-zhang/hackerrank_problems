package algorithms.implementation.halloween_party;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		for (int i = 0; i < testNum; i++) {
			int cutNum = Integer.parseInt(in.nextLine());
			long horizontalCutNum = cutNum / 2; // integer division
			long verticalCutNum = cutNum - horizontalCutNum;
			System.out.println(horizontalCutNum * verticalCutNum);
		}
		
		in.close();
	}

}