def solution(s):
    answer = True
    if (len(s) != 4 and len(s) != 6) or s.isdigit() == False:
        answer = False
    return answer