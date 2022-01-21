package baek5585;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int coin = 0;
		num = 1000 - num;
		if(num / 500 != 0) {
			coin += num / 500;
			num -= (num / 500) * 500 ;
		}
		if(num / 100 != 0) {
			coin += num / 100;
			num -= (num / 100) * 100;
		}
		if(num / 50 != 0) {
			coin += num / 50;
			num -= (num / 50) * 50;
		}
		if(num / 10 != 0) {
			coin += num / 10;
			num -= (num / 10) * 10;
		}
		if(num / 5 != 0) {
			coin += num / 5;
			num -= (num / 5) * 5;
		}
		coin += num;
		System.out.println(coin);

	}

}
