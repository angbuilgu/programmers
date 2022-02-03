package baek2745;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] str = scn.nextLine().split(" "); // 한줄 받아서 B,N으로 나눈다
		String B = str[0];
		int answer = 0;
		int N = Integer.parseInt(str[1]);
		
		// 한 문자씩 N진법으로 계산해서 answer에 더한다
		
		for(int i = 0; i < B.length(); i++) {
			int ch = B.charAt(i); // (아스키)숫자는 49~57 알파벳A~Z는 65~90
			if(ch < 65) ch -= 48; // 숫자는 -48
			else ch -= 55; // 문자는 -55
			answer += ch * Math.pow(N, (B.length()-i-1)); // i번째숫자^(길이-1-i)
		}
		
		System.out.println(answer);
		

	}

}

// Integer.parseUnsignedInt(s.next(),s.nextInt()) 그냥 이거쓰면 변환해준다