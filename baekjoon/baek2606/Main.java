package baek2606;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int M = scn.nextInt();
		int num = 0;
		int now = 1;
		ArrayList<Integer> sq = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < M; i++) {
			int temp1 = scn.nextInt();
			int temp2 = scn.nextInt();
			if(map.get(temp1) == null) map.put(temp1,new ArrayList<Integer>());
			if(map.get(temp2) == null) map.put(temp2,new ArrayList<Integer>());
			if(map.get(temp1).contains(temp2)) continue;
			map.get(temp1).add(temp2);
			map.get(temp2).add(temp1);
		}
//		for(int i : map.keySet()) {
//			System.out.println(i+" "+map.get(i));
//		}
		if(map.get(now) == null) { // 연결된게 없으면
			System.out.println(0);
		}
		else { // 1번 pc에 연결된 컴퓨터 찾기
			for(int i : map.get(now) ) {
				for(int j = 0; j < map.get(i).size(); j++) { // arraylist에 부모가 있으므로 제거
					if(map.get(i).get(j) == now) {
						map.get(i).remove(j);
						break;
					}
				}
				sq.add(i); // 연결된 pc를 스텍에 추가
			}
			while(true) {
				if(sq.size() == 0) {
					break;
				}
				num++;
				now = sq.get(sq.size()-1);
				sq.remove(sq.size()-1);
				for(int i : map.get(now) ) {
					for(int j = 0; j < map.get(i).size(); j++) { // 자식 arraylist에 부모가 있으므로 제거
						if(map.get(i).get(j) == now) {
							map.get(i).remove(j);
							break;
						}
					}
					for(int j = 0; j < sq.size(); j++) { // 스텍에 있는경우 가장 위로 올리기
						if(sq.get(j) == i) { // 스텍 아래쪽에 있는 겹치는 숫자 지우기
							sq.remove(j);
							break;
						}
					}
					sq.add(i); // 연결된 pc를 스텍에 추가
				}
			}
			System.out.println(num);
				
		}
	}

}
