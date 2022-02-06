package baek1339;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	private static final String Charactor = null;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		// HashMap의 key는 알파벳, value는 나온횟수*10^자리수
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();

		scn.nextLine();
		for(int i = 0; i < N; i++) {
			String str = scn.nextLine();
			int strlen = str.length();
			for(int j = 0; j < strlen; j++) { // 한 문자씩 map에 넣는다
				if(map.get(str.charAt(j)) == null) { // 처음이면 생성
					map.put(str.charAt(j), (int) Math.pow(10,strlen -1 -j)); // KA 면 {K:10,A:1}로 만드는게 목표
				}
				else {
					map.replace(str.charAt(j), map.get(str.charAt(j)) + (int) Math.pow(10,strlen -1 -j)); // 있으면 더해준다
				}
			}
		}
		// map에 있는 value들을 정렬해서 큰 수부터 곱하고 더하면 되겠다
		ArrayList<Integer> list = new ArrayList<Integer>(map.values()); // Collection을 ArrayList로 만들 수 있다 
		Collections.sort(list); // 정렬
		Collections.reverse(list); // 내림차순

		int answer = 0; // 여기에 답을 저장
		
		for(int i = 0; i < list.size(); i++) {
			answer += list.get(i) * (9-i);
		}
		System.out.println(answer);

	}


}
