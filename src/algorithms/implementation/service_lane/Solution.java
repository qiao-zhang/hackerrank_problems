package algorithms.implementation.service_lane;

import java.util.*;

public class Solution {
	
	private static int findMinWidth(List<Integer> widths, int entry_idx, int exit_idx) {
		int min_width = 3;
		for (int idx = entry_idx; idx <= exit_idx; idx++) {
			if (widths.get(idx) == 1) return 1;
			if (widths.get(idx) < min_width) min_width = widths.get(idx);
		}
		return min_width;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] n_and_t = in.nextLine().trim().split(" ");
		int length = Integer.parseInt(n_and_t[0]);
		int testNum = Integer.parseInt(n_and_t[1]);
		
		List<Integer> widths = new ArrayList<Integer>();
		for (int i = 0; i < length; i++) {
			widths.add(in.nextInt());
		}
		in.nextLine(); // consume the \n after the widths
		
		for (int j = 0; j < testNum; j++) {
			String[] entry_and_exit = in.nextLine().trim().split(" ");
			int entry_idx = Integer.parseInt(entry_and_exit[0]);
			int exit_idx = Integer.parseInt(entry_and_exit[1]);
			System.out.println(findMinWidth(widths, entry_idx, exit_idx));
		}
		in.close();
	}

}
