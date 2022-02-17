package baek15829;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int L = scn.nextInt();
		scn.nextLine();
		String str = scn.nextLine();
		int r = 31;
		int M = 1234567891;
		BigInteger hash = new BigInteger("0");
		for(int i = 0; i < L; i++) {
			int ch = str.charAt(i) - 96; // ASCII 변환
			BigInteger rs = new BigInteger("1");
			
			for(int j = 0; j < i; j++) {
				rs = rs.multiply(new BigInteger("31"));
			}
			hash = hash.add((new BigInteger(Integer.toString(ch))).multiply(rs).remainder(new BigInteger("1234567891"))).remainder(new BigInteger("1234567891"));
		}
		System.out.println(hash);

	}

}