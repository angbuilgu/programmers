def solution(arr):
    answer = []
    answer.append(arr[0])
    last = arr[0]
    length = len(arr)
    for i in range(1,length):
        if arr[i] == last:
            continue
        else:
            answer.append(arr[i])
            last = arr[i]
    return answer