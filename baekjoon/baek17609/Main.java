package baek17609;

import java.util.Scanner;

public class Main {
	
	public static int search(String str) {
		int ans = 0;
		int lans = 0;
		int rans = 0;
		int hubo1 = -1;
		int hubo2 = -1;
		int end = str.length()-1;
		for(int j = 0; j < end; j++) {
			if(str.charAt(j) == str.charAt(end)) {
				end--;
				continue;
			}
			else {
				if(j+1 < end && str.charAt(j+1) == str.charAt(end)) {
					hubo1 = lastsearch(str.substring(0, j)+str.substring(j+1));
				}
				if(j < end -1 && str.charAt(j) == str.charAt(end-1)) {
					hubo2 = lastsearch(str.substring(0, end)+str.substring(end+1));
				}
				if(hubo1 > 0 && hubo2 > 0) {
					ans = hubo1 < hubo2 ? hubo1 : hubo2;
				}
				else if(hubo1 > 0 && hubo2 < 0) {
					ans = hubo1;
				}
				else if(hubo1 < 0 && hubo2 > 0) {
					ans = hubo2;
				}
				else {
					ans = 2;
				}
				break;
			}
		}
		return ans;
	}
	
	public static int lastsearch(String str) {
		int len = str.length();
		String front;
		String back;
		// 앞뒤 자르기
		if(len % 2 == 1) {
			front = str.substring(0, len/2);
			back = str.substring(len/2 + 1);
		}
		else {
			front = str.substring(0, len/2);
			back = str.substring(len/2);
		}
		
		//비교
		
		StringBuilder temp = new StringBuilder(back);
		back = temp.reverse().toString();
		if(front.equals(back)) {
			return 1;
		}
		else {
			return 2;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		String front;
		String back;
		
		
		int[] answer = new int[N];
		scn.nextLine();
		for(int i = 0; i < N; i++) {
			String str = scn.nextLine();
			
			answer[i] = search(str);
			
			
			
		}
		
		for(int i : answer) {
			System.out.println(i);
		}
	}

}
