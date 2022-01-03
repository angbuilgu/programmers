def solution(n):
    answer = 0
    d = 1
    while(True):
        if n // d >= 1:
            d *= 10
        else:
            d /= 10
            break
    
    while(True):
        m = n // d
        answer += m
        n -= m * d
        if d == 1:
            break
        d /= 10

    return answer