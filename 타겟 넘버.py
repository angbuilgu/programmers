def add(num1, num2):
    return num1+num2
def sub(num1, num2):
    return num1-num2

def solution(numbers, target):
    answer = 0
    leng = len(numbers)
    giho = [0]*leng
    for i in range (0,2**leng):
        ans = 0
        lists = list(bin(i)[2:].zfill(leng)) # 0 ='-' 1 = '+'라 하고 모든 경우의 수 만들기
        for j in range(0,leng): # numbers의 숫자는 같은 위치의 list 기호와 대응되어 ans에 반영
            if lists[j] == '0':
                ans = sub(ans,numbers[j])
            else:
                ans = add(ans,numbers[j])
        if ans == target:
            answer += 1
    
    
    return answer