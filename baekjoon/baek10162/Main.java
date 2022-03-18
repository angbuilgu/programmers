package baek10162;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int A = 300;
		int B = 60;
		int C = 10;
		int[] answer = new int[3];
		// 10으로 안 나눠지면 -1
		if(T % C != 0) {
			System.out.println(-1);
			System.exit(0);
		}
		// 큰 수부터 뺄 수 있는만큼 뺀다
		int temp = T / A;
		answer[0] = temp;
		T -= A * temp;
		temp = T / B;
		answer[1] = temp;
		T -= B * temp;
		temp = T / C;
		answer[2] = temp;
		System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
	}

}
