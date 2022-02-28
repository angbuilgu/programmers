package baek2579;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		if(N == 0) {
			System.out.println(0);
			System.exit(0);
		}
		int[] scores = new int[N];
		for(int i = 0; i < N; i++) {
			scores[i] = scn.nextInt();
		}
		
		boolean do_bun = false; // 최대값이 마지막 두 계단을 밟았는지
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>(); // 최대값과 저장
		
		if(N == 1) { // 0이나 1인경우
			System.out.println(scores[0]);
			System.exit(0);
		}else if(N == 2) {
			System.out.println(scores[0] + scores[1]);
			System.exit(0);
		}
		
		int[] save = new int[2];
		map.put(0, scores[0]);
		map.put(1,scores[0] + scores[1]); // 이건 무조건 맞다
		map.put(2,scores[0] + scores[2]);
		if(scores[1] > scores[0]) {
			do_bun = true;
			map.put(2, scores[1] + scores[2]);
		}
		
		
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
