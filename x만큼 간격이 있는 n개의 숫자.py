def solution(x, n):
    answer = []
    i = 0
    while(i < n):
        answer.append(x+x*i)
        i+=1
    return answer