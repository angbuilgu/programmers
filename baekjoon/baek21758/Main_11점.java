package baek21758;

import java.util.Scanner;

public class Main_11점 {
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
		for(int i = 0; i < N-1; i++) { // i = 왼쪽 벌의 위치, 맨 오른쪽은 올 수 없다
			for(int j = i+1; j < N; j++) { // j = 오른쪽 벌의 위치, 왼쪽 벌의 다음 위치부터 올 수 있다
				for(int k = 0; k < N; k++) { // k = 벌통 위치, i나 j와 겹치지만 않으면 된다
					if(k == i || k == j) continue; 
					// 모든 경우에 수에 대해 값을 비교하면 된다
					int temp = findnum(M,i,j,k);
					if(temp>answer) answer = temp;
				}
			}
		}
		System.out.println(answer);

	}

}
