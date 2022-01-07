package baek11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int answer = 0;
		int num = scn.nextInt();
		scn.nextLine();
		String Ps = scn.nextLine();
		int[] P = new int[num];
		String[] Pss = Ps.split(" ");
		for(int i = 0; i < num; i++) {
			P[i] = Integer.valueOf(Pss[i]);
		}
		Arrays.sort(P);
		for(int i = 0; i < num; i++) {
			answer += P[i] * (num-i);
		}
		System.out.println(answer);

	}

}
