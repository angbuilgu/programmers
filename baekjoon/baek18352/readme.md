# 특정 거리의 도시 찾기

URL: https://www.acmicpc.net/problem/18352

# 문제

어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.

이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성하시오. 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정한다.

예를 들어 N=4, K=2, X=1일 때 다음과 같이 그래프가 구성되어 있다고 가정하자.

![1](https://user-images.githubusercontent.com/87894389/158380631-a070b261-d3e5-4dba-9d5c-122596ff6a41.jpg)

이 때 1번 도시에서 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 2인 도시는 4번 도시 뿐이다.  2번과 3번 도시의 경우, 최단 거리가 1이기 때문에 출력하지 않는다.

# 입력

첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다. (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N) 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다. 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다. (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.

# 출력

X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.

이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.

# 문제 접근 방법

1. 도시의 연결 관계를 저장한다
2. 다익스트라 방식을 활용해 시작도시부터 연결된 도시를 찾아가며 거리가 K인 도시까지 탐색한다

# 코드 
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt(); // 도시 개수
		int M = scn.nextInt(); // 도로 개수
		int K = scn.nextInt(); // 거리 정보
		int X = scn.nextInt(); // 출발 도시의 정보
		int answer = 0;
		
		// 도시 정보를 저장할 리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			int from = scn.nextInt(); // 도로정보1
			int to = scn.nextInt(); // 도로정보2
			list.get(from-1).add(to); // 단방향 도로 추가
		}
		
		boolean[] visit = new boolean[N]; // 모든 항목 false
		int[] length = new int[N]; // 모든 항목 0
		
		for(int i = 0; i < N; i++) {
			length[i] = -2;
		}
		visit[X-1] = true;
		length[X-1] = 0;
		int visitnum = 1;
		while(true) {
			// 모든 도시를 방문했다면 탈출
			if(visitnum == N) {
				break;
			}

			visitnum = length[X-1]+1;
			// 목표 길이를 방문했다면 탈출
			if(visitnum == K+2) {
				break;
			}
			for(int i : list.get(X-1)) { // 현재 보고있는 도시와 연결된 도시
				if(visit[i-1] == false) {
					length[i-1] = length[X-1]+1;
					visit[i-1] = true;
					queue.add(i); // 다음 경로에 추가
				}
			}
			if(queue.size() == 0) { // 연결된 도시가 없으면 탈출
				break;
			}else { // queue에서 다음 도시 확인
				visitnum++;
				X = queue.get(0);
				queue.remove(0);
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == true && length[i] == K) {
				answer++;
				System.out.println(i+1);
			}
		}
		if(answer == 0) {
			System.out.println(-1);
		}
		

	}

}

```