import sys
input = sys.stdin.readline


N = input()
Ns = list(map(int,input().split(" ")))
M = input()
Ms = list(map(int,input().split(" ")))

dict = {}

for i in Ns:
    if dict.get(i) == None:
        dict[i] = 1
    else:
        dict[i] += 1

answer = ""
for i in range(0, len(Ms)):
    if dict.get(Ms[i]) == None:
        answer += "0"
    else:
        answer += str(dict[Ms[i]])
    if (i != len(Ms) - 1):
        answer += " "
print(answer)

''' 왜 안됨?
def find(start, end, m):
    ans = 0
    if start <= end:
        mid = (start + end) // 2
        if Ns[mid] == m:
            st = findnum(start, mid, m, False)
            nd = findnum(mid, end, m, True)
            ans = nd - st-1
        elif Ns[mid] < m:
            ans = find(mid + 1, end, m)
        elif Ns[mid] > m:
            ans = find(start, mid - 1, m)
    return ans


def findnum(start, end, m, isup):
    ans = start if isup else end
    if start <= end:
        mid = (start + end) // 2
        if isup and Ns[(mid+end)//2] == m:
            ans = findnum((mid+end)//2 + 1, end, m, isup)
        elif isup == False and Ns[(mid+start)//2] == m:
            ans = findnum(start, (mid+start)//2 - 1, m, isup)
        elif Ns[mid] == m:
            ans = findnum(mid+1, end, m, isup) if isup else findnum(start, mid-1, m, isup)
        elif Ns[mid] < m:
            ans = findnum(mid + 1, end, m,isup)
        elif Ns[mid] > m:
            ans = findnum(start, mid - 1, m,isup)

    return ans





N = input()
Ns = list(map(int,input().split(" ")))
M = input()
Ms = list(map(int,input().split(" ")))

Ns.sort()



answer = ""
temp = -10000001
tempnum = 0
for i in range(0, len(Ms)):
    if Ms[i] == temp:
        answer += str(tempnum)
    else:
        tempnum = find(0, len(Ns) - 1, Ms[i])
        answer += str(tempnum)
    if(i != len(Ms)-1):
        answer += " "
print(answer)'''

