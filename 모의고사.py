def solution(answers):
    answer = []
    ansA = 1
    ansB = 2
    ansC = 3
    flag = 0
    scoreA = 0
    scoreB = 0
    scoreC = 0
    B = {}
    B[1] = 1
    B[3] = 3
    B[5] = 4
    B[7] = 5
    C = {}
    C[0] = 3
    C[1] = 3
    C[2] = 1
    C[3] = 1
    C[4] = 2
    C[5] = 2
    C[6] = 4
    C[7] = 4
    C[8] = 5
    C[9] = 5
    for i in answers:
        flag += 1
        if i == ansA:
            scoreA += 1
        if i == ansB:
            scoreB += 1
        if i == ansC:
            scoreC += 1
        if ansA == 5:
            ansA = 1
        else:
            ansA += 1
        if flag % 2 == 0:
            ansB = 2
        else:
            ansB = B[flag % 8]
        ansC = C[flag % 10]
    if scoreA >= scoreB and scoreA >= scoreC:
        answer.append(1)
    if scoreB >= scoreA and scoreB >= scoreC:
        answer.append(2)
    if scoreC >= scoreA and scoreC >= scoreB:
        answer.append(3)
        
    return answer