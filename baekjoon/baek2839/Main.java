package baek2839;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		
		if(num % 5 == 0) {
			System.out.println(num / 5);
		}
		else {
			int five = num / 5;
			int answer = -1;
			for(int i = five; i >= 0; i--) {
				int three = 0;
				
				while(true) {
					if(5*i + 3*three == num) {
						answer = i+three;
						break;
					}
					else {
						three++;
					}
					if(5*i + 3*three > num) {
						break;
					}
				}
				
				if(answer != -1) {
					break;
				}
			}
			System.out.println(answer);
		}

	}

}
