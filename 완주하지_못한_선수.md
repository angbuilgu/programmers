# 완주하지 못한 선수

URL: https://programmers.co.kr/learn/courses/30/lessons/17681

# 문제

수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

## 입력

- 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
- completion의 길이는 participant의 길이보다 1 작습니다.
- 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
- 참가자 중에는 동명이인이 있을 수 있습니다.

## 입출력 예

|participant|completion|return|
|------|---|---|
|["leo", "kiki", "eden"]|["eden", "kiki"]|"leo"|
|["marina", "josipa", "nikola", "vinko", "filipa"]|["josipa", "filipa", "marina", "nikola"]|"vinko"|
|["mislav", "stanko", "mislav", "ana"]|["stanko", "ana", "mislav"]|"mislav"|

## 입출력 예 설명
예제 #1
"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #2
"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.

예제 #3
"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.

## 문제 접근 방법

1. 딕셔너리에 이름:횟수 형태로 저장한다
2. completion에 있는대로 빼고 남은 이름을 반환한다

### 코드 
```python
def solution(participant, completion):
    map = {} # 딕셔너리
    for i in participant:
        if i in map: # 이미 있으면 +1
            map[i] += 1
        else: # 없으면 1
            map[i] = 1
    for i in completion: # 무조건 딕셔너리에 있다
        if map[i] > 1: # 1보다 크면 -1
            map[i] -= 1
        else: # 1이면 제거
            map.pop(i)
    return list(map.keys())[0] # key가 하나만 있으니 반환하면 된다
```

### 개선사항
```python
import collections
def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]
```
Collections는 많이 사용되므로 알아볼 것