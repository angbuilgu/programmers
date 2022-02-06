# 단어 수학

URL: https://www.acmicpc.net/problem/1339

# 문제

민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.

단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.

예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.

N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.

## 입력

첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.

## 출력

첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.

## 문제 접근 방법

1. 각 문자가 나온 횟수를 자리수를 고려하여 HashMap에 넣는다
2. HashMap의 값에 나온 횟수가 큰 순서대로 높은 숫자를 곱한다
3. 모든 값을 더한다

### 코드 
```java
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
```
### 배운거
Collection을 ArrayList로 만들 수 있다
'''java
ArrayList<Integer> list = new ArrayList<Integer>(map.values());
'''
자주 사용할 것 같다