package baek10829;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static String str = ""; // 출력 저장
	public static void binary(BigInteger N) { // 재귀함수 사용
		////////////////// 끝나는 경우
		if (N.toString().equals("2")) { // 2인경우 앞이 10이므로 추가하고 끝낸다
			str = "10"+str;
			return;
		}
		else if (N.toString().equals("1")) { // 1인경우 앞이 1이므로 추가하고 끝낸다
			str = "1"+str;
			return;
		}
		//////////////////
		if((N.mod(new BigInteger("2")).toString()).equals("0")) { // 2로 나눠지는 경우 앞에 0을 추가한다
			str = "0"+str;
			binary(N.divide(new BigInteger("2")));
		}
		else { // 2로 나눠지지 않는경우 앞에 1을 추가한다
			str = "1"+str;
			binary((N.subtract(new BigInteger("1"))).divide(new BigInteger("2")));
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BigInteger N = new BigInteger(scn.next()); // 입력 조건을 맞추기 위해
		binary(N);
		if(str.substring(0, 1).equals("0")) { // 0으로 시작하면 앞글자 제거
			str = str.substring(1);
		}
		System.out.println(str);
	}

}
