# 팩토리얼

URL: https://www.acmicpc.net/problem/10872

# 문제

0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

## 입력

첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

## 출력

첫째 줄에 N!을 출력한다.

## 문제 접근 방법

1. 팩토리얼을 재귀함수로 구현한다

### 코드 
```java
import java.util.Scanner;

public class Main {
	
	public static long fact(int N) {
		if(N == 1 || N == 0) {
			return 1;
		}
		return N*fact(N-1); // N * (N-1)!
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		System.out.println(fact(N));
	}

}
```