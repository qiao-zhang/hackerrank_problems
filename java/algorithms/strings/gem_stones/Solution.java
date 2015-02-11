package algorithms.strings.gem_stones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rockNum = in.nextInt();
		in.nextLine();
		
		int[][] rocks = new int[rockNum+1][26]; // Java automatically initialize arrays.
		for (int i = 0; i < rockNum; i++) {
			char[] elements = in.nextLine().toCharArray();
			for (char element : elements) {
				rocks[i][element-'a']++;
			}
		}
		
		in.close();
		
		int result = 0;
		for (int i = 0; i < 26; i++) {
			result++;
			for (int j = 0; j < rockNum; j++) {
				if (rocks[j][i] == 0) {
					result--;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

}
