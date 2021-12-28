def solution(phone_number):
    answer = ''
    length = len(phone_number)
    star = "********************"
    answer = star[0:length-4]+phone_number[length-4:]
       
        
    return answer