package baek5692;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(true) {
			String num = scn.nextLine();
			int answer = 0;
			if(Integer.parseInt(num) == 0)break; // 0이면 끝
			int numlength = num.length();
			for(int i = 0; i < numlength; i++) { // 각 자리수는 자리수의 숫자*!자리수
				int now = num.charAt(i)-48; // ASCII이므로 48뺀다
				int jarisu = 1; // 최소 1
				for(int j = numlength-i; j > 0; j--) { // 팩토리얼
					jarisu *= j;
				}
				answer += now*jarisu;
			}
			System.out.println(answer);
			
		}

	}

}
