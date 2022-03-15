package baek18352;

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
