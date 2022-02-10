# 예시
모든 문제는 설명, 입력, 출력, 접근방법, 코드가 있는 readme파일로 정리한다
다음은 그 예시

# 1로 만들기

URL: https://www.acmicpc.net/problem/1463

# 문제

정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
2. X가 2로 나누어 떨어지면, 2로 나눈다.
3. 1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

## 입력

첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

## 출력

첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

## 문제 접근 방법

1. 주어진 수가 연산 가능한 경우를 큐에 넣는다(BFS)
2. 트리에서 같은 층에 있는 수들은 같은 횟수의 연산을 했으므로 처음으로 1이 나온 경우가 가장 적은 연산 횟수이다

### 코드 
```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		// BFS를 위해 큐 사용
		ArrayList<int[]> list = new ArrayList<int[]>();
		// 이미 나왔던 수가 또 나오면 무조건 더 늦으므로 넣을 필요 없다
		// 이미 나왔는지 판단
		ArrayList<Integer> joongbok = new ArrayList<Integer>();
		// 먼저 큐에 숫자를 넣는다
		list.add(new int[] {N,0}); // {수,*번째연산}
		int[] now = null;
		
		while(true) {
			// now에 pop
			// now에 3가지 경우의 수를 대입하고 연산+1한 배열을 큐에 추가
			now = list.get(0);
			list.remove(0); // pop
			if(now[0] == 1) break; // 최소한의 연산으로 1이되는 경우
			
			// 중복 체크 포함해서
			// 3으로 나눠지는 경우
			if(now[0] % 3 == 0 && !joongbok.contains(now[0]/3)) {
				joongbok.add(now[0]/3);
				list.add(new int[] {now[0]/3, now[1]+1});
			}
			// 2로 나눠지는 경우
			if(now[0] % 2 == 0 && !joongbok.contains(now[0]/2)) {
				joongbok.add(now[0]/2);
				list.add(new int[] {now[0]/2, now[1]+1});
			}
			// 1 뺀 경우
			if(!joongbok.contains(now[0]-1)) {
				joongbok.add(now[0]-1);
				list.add(new int[] {now[0]-1, now[1]+1});
			}
		}
		System.out.println(now[1]);
		
	}
}
```

### 개선사항
귀찮다고 아는방법 안쓰려고 하면 시간만 더 버린다