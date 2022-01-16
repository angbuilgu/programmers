package baek1541;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static int minus(ArrayList<Integer> nums, ArrayList<Character> giho) {
		int ret = 0;
		while(nums.size() > 0) {
			giho.remove(0);
			ret -= nums.get(nums.size()-1);
			nums.remove(nums.size()-1);
			if(giho.size() == 0 || giho.get(0) == '-') {
				break;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String str = scn.nextLine();
		
		String[] strs = str.split("\\+|-"); //+ .는 특정 의미를 가지기 때문에 \\처리
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		ArrayList<Character> giho = new ArrayList<Character>();
		
		int answer = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '+' || str.charAt(i) == '-') {
				giho.add(str.charAt(i));
			}
		}
		for(int i = strs.length-1; i >= 0; i--) {
			nums.add(Integer.parseInt(strs[i]));
		}
		
		
		//System.out.println(nums.get(nums.size()-1));
		answer += nums.get(nums.size()-1);
		nums.remove(nums.size()-1);
		for(int i = 0; i < nums.size(); i++) {
			int temp;
			if(giho.get(0) == '+') {
				temp = nums.get(nums.size()-1);
				nums.remove(nums.size()-1);
				giho.remove(0);
				i--;
			}
			else {
				temp = minus(nums, giho);
				i--;
			}
			answer += temp;
		}
		System.out.println(answer);

	}

}
