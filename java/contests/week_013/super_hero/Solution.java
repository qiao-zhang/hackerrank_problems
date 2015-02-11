package contests.week_013.super_hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int testNum = in.nextInt();
		
		for (int i = 0; i < testNum; i++) {
			int levelNum = in.nextInt();
			int enemyNum = in.nextInt();
			
			int[][] costs = new int[levelNum][enemyNum];
			int[][] rewards = new int[levelNum][enemyNum];
			
			for (int l = 0; l < levelNum; l++) {
				for (int e = 0; e < enemyNum; e++) {
					costs[l][e] = in.nextInt();
				}
			}
			
			for (int l = 0; l < levelNum; l++) {
				for (int e = 0; e < enemyNum; e++) {
					rewards[l][e] = in.nextInt();
				}
			}
			
			Map<Integer, Integer> pathes = new HashMap<>();
			int[] firstPath = new int[2];
			firstPath[0] = getSmallest(costs[levelNum-1]);
			firstPath[1] = firstPath[0];
			pathes.put(firstPath[1], firstPath[0]);
			
			for (int l = levelNum - 2; l >= 0; l--) {
				Map<Integer, Integer> easyEnemies = getEasyEnemies(costs[l], rewards[l]);
				pathes = getForwardPathes(pathes, easyEnemies);
			}
			
			int min = Integer.MAX_VALUE;
			for (int reward : pathes.keySet()) {
				if (min > pathes.get(reward))
					min = pathes.get(reward);
			}
			
			System.out.println(min);
			
		}
		
		in.close();
	}
	
	private static int getSmallest(int[] costs) {
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < costs.length; i++) {
			if (costs[i] < smallest) {
				smallest = costs[i];
			}
		}
		
		return smallest;
	}
	
	private static Map<Integer, Integer> getEasyEnemies(int[] costs, int[] rewards) {
		Map<Integer, Integer> tmp = new HashMap<>();
		for (int e = 0; e < costs.length; e++) {
			if (!tmp.containsKey(rewards[e]) ||
					tmp.get(rewards[e]) > costs[e]) {
				tmp.put(rewards[e], costs[e]);
			}
		}
		Map<Integer, Integer> easyEnemies = new HashMap<>();
		for (int reward : tmp.keySet()) {
			int cost = tmp.get(reward);
			if (!easyEnemies.containsKey(cost) ||
					easyEnemies.get(cost) < reward) {
				easyEnemies.put(cost, reward);
			}
		}
		return easyEnemies;
	}
	
	private static Map<Integer, Integer> getForwardPathes(Map<Integer, Integer> pathes, Map<Integer, Integer> enemies) {
		Map<Integer, Integer> fp = new HashMap<>();
		
		for (int pathReward : pathes.keySet()) {
			int pathCost = pathes.get(pathReward);
			for (int enemyCost : enemies.keySet()) {
				int enemyReward = enemies.get(enemyCost);
				int newCost = pathCost + enemyCost - Math.min(pathReward, enemyReward);
				int newReward = enemyCost;
				if (!fp.containsKey(newReward) ||
						fp.get(newReward) > newCost) {
					fp.put(newReward, newCost);
				}
			}
		}
		
		return fp;
	}
	
}