def solution(a, b):
    answer = 0
    big = a
    small = b
    if a < b:
        big = b
        small = a
    for i in range(small,big+1):
        answer += i
    return answer