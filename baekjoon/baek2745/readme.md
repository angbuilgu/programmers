# 진법 변환

URL: https://www.acmicpc.net/problem/2745

# 문제

B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.

10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.

A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35

## 입력

첫째 줄에 N과 B가 주어진다. (2 ≤ B ≤ 36)

B진법 수 N을 10진법으로 바꾸면, 항상 10억보다 작거나 같다.

## 출력

첫째 줄에 B진법 수 N을 10진법으로 출력한다.

## 문제 접근 방법

1. N의 각 자릿수를 int로 만든다
2. N(0)*B^(length-1) + N(1)*B^(length-2) ... + N(length) 형태로 만든다

### 코드 
```java 
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] str = scn.nextLine().split(" "); // 한줄 받아서 B,N으로 나눈다
		String B = str[0];
		int answer = 0;
		int N = Integer.parseInt(str[1]);
		
		// 한 문자씩 N진법으로 계산해서 answer에 더한다
		
		for(int i = 0; i < B.length(); i++) {
			int ch = B.charAt(i); // (아스키)숫자는 49~57 알파벳A~Z는 65~90
			if(ch < 65) ch -= 48; // 숫자는 -48
			else ch -= 55; // 문자는 -55
			answer += ch * Math.pow(N, (B.length()-i-1)); // i번째숫자^(길이-1-i)
		}
		
		System.out.println(answer);
		

	}

}
```
### 개선사항
```java 
Integer.parseUnsignedInt(scn.next(),scn.nextInt())
```
이거 하나면 알아서 해준다