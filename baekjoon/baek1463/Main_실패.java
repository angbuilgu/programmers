package baek1463;

import java.util.Scanner;

public class Main_실패 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int answer = 0;
		while(true) {
			if(N == 1) break;
			
			if(N % 3 == 0) { // 3으로 나눠지면
				N /= 3;
				answer++;
			}
			else if(N % 2 == 0) { // 2로 나눠지면
				if((N-1) % 3 == 0) {
					N--;
				}
				else {
					N /= 2;
				}
				answer++;
			}
			else { // 2나 3으로 안 나눠지면
				N -= 1;
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}
