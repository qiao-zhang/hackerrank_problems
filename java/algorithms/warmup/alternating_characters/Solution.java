package algorithms.warmup.alternating_characters;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testNum = in.nextInt();
		in.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < testNum; i++) {
			int deletionNum = 0;
			char[] chars = in.nextLine().toCharArray();
//			System.out.println(chars.length);
			char current = chars[0];
			for (int j = 1; j < chars.length; j++) {
				if (current == chars[j])
					deletionNum++;
				else
					current = chars[j];
			}
			sb.append(deletionNum);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
