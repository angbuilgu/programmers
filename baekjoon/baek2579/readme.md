# 계단 오르기

URL: https://www.acmicpc.net/problem/2579

# 문제

계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다. <그림 1>과 같이 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
![1](https://user-images.githubusercontent.com/87894389/155983314-65d8121e-6011-452c-9347-577bba5a0ea2.png)

예를 들어 <그림 2>와 같이 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
![2](https://user-images.githubusercontent.com/87894389/155983343-d81659e9-fc2c-4e15-ae10-13626bbfd5f5.png)

계단 오르는 데는 다음과 같은 규칙이 있다.

1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.

따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다. 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.

각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
# 입력

입력의 첫째 줄에 계단의 개수가 주어진다.

둘째 줄부터 한 줄에 하나씩 제일 아래에 놓인 계단부터 순서대로 각 계단에 쓰여 있는 점수가 주어진다. 계단의 개수는 300이하의 자연수이고, 계단에 쓰여 있는 점수는 10,000이하의 자연수이다.

# 출력

첫째 줄에 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력한다.

# 문제 접근 방법

특정 층에서의 얻을 수 있는 총 점수의 최댓값은 이전 계단에서 얻을 수 있는 계단의 최댓값과 연관이 있다
1. 이전 계단에서 얻을 수 있는 최댓값이 마지막 계단과 그 이전 계단을 연속해서 밟은 경우
	1. 이전 계단을 밟는다: 세 단계 이전에서 얻을 수 있는 최댓값에서 마지막으로 추가하는 계단의 점수를 더하면 된다
	2. 이전 계단을 밟지 않는다: 두 단계 이전에서 얻을 수 있는 최댓값에서 마지막으로 추가하는 계단의 점수를 더하면 된다
2. 이전 계단에서 얻을 수 있는 최댓값이 마지막 계단과 그 이전 계단을 연속해서 밟지 않은 경우
	1. 이전 계단에서 얻을 수 있는 최댓값에서 마지막으로 추가하는 계단의 점수를 더하면 된다

# 코드 
```java
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		if(N == 0) { // 0인 경우
			System.out.println(0);
			System.exit(0);
		}
		int[] scores = new int[N];
		for(int i = 0; i < N; i++) {
			scores[i] = scn.nextInt();
		}
		
		boolean do_bun = false; // 최대값이 마지막 두 계단을 밟았는지
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>(); // 최대값과 저장
		
		if(N == 1) { // 1이나 2인경우
			System.out.println(scores[0]);
			System.exit(0);
		}else if(N == 2) {
			System.out.println(scores[0] + scores[1]);
			System.exit(0);
		}
		
		int[] save = new int[2];
		map.put(0, scores[0]);
		map.put(1,scores[0] + scores[1]);
		map.put(2,scores[0] + scores[2]);
		if(scores[1] > scores[0]) {
			do_bun = true;
			map.put(2, scores[1] + scores[2]);
		}// 이건 무조건 맞다
		
		
		for(int i = 3; i < N; i++) {
			if(do_bun) { // 이전 최대값이 계단을 연속해서 밟은경우
				int max = map.get(i-2) + scores[i];
				do_bun = false;
				if(map.get(i-3)+ scores[i] + scores[i-1] > max) { // 맨 마지막 두 계단을 밟을 경우가 더 크면
					max = map.get(i-3) + scores[i] + scores[i-1];
					do_bun = true; // 마지막 두 계단 밟았으므로
				}
				map.put(i,max);
			}else {
				int max = map.get(i-1) + scores[i];
				do_bun = true; // 연달아 밟았으므로
				if(map.get(i-2) > map.get(i-1)) { // 이러면 연달아 밟지 않으므로
					max = map.get(i-2) + scores[i];
					do_bun = false;
				}
				map.put(i, max);
			}
		}
			System.out.println(map.get(map.size()-1));
	}

}
```

### 개선사항
접근방식을 미리 생각하고 접근할 것