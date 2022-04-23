# 자리 전쟁

URL: https://www.acmicpc.net/problem/2886

# 문제

R x C의 형태를 지닌 전차 안에는 의자와 사람들의 정보들이 주어진다. 사람들은 다리가 아픈 것을 매우 싫어하기 때문에 빈 의자가 보이면 무조건 앉으려고 한다.

하지만 나보다 의자에 가까이 있는 사람이 보이면, 그 사람이 먼저 앉는다는 것을 알기 때문에 양보할 수밖에 없다.

만약, 나보다 의자에 가까이 있는 사람은 없지만, 같은 거리에 있는 사람이 있으면 서로 자리를 차지하려고 할 것이므로, 그 자리는 전쟁터가 될 것이다. (심지어 모든 사람들은 싸움에 자신있기 때문에, 이러한 전쟁터를 거부하지 않는다(!) )

여러분들은 이 전차의 정보가 주어질 때, 전쟁터가 될 자리의 수를 세어주면 된다.

A행 B열에서 C행 D열과의 떨어진 거리 Dist는 다음과 같은 유클리드 거리로 계산된다.

Dist² = (A-C)² + (B-D)²

# 입력

첫 줄에는 R과 C가 입력된다. (1 ≤ R ≤ 100) and (1 ≤ C ≤ 100)

이후 R개의 줄에 걸쳐 문자가 C개씩 주어진다. 이 문자는 '.' (빈 공간), 'X' (사람), 'L' (좌석) 만 주어지는 것이 보장된다.

'X'와 'L' 문자는 적어도 하나 이상이 주어짐이 보장되고, 하나의 'X' 문자와 같은 거리에 떨어진 'L'은 2개 이상 존재하지 않음이 보장된다.

# 출력

전쟁터의 수를 출력하면 된다.

# 문제 접근 방법

1. 각 사람당 의자와의 거리를 줄세운다
2. 각 사람당 가장 가까운 의자에 간다고 가정한다, 이미 간 의자가 있으면 놔둔다
3. 각 의자당 가장 가까운 사람들만 놔두고 나머지는 돌려보낸다
4. 2~3을 모든 사람이 가는 곳이 있을때까지 반복한다
5. 의자에 여러 사람이 있으면 싸움이 일어난다

# 코드 
```java
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
```

# 개선사항

- 또 하라면 못할거같다. 비슷한 유형 더 해볼 것
- 많이 헤매서 코드가 좀 이상하다. 시간날 때 고칠 것