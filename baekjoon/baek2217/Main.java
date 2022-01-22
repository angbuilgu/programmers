package baek2217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] M = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			M[i] = scn.nextInt();
		}
		Arrays.sort(M);
		for(int i = 0; i < N; i++) {
			if((N-i)*M[i] > max) max = (N-i)*M[i];
		}
		System.out.println(max);

	}

}
