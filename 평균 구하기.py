def solution(arr):
    answer = 0
    all = 0
    for i in arr:
        all += i
    answer = all / len(arr)
    return answer