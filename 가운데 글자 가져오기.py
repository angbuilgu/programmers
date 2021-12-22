def solution(s):
    answer = ''
    l = len(s)
    if (l % 2 == 1):
        answer = s[l//2]
    else:
        answer = s[l//2 - 1] + s[l//2]
    return answer