package baek1026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int num = scn.nextInt();
		int[] A = new int[num];
		int[] B = new int[num];
		int[] C = new int[num];
		int[] D = new int[num];
		int ans = 0;
		
		for(int i = 0; i < num; i++) {
			A[i] = scn.nextInt();
		}
		for(int i = 0; i < num; i++) {
			int t = scn.nextInt();
			B[i] = t;
			C[i] = t;
		}
		Arrays.sort(A);
		for(int i = 0; i < num; i++) {
			int temp = A[num-1-i];
			if(temp == 0) {
				continue;
			}
			else {
				int flag = -1;
				int min = 100000;
				for(int j = 0; j < num; j++) {
					if(temp * C[j] < min) {
						flag = j;
						min = temp * C[j];
					}
				}
				D[flag] = temp;
				C[flag] = 102;
			}

		}
		for(int i = 0; i < num; i++) {
			ans += D[i]*B[i];
		}
		System.out.println(ans);

	}

}