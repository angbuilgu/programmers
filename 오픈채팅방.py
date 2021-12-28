def solution(record):
    answer = []
    user_id = []
    nickname = []
    flow = []
    flow2 = []
    index = 0
    for i in record:
        temp = i.split(" ")
        command = temp[0]
        if command == "Enter":
            tid = temp[1]
            tnick = temp[2]
            if tid in user_id:
                index = user_id.index(tid)
                nickname[index] = tnick
                flow.append(index)
                flow2.append(1)
            else:
                user_id.append(tid)
                nickname.append(tnick)
                index = len(user_id)-1
                flow.append(index)
                flow2.append(1)

        elif command == "Leave":
            tid = temp[1]
            index = user_id.index(tid)
            flow.append(index)
            flow2.append(0)
                    
        elif command == "Change":
            tid = temp[1]
            tnick = temp[2]
            index = user_id.index(tid)
            nickname[index] = tnick
            
    length = len(flow)
    for i in range(0,length):
        if flow2[i] == 1:
            answer.append(nickname[flow[i]]+"님이 들어왔습니다.")
        else:
            answer.append(nickname[flow[i]]+"님이 나갔습니다.")
        
                
                
        
    
    
    return answer