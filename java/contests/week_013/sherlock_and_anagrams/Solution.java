package contests.week_013.sherlock_and_anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testNum = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < testNum; i++) {
			String line = in.nextLine();
			int result = 0;
			
			for (int len = 1; len < line.length(); len++) {
				
				Map<String, Integer> tallies = new HashMap<>();
				for (int j = 0; j + len <= line.length(); j++) {
					char[] charArray = line.substring(j, j+len).toCharArray();
					Arrays.sort(charArray);
					String substring = new String(charArray);
					if (tallies.containsKey(substring)) {
						tallies.put(substring, tallies.get(substring)+1);
					} else {
						tallies.put(substring, 1);
					}
				}
				
				for (String key : tallies.keySet()) {
					if (tallies.get(key) >= 2)
						result += tallies.get(key) * (tallies.get(key) - 1) / 2;
				}
//				
//				if (num == 0)
//					break;
			}
			
			System.out.println(result);
		}
		
		in.close();
	}

}
