def solution(prices):
    answer = []
    leng = len(prices)
    for i in range(0,leng):
        temp = 0
        it = prices[i]
        for j in range(i+1,leng):
            if it > prices[j]:
                temp += 1
                answer.append(temp)
                break
            else:
                temp += 1
                if j == leng-1:
                    answer.append(temp)
                    break
    answer.append(0)
    return answer