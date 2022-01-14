def solution(progresses, speeds):
    answer = []
    while True:
        progresses = [x+y for x,y in zip(progresses, speeds)]
        ans = 0
        if progresses[0] >= 100:
            while True:
                ans += 1
                progresses.pop(0)
                speeds.pop(0)
                if len(progresses) == 0:
                    break
                if progresses[0] >= 100:
                    continue
                else:
                    break
            answer.append(ans)
        if len(progresses) == 0:
            break
    return answer