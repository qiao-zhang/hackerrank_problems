'''
Created on 11 Jan 2015

@author: qiao
'''
if __name__ == '__main__':
    case_num = int(input())
    for case in range(case_num):
        level_num, enemy_num = map(int, input().split())
        costs = []
        rewards = []
        all_enemies = []
        for level in range(level_num):
            costs.append([int(x) for x in input().split()])
        for level in range(level_num):
            rewards.append([int(x) for x in input().split()])
        for level in range(level_num):
            all_enemies.append(list(zip(costs[level], rewards[level])))
        for enemies in all_enemies:
            enemies.sort()
            tgt_idx = 0
            while tgt_idx < len(enemies) - 1:
                mv_idx = tgt_idx + 1
                if enemies[mv_idx][0] == enemies[tgt_idx][0]:
                    if enemies[mv_idx][1] > enemies[tgt_idx][1]:
                        enemies.pop(tgt_idx)
                    else:
                        enemies.pop(mv_idx)
                else:
                    if enemies[mv_idx][1] > enemies[tgt_idx][1]:
                        tgt_idx += 1
                    else:
                        enemies.pop(mv_idx)
        
        pathes = {}
        pathes[all_enemies[-1][0][0]] = all_enemies[-1][0][0]
        
        level = level_num - 2
        while level >= 0:
            tmp = {}
            for path_reward in pathes.keys():
                path_cost = pathes[path_reward]
                for enemy_cost, enemy_reward in all_enemies[level]:
                    new_cost = path_cost + enemy_cost - min(path_reward, enemy_reward)
                    new_reward = enemy_cost
                    if new_reward not in tmp or tmp[new_reward] > new_cost:
                        tmp[new_reward] = new_cost
            pathes = tmp
            level -= 1
            
        print(min(pathes.values()))

"""
Map<Integer, Integer> tmp = new HashMap<>();
        
        for (int pathReward : pathes.keySet()) {
            int pathCost = pathes.get(pathReward);
            for (int enemyCost : enemies.keySet()) {
                int enemyReward = enemies.get(enemyCost);
                int newCost = pathCost + enemyCost - Math.min(pathReward, enemyReward);
                int newReward = enemyCost;
                if (!tmp.containsKey(newReward) ||
                        tmp.get(newReward) > newCost) {
                    tmp.put(newReward, newCost);
                }
            }
        }
        
        return tmp;
"""
    