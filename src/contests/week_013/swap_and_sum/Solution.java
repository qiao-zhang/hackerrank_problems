package contests.week_013.swap_and_sum;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int len = in.nextInt();
		int[] arr = new int[len];
		
		int queryNum = in.nextInt();
		for (int i = 0; i < len; i++) {
			arr[i] = in.nextInt();
		}
		in.nextLine();
		for (int q = 0; q < queryNum; q++) {
			int type = in.nextInt();
			int l = in.nextInt();
			int r = in.nextInt();
			if (type == 1) {
				for (int i = l - 1; i <= r - 2; i = i + 2) {
					swap(arr, i);
				}
			} else {
				int sum = 0;
				for (int i = l - 1; i <= r - 1; i++)
					sum += arr[i];
				System.out.println(sum);
			}
		}
		
		in.close();
	}
	
	private static void swap(int[] arr, int i) {
		int j = i + 1;
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
