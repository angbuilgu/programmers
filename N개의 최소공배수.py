def GCD(a, b):
    while(b != 0):
        c = a % b
        a = b
        b = c
    return a

def LCM(a,b):
    return a * b / GCD(a,b)

def solution(arr):
    answer = 0
    l = arr[0]
    for i in arr:
        l = LCM(l, i)
    answer = l
    return answer