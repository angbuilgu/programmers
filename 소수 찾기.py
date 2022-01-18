from itertools import permutations

def findsosu(n):
    for i in range(2,n//2+1):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    nums = list(numbers)
    leng = len(nums)
    joongbok = []
    for i in range(1,leng+1):
        lists = list(permutations(nums, i))
        for j in lists:
            temp = 0
            for k in range(0,i):
                temp += int(j[k])*(10**k)
            if temp == 0 or temp == 1 or temp in joongbok:
                continue
            else:
                joongbok.append(temp)
            if findsosu(temp):
                answer += 1
        
        
    return answer