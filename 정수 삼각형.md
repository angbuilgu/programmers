# 정수 삼각형

URL: https://programmers.co.kr/learn/courses/30/lessons/43105

# 문제

<img width="184" alt="1" src="https://user-images.githubusercontent.com/87894389/156152102-92cfece3-d7e4-425f-b687-f74ecef6927e.png">

위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.

삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.

# 입출력

- 삼각형의 높이는 1 이상 500 이하입니다.
- 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.

|triangle|result|
|------|---|
|[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]|30|

# 문제 접근 방법

1. 한 요소까지 오기위한 최대값은 그 요소까지 올 수 있는 이전 층의 요소 2가지(또는 1가지)의 최대값 중 더 큰값에서 자신을 더한 값이다
2. 1을 구현한다

# 코드 
```python
def solution(triangle):
    answer = 0
    # 생각해보자
    # 한 층의 한 요소까지 도달하는 경로 중 가장 큰 경우는?
    # 자신까지 도달할 수 있는 이전 층의 요소들 중 도달까지의 값이 가장 큰 요소 + 자신
    # 이걸로 간다
    yeah = [triangle[0][0]] # 여기 저장
    for i in range(1,len(triangle)):
        temp = [] # 초기화
        for j in range(0,len(triangle[i])): # [...,[여기랑 비교한다],[여기를 본다],...]
            # j가 0이거나 맨 끝이면 길이 하나밖에 없다
            if j == 0:
                temp.append(yeah[j]+triangle[i][j]) # 이전값의 최대값 + 자기자신
            elif j == len(triangle[i]) - 1:
                temp.append(yeah[j-1]+triangle[i][j]) # 이전값의 최대값 + 자기자신
            else:
                t = yeah[j]+triangle[i][j]
                if yeah[j-1]+triangle[i][j] > t:
                    t = yeah[j-1]+triangle[i][j] # 가능한 경로 2개 중 더 큰값을 가진다
                temp.append(t)
        yeah = temp # 다음으로 넘어가기 전 yeah에 저장
    # 이제 yeah에 삼각형의 바닥까지 가는 최대경로가 있다
    return max(yeah)
```

# ???
```python
solution = lambda t, l = []: max(l) if not t else solution(t[1:], [max(x,y)+z for x,y,z in zip([0]+l, l+[0], t[0])])
```
이게 뭐고