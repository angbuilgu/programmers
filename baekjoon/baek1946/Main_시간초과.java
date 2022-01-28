package baek1946;


import java.util.HashMap;
import java.util.Scanner;

public class Main_시간초과 {

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
			for(int j = 2; j <= N; j++) { // 서류심사 2등부터 앞 순서들과 비교해 면접성적이 낮은 경우가 하나라도 있다면 map에서 제외
				int flag = 0;
				for(int k = j - 1; k > 0; k--) {
					if(map.get(k) == null) { // 이미 없어진 경우에는 넘어간다
						continue;
					}
					if(map.get(j) > map.get(k)) { // 이 경우 두 성적 모두 떨어진자
						map.remove(j);
						break;
					}
				}
			}
			Ts[i] = map.size();
			
		}
		for(int i : Ts) {
			System.out.println(i);
		}

	}

}
