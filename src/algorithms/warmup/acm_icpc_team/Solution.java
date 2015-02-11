package algorithms.warmup.acm_icpc_team;

import java.util.Scanner;

public class Solution {
	
	private static int countCommonTopic(String topics1, String topics2) {
		char[] topicChars1 = topics1.toCharArray();
		char[] topicChars2 = topics2.toCharArray();
		
		int count = 0;
		for (int i = 0; i < topics1.length(); i++) {
			if (topicChars1[i] == '1' || topicChars2[i] == '1') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int personNum = in.nextInt();
		int topicNum = in.nextInt();
		in.nextLine();
		
		String[] persons = new String[personNum];
		for (int i = 0; i < personNum; i++) {
			persons[i] = in.nextLine();
//			System.out.println(persons[i]);
		}
		in.close();
		
		int maxCommonTopicNum = -1;
		int teamNum = 0;
		for (int i = 0; i < personNum - 1; i++) {
			for (int j = i + 1; j < personNum; j++) {
				int commonTopicCount = countCommonTopic(persons[i], persons[j]);
				if (maxCommonTopicNum < commonTopicCount) {
					maxCommonTopicNum = commonTopicCount;
					teamNum = 1;
				} else if (maxCommonTopicNum == commonTopicCount) {
					teamNum++;
				}
			}
		}
		
		System.out.println(maxCommonTopicNum);
		System.out.println(teamNum);
	}

}
