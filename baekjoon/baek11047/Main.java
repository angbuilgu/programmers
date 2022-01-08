package baek11047;

import java.util.Scanner;

public class Main {
	
	public int numcoin = 0;
	
	public boolean find(int[] A, int max, int K) {
		if(K == 0) {
			return true;
		}

		int first = K / A[max];
		int K2 = K - A[max] * first;
		numcoin += first;
		if(K2 == 0) {
			return true;
		}
		for(int i = max-1; i >= 0; i--) {
			if(A[i] <= K2) {
				if(find(A,i,K2)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Main m = new Main();
		
		int N = scn.nextInt();
		int K = scn.nextInt();
		int max = 0;
		int[] coins = new int[N];
		int[] answer = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			coins[i] = scn.nextInt();
			answer[i] = 0;
		}
		
		for(int i = N-1; i >= 0; i--) {
			if(coins[i] <= K) {
				max = i;
				break;
			}
		}
		
		if(m.find(coins, max, K)) {
			System.out.println(m.numcoin);
		}
		
		
		
		


	}

}
