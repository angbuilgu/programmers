package baek1339;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_이건_좀_아닌듯함 {

	private static final String Charactor = null;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		// HashMap의 key는 길이, value는 문자열 어레이로 저장한다
		HashMap<Integer,ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		
		// A~Z
		HashMap<String,Integer> alpha = new HashMap<String, Integer>();
		
		// 남은 숫자
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(0);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		nums.add(8);
		nums.add(9); // pop처럼 사용할거임 ㅎ

		scn.nextLine();
		for(int i = 0; i < N; i++) {
			String str = scn.nextLine();
			if(map.get(str.length()) == null) { // 처음이면 ArrayList 선언
				map.put(str.length(), new ArrayList<String>());
			}
			map.get(str.length()).add(str);
		}
		// map에 있는 key들은 오름차순으로 나온다
		Object[] keys = map.keySet().toArray();
		
		// 긴 숫자들의 앞 자리수들은 무조건 커야한다
		for(int i = keys.length-1; i >= 0; i--) {
			int index = (int) keys[i]; // Object기 때문에 casting
			int next = 0;
			if(i != 0) { // 현재길이-다음길이, 가장 짧은 문자면 끝까지
				next = (int) keys[i-1];
			}
			
			ArrayList<String> list = map.get(index);
			if(list.size() == 1) { // 하나만 있으면 현재길이-다음길이 까지 오는 문자들은 큰 수부터 들어가면 된다
				String s = list.get(0);
				for(int j = 0; j < index-next; j++) {
					if(alpha.get(s.substring(j, j+1)) != null) continue; // 이미 숫자가 있으면 넘어간다
					alpha.put(s.substring(j, j+1), nums.get(nums.size()-1));
					nums.remove(nums.size()-1); // 대충 pop
				}
			}else { // 같은 길이가 여러개면 계산 좀 해야한다
				// 근데 길이, 개수 등이 별로 없으니까 완전탐색 하는게 편하겠다
				HashSet<String> Alphas = new HashSet<String>();
				
				for(String j : list) {
					String[] strtemp = j.substring(0,index-next).split(""); // 검사할 문자열을 분해
					for(String k : strtemp) {
						Alphas.add(k); // Set이므로 겹치는 알파벳은 안들어간다
					}
				}
				// 이제 Set에는 이번 검사에 사용 할 알파벳들이 들어있다
				String[] result = new String[Alphas.size()]; // 크기순으로 결과를 저장할 리스트
				
				// 여기까지 했다
				// 이제 모든 경우의 수를 만들어서 모두 대입 하면 될거같다
			}
			
		}
	}


}
