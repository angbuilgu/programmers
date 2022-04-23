package baek2886;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int answer = 0;
		int R = scn.nextInt();
		int C = scn.nextInt();
		ArrayList<int[]> X = new ArrayList<int[]>(); // 사람 위치
		ArrayList<int[]> L = new ArrayList<int[]>(); // 의자 위치
		scn.nextLine();
		for(int i = 0; i < R; i++) {
			String line = scn.nextLine();
			for(int j = 0; j < line.length(); j++) {
				if(line.charAt(j) == 'X') {
					X.add(new int[] {i,j});
				}
				if(line.charAt(j) == 'L') {
					L.add(new int[] {i,j});
				}
			}
		}
		HashMap<Integer, ArrayList<int[]>> map = new HashMap<Integer, ArrayList<int[]>>();
		// map에 각 자리에서 특정 인물까지 거리를 저장한다
		for(int i = 0; i < L.size(); i++) {
			map.put(i,new ArrayList<int[]>());
			for(int j = 0; j < X.size(); j++) {
				map.get(i).add(new int[]{j,(int)(Math.pow(L.get(i)[0]-X.get(j)[0], 2)+Math.pow(L.get(i)[1]-X.get(j)[1], 2))});
			}
			map.get(i).sort(new Comparator<int[]>() { // 거리순으로 정렬
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] >= o2[1]) {
						return 1;
					}
					return -1;
				}
			});
		}
		HashMap<Integer, ArrayList<int[]>> map2 = new HashMap<Integer, ArrayList<int[]>>();
		// map2에 각 사람에서 특정 자리까지 거리를 저장한다
		for(int i = 0; i < X.size(); i++) {
			map2.put(i,new ArrayList<int[]>());
			for(int j = 0; j < L.size(); j++) {
				map2.get(i).add(new int[]{j,(int)(Math.pow(L.get(j)[0]-X.get(i)[0], 2)+Math.pow(L.get(j)[1]-X.get(i)[1], 2))});
			}
			map2.get(i).sort(new Comparator<int[]>() { // 거리순으로 정렬
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1] >= o2[1]) {
						return 1;
					}
					return -1;
				}
			});
		}
		
		
		// 각 사람을 보면서 가장 가까운 자리부터 그 자리에 있어도 되는지 살펴본다
		boolean[] ok_seat = new boolean[L.size()];
		boolean[] ok_people = new boolean[X.size()];
		HashMap<Integer, ArrayList<int[]>> ans = new HashMap<Integer, ArrayList<int[]>>();
		/*
		 * 다음과 같은 과정을 반복한다
		 * 1. ok_people를 보며 아직 자리가 정해지지 않은 사람이면 가장 가까운 자리로 간다, 그 ok_seat와 ok_people를 true로 한다
		 * 2. ans를 살펴보며 가장 짧은사람만 남기고 나머지 사람은 참여여부인 ok_people를 false로 바꾼다
		 * 모든 자리와 사람이 정해지면 끝난다
		 */
		while(true) {
			boolean flag = true;
			for(boolean b : ok_people) {
				if(b == false) {
					flag = false;
					break;
				}
			}
			if(flag) { // 모든 자리에 사람이 있고, 모든 사람이 앉거나 싸울곳이 있으면 끝
				break;
			}
			for(int i = 0; i < X.size(); i++) {
				if(ok_people[i] == true) { // 이미 자리가 있으면 넘기기
					continue;
				}
				int[] temp = map2.get(i).get(0);
				map2.get(i).remove(0);
				if(ans.get(temp[0]) == null) {
					ans.put(temp[0], new ArrayList<int[]>());
				}
				ans.get(temp[0]).add(new int[] {i,temp[1]}); // temp[0] 자리에 i번 사람이 앉고 그 거리는 temp[1]
				ok_seat[temp[0]] = true;
				ok_people[i] = true;
			}
			for(int i = 0; i < ok_seat.length; i++) {
				if(ok_seat[i] == false) { // 아직 자리에 아무도 없으므로 넘기기
					continue;
				}
				ArrayList<int[]> seat = ans.get(i); // i번 자리에 가려는 사람들 목록
				seat.sort(new Comparator<int[]>() { // 거리순으로 정렬
					@Override
					public int compare(int[] o1, int[] o2) {
						if(o1[1] >= o2[1]) {
							return 1;
						}
						return -1;
					}
				});
				int index = 1;
				int m_len = seat.get(0)[1];
				while(true) {
					if(index >= seat.size()) { // 없을때까지 계속
						break;
					}
					if(seat.get(index)[1] == m_len) { // 최대값이면 1늘리기
						index++;
					}else {
						ok_people[seat.get(index)[0]] = false; // 나왔으므로 다시 자리를 찾아야한다
						if(map2.get(seat.get(index)[0]).size() == 0) { // 더이상 갈 곳이 없으면 서 있다고 생각
							ok_people[seat.get(index)[0]] = true;
						}
						seat.remove(index);
					}
				}
			}
		}
		for(ArrayList<int[]> list : ans.values()) {
			if(list.size() > 1) { // 같은 거리에 있는 사람이 여려명 있으면
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}
