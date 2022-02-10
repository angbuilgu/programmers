package baek1463;

import java.util.ArrayList;
import java.util.HashMap;
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
