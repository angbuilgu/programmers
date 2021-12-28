def solution(s):
    answer = ''
    counter = 0
    for i in range(0,len(s)):
        if s[i] == " ":
            counter = 0
            continue
        if counter % 2 == 0:
            s = s[0:i]+s[i].upper()+s[i+1:]
            counter += 1
        else:
            s = s[0:i]+s[i].lower()+s[i+1:]
            counter +=1
    answer = s
    return answer