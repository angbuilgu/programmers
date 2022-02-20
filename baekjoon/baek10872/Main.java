package baek10872;

import java.util.Scanner;

public class Main {
	
	public static long fact(int N) {
		if(N == 1 || N == 0) {
			return 1;
		}
		return N*fact(N-1); // N * (N-1)!
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		System.out.println(fact(N));
	}

}
