'''
Created on 11 Jan 2015

@author: qiao
'''

arr_len, query_num = [int(x) for x in input().split()]

arr = [int(x) for x in input().split()]
queries = []
for idx in range(query_num):
    queries.append([int(x) for x in input().split()])
    
swaps_0 = []
swaps_1 = []
#span = [float("inf"), -1]
for query in queries:
    if query[0] == 1:
        if query[1] % 2 == 0:
            
        swaps.append([query[1], query[2]])
        if query[1] < span[0]:
            span[0] = query[1]
        if query[2] > span[1]:
            span[1] = query[2]
    elif query[2] < span[0] or query[1] > span[1]:
        idx = query[1] - 1
        sum = 0
        while idx < query[2]:
            sum += arr[idx]
            idx += 1
        print(sum)
    else:
        for swap in swaps:
            idx = swap[0] - 1
            while idx < swap[1]:
                arr[idx], arr[idx+1] = arr[idx+1], arr[idx]
                idx += 2
        swaps = []
        span = [float("inf"), -1]
        idx = query[1] - 1
        sum = 0
        while idx < query[2]:
            sum += arr[idx]
            idx += 1
        print(sum)