# 잃어버린 괄호

URL: https://www.acmicpc.net/problem/1541

# 문제

세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

# 입력

첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

# 출력

첫째 줄에 정답을 출력한다.

# 문제 접근 방법

1. '-' 뒤가 최대면 된다
2. '+' 뒤부터 끝까지 혹은 '-' 다시 나오기 전까지 숫자를 더하면 되겠다

# 코드 
```java
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
```