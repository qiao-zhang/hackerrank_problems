'''
Created on 15 Jan 2015

@author: qiao
'''

def main():
    vtx_num, opt_num = [int(v) for v in input().split()]
    name = 1
    weights = {}
    edges = {}
    for w in input().split():
        weights[name] = int(w)
        edges[name] = set()
        name += 1
        
    for _ in range(vtx_num - 1):
        v1, v2 = [int(v) for v in input().split()]
        edges[v1].add(v2)
        edges[v2].add(v1)
        
    fathers, children, max_lvl, names_of = bfs(edges, 1)
    print(fathers)
    print(children)
    print(max_lvl)
    print(names_of)
    print(weights)
    
    weight_sums = {}
    lvl = max_lvl
    while lvl >= 0:
        for name in names_of[lvl]:
            weight_sums[name] = weights[name]
            for child in children[name]:
                weight_sums[name] += weight_sums[child]
        lvl -= 1
        
    print(weight_sums)
        
    while opt_num > 0:
        node = min(weight_sums, key=weight_sums.get)
        if weight_sums[node] >= 0:
            break
        else:
            father = fathers[node]
            weight_sum = weight_sums[node]
            queue = [node]
            while queue:
                tmp = queue.pop(0)
                weight_sums.pop(tmp)
                print('pop', tmp)
                queue.extend(children[tmp])
            while father is not None:
                weight_sums[father] -= weight_sum
                father = fathers[father]
        opt_num -= 1
        print(weight_sums)
    print(weight_sums[1])
        
def bfs(edges, start):
    fathers = {start : None}
    lvl_of_name = {start : 0}
    children = {}
    names_of_lvl = {}
    max_level = 0
    visited, queue = set(), [start]
    while queue:
        father = queue.pop(0)
        visited.add(father)
        max_level = lvl_of_name[father]
        if max_level in names_of_lvl:
            names_of_lvl[max_level].add(father)
        else:
            names_of_lvl[max_level] = {father}
        children[father] = edges[father] - visited 
        for child in children[father]:
            fathers[child] = father
            lvl_of_name[child] = max_level + 1
        queue.extend(children[father])
    return fathers, children, max_level, names_of_lvl
        
class Tree:
    def __init__(self, root, weight):
        self.root = root
        self.weight = weight
        self.father = None
        self.subtrees = []
        self.weight_sum = self.weight

    def add_subtree(self, subtree):
        self.subtrees.extend(subtree)
        self.weight_sum += subtree.weight_sum
        
    def remove_subtree(self, subtree):
        self.subtrees.remove(subtree)
        self.weight_sum -= subtree.weight_sum

if __name__ == '__main__':
    main()