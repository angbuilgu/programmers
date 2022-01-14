def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge = []
    flag = 0
    while True:
            
        if len(bridge) != 0:
            temp = 0
            while True:
                if temp > len(bridge)-1:
                    break
                bridge[temp][1] += 1
                if bridge[temp][1] == bridge_length:
                    bridge.pop(temp)
                    temp -= 1
                temp += 1
        if len(bridge) == 0:
            bweight = 0
        else:
            bsum = 0
            for i in bridge:
                bsum += i[0]
            bweight = bsum
            
                
        if len(bridge) <= bridge_length and len(truck_weights) != 0 and truck_weights[0] + bweight <= weight:
            bridge.append([truck_weights.pop(0),0])
        

        answer += 1
        if len(bridge) == 0 and len(truck_weights) == 0:
            break
            
    return answer