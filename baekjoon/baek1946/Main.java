package baek1946;


import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int[] Ts = new int[T];
		for(int i = 0; i < T; i++) { // 테스트 케이스의 수만큼 반복
			int N = scn.nextInt();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j = 0; j < N; j++) {
				map.put(scn.nextInt(), scn.nextInt()); // map에 서류심사:면접성적 형태로 저장
			}
			int min = map.get(1); // 1등의 면접성적
			for(int j = 2; j <= N; j++) { // 서류심사 2등부터 앞 순서들의 면접성적 중 가장 최고등수인 min보다 낮지 않으면 탈락
				if(map.get(j) > min) {
					map.remove(j);
				}
				else { // 이 등수는 이후 등수들의 면접성적과 비교된다
					min = map.get(j);
				}
			}
			Ts[i] = map.size();
			
		}
		for(int i : Ts) {
			System.out.println(i);
		}

	}

}
