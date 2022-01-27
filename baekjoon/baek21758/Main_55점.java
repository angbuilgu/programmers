package baek21758;


import java.util.Collections;
import java.util.Scanner;

public class Main_55점 {
	public static int findnum(int[] M, int firstbee, int secondbee, int pot) {
		int num = 0;
		// 벌통이 가장 왼쪽
		if(pot < firstbee) {
			for(int i = pot; i < firstbee; i++) {
				num += M[i];
			}
			for(int i = pot; i < secondbee; i++) {
				if(i == firstbee) continue; // 벌이 있으면 통과
				num += M[i];
			}
		}
		// 벌통이 가운데
		else if(pot > firstbee && pot < secondbee) {
			for(int i = firstbee+1; i <= pot; i++) {
				num += M[i];
			}
			for(int i = pot; i < secondbee; i++) {
				num += M[i];
			}
		}
		// 벌통이 가장 오른쪽
		else {
			for(int i = pot; i > secondbee; i--) {
				num += M[i];
			}
			for(int i = pot; i > firstbee; i--) {
				if(i == secondbee) continue; // 벌이 있으면 통과
				num += M[i];
			}
		}
		
		
		
		return num;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] M = new int[N];
		int answer = 0;
		for(int i = 0; i < N; i++) {
			M[i] = scn.nextInt();
		}
		// 두 벌의 위치와 벌통의 위치를 설정
		// 1. 벌통이 가장 오른쪽에 있는 경우, 벌통은 오른쪽 끝에 있어야 한다.
		// 이 경우 왼쪽 벌은 왼쪽 끝에 있어야 한다
		for(int i = 1; i< N-1; i++) {
			int temp = findnum(M,0,i,N-1);
			if(temp>answer) answer = temp;
		}
		// 2. 벌통이 가장 왼에 있는 경우 -> 1의 반대
		for(int i = N-2; i > 0; i--) {
			int temp = findnum(M,i,N-1,0);
			if(temp>answer) answer = temp;
		}
		// 3. 벙통이 가운데 있는 경우
		// 양 벌이 끝에 있어야 하므로 리스트의 합에서 양 끝값을 빼고 리스트의 최대값을 더한다
		int max = 0;
		int temp = 0;
		for(int i = 1; i < N-1; i++) {
			if(M[i] > max) max = M[i];
			temp += M[i];
		}
		temp += max;
		if(temp>answer) answer = temp;
		System.out.println(answer);

	}

}
