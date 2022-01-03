import operator

contries = input().split(' ')
WDL = {} # 확률
entries = []
percent = {}
for i in contries:
    WDL[i] = {}
    entries.append(i)
    percent[i] = 0.0
answer = WDL
for i in range(0,6):
    league = input().split(' ')
    if entries.index(league[0]) < entries.index(league[1]):
        WDL[league[0]][league[1]] = (float(league[2]), float(league[3]), float(league[4]))
    else:
        WDL[league[1]][league[0]] = (float(league[4]), float(league[3]), float(league[2]))

WDL2 = {} # 기댓값
threes = 3*3*3*3*3*3
for i in range(0,threes):
    WDL2[i] = {}
cnt = 0
for a in range(0,3):
    if a == 0:
        aa = 3
        aaa = 0
    elif a == 1:
        aa = 1
        aaa = 1
    else:
        aa = 0
        aaa = 3
        #aa를 바꾸니까 값이 바뀐다
    for b in range(0, 3):
        if b == 0:
            bb = 3
            bbb = 0
        elif b == 1:
            bb = 1
            bbb = 1
        else:
            bb = 0
            bbb = 3
        for c in range(0, 3):
            if c == 0:
                cc = 3
                ccc = 0
            elif c == 1:
                cc = 1
                ccc = 1
            else:
                cc = 0
                ccc = 3
            for d in range(0, 3):
                if d == 0:
                    dd = 3
                    ddd = 0
                elif d == 1:
                    dd = 1
                    ddd = 1
                else:
                    dd = 0
                    ddd = 3
                for e in range(0, 3):
                    if e == 0:
                        ee = 3
                        eee = 0
                    elif e == 1:
                        ee = 1
                        eee = 1
                    else:
                        ee = 0
                        eee = 3
                    for f in range(0, 3):
                        if f == 0:
                            ff = 3
                            fff = 0
                        elif f == 1:
                            ff = 1
                            fff = 1
                        else:
                            ff = 0
                            fff = 3
                        # 각 팀의 점수 및 확률
                        WDL2[cnt][entries[0]] = (aa + bb + cc, WDL[entries[0]][entries[1]][a] * WDL[entries[0]][entries[2]][b] * WDL[entries[0]][entries[3]][c])


                        WDL2[cnt][entries[1]] = (aaa + dd + ee, WDL[entries[0]][entries[1]][a] * WDL[entries[1]][entries[2]][d] * WDL[entries[1]][entries[3]][e])


                        WDL2[cnt][entries[2]] = (bbb + ddd + ff, WDL[entries[0]][entries[2]][b] * WDL[entries[1]][entries[2]][d] * WDL[entries[2]][entries[3]][f])


                        WDL2[cnt][entries[3]] = (ccc + eee + fff, WDL[entries[0]][entries[3]][c] * WDL[entries[1]][entries[3]][e] * WDL[entries[2]][entries[3]][f])
                        cnt += 1


game = 0
for i in WDL2:
    if WDL2[i][entries[0]][1] == 0.0 or WDL2[i][entries[1]][1] == 0.0 or WDL2[i][entries[2]][1] == 0.0 or WDL2[i][entries[3]][1] == 0.0:
        continue
    #print(WDL2[i])
    for j in WDL2[i]:
        game += 1
        temp = dict(reversed(sorted(WDL2[i].items(), key= lambda x:x[1][0])))
        #print(temp)
        top = []
        nxt = []
        for k in temp:
            if len(top) == 0 or temp[k][0] == top[len(top)-1][1][0]:
                top.append((k,temp[k]))
            elif len(top) < 2 and (len(nxt) == 0 or temp[k][0] == nxt[len(nxt)-1][1][0]):
                nxt.append((k,temp[k]))
            else:
                break
        #print("top: ", top)
        #print("nxt: ", nxt)
        if len(top) > 1:
            for k in top:
                percent[k[0]] += 1.0 / len(top)
        else:
            percent[top[0][0]] += 1.0
            if len(nxt) > 1:
                for k in nxt:
                    percent[k[0]] += 1.0 / len(nxt)
            else:
                percent[nxt[0][0]] += 1.0


#print(percent)
#print(game)

for i in percent:
    print("{0:.10f}".format(percent[i] / game))
    #print(percent[i] / game)


'''KOREA CCC BBB AAA
KOREA CCC 1.0 0.0 0.0
AAA BBB 0.428 0.144 0.428
AAA KOREA 0.0 0.0 1.0
CCC BBB 0.0 0.0 1.0
KOREA BBB 1.0 0.0 0.0
CCC AAA 0.0 0.0 1.0'''

'''KOREA CCC BBB AAA
KOREA CCC 0.0 1.0 0.0
AAA BBB 0.0 1.0 .0
AAA KOREA 0.0 0.0 1.0
CCC BBB 0.0 1.0 0.0
KOREA BBB 1.0 0.0 0.0
CCC AAA 0.5 0.0 0.5'''

