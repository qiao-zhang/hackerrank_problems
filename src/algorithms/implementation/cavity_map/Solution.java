package algorithms.implementation.cavity_map;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int dimen = in.nextInt();
		in.nextLine();
		
		char[][] map = new char[dimen][dimen];
		for (int row = 0; row < dimen; row++) {
			map[row] = in.nextLine().toCharArray();
		}
		
		for (int row = 1; row < dimen-1; row++) {
			for (int col = 1; col < dimen-1; col++) {
				char currentCell = map[row][col];
				if (currentCell > map[row-1][col] && currentCell > map[row+1][col]
						&& currentCell > map[row][col-1] && currentCell > map[row][col+1])
					map[row][col] = 'X';
			}
		}
		
		for (int row = 0; row < dimen; row++) {
			for (int col = 0; col < dimen; col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
		
		in.close();
	}

}
