def solution(n):
    answer = ''
    i = 0
    while(i < n):
        if(i % 2 == 1):
            answer += "박"
        else:
            answer += "수"
        i +=1
    return answer