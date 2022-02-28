package baek2579;

import java.util.Scanner;

public class Main_실패 {

	
	public static int count(int[] scores, boolean flag, int[] temp, int N) {
		int answer = 0;
		for(int i = 4; i < N; i++) {
			if(flag) { // 2단계 전 -> 1(or 2)단계 전 -> 2단계 전 ...
				if(i % 2 == 0) { // 2단계 전에서 추가
					int imsi = temp[1]; // 임시로 저장
					if(temp[0] > imsi) {
						imsi = temp[0]; // 더 전값이 더 크면 그걸 저장
					}
					temp[1] = temp[0] + scores[i]; // 이번 최대값
					temp[0] = imsi; // 2단계 전 값에 1단계 전 값 입력
					answer = temp[1];
				}else { // 1(or 2)단계 전에서 추가
					if(temp[1] > temp[0]) { // 1단계 전의 최대값이 더 크면	
						if(temp[1] > temp[0]) temp[0] = temp[1]; // 2단계 전 값에 1단계 전 또는 2단계 전 값중 더 큰값 입력
						temp[1] += scores[i]; // 이번 최대값
					}else { // 2단계 전의 최대값이 더 크면	
						flag = !flag; // flag 반대로
						int imsi = temp[1]; // 임시로 저장
						if(temp[0] > imsi) imsi = temp[0]; // 더 전값이 더 크면 그걸 저장
						temp[1] = temp[0] + scores[i]; // 이번 최대값
						temp[0] = imsi; // 2단계 전 값에 1단계 전 값 입력
					}
					answer = temp[1];
				}
			}else { // 1(or 2)단계 전 -> 2단계 전 -> 1(or 2)단계 전 ...
				if(i % 2 == 0) { // 1(or 2)단계 전에서 추가
					if(temp[1] > temp[0]) { // 1단계 전의 최대값이 더 크면				
						if(temp[1] > temp[0]) temp[0] = temp[1]; // 2단계 전 값에 1단계 전 또는 2단계 전 값중 더 큰값 입력
						temp[1] += scores[i]; // 이번 최대값
					}else { // 2단계 전의 최대값이 더 크면	
						flag = !flag; // flag 반대로
						int imsi = temp[1]; // 임시로 저장
						if(temp[0] > imsi) imsi = temp[0]; // 더 전값이 더 크면 그걸 저장
						temp[1] = temp[0] + scores[i]; // 이번 최대값
						temp[0] = imsi; // 2단계 전 값에 1단계 전 값 입력
					}
					answer = temp[1];
				}else { // 2단계 전에서 추가
					int imsi = temp[1]; // 임시로 저장
					if(temp[0] > imsi) imsi = temp[0]; // 더 전값이 더 크면 그걸 저장
					temp[1] = temp[0] + scores[i]; // 이번 최대값
					temp[0] = imsi; // 2단계 전 값에 1단계 전 값 입력
					answer = temp[1];
				}
			}
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] scores = new int[N];
		for(int i = 0; i < N; i++) {
			scores[i] = scn.nextInt();
		}
		/*
		 * 계단 수당 최대 score는 계단 수가 더 적은 경우부터 생각해 볼 수 있다
		 * 1. 이전 최대값이 가장 높은 계단 2개를 밟지 않는경우
		 * 		이전 값에서 이번에 추가되는 계단 score를 추가하면 된다
		 * 2. 이전 최대값이 가장 높은 계단 2개를 밟는경우
		 * 		2단계 이전 값에서 이번에 추가되는 계단 score를 추가하면 된다
		 * 잘 보면 1이 되면 다음은 2가 되고 2가되면 다음은 1이된다
		 * *즉 계단이 3개일 때 최대값이 어떻게 만들어지는지 확인하고 1,2 번갈아서 대입하면 되겠다
		 * *이야 -> 안됨
		 * 문제: 계단 3개일 때는 완벽하지 않다(반례: 50 40 30 20 10)
		 * 해결: 모든 경우를 볼 수 있는 4개까지 보고 대입
		 * 이야 -> 안됨
		 * 문제: 1단계 전이랑 비교할 수 있으면 2단계 전과 비교할 수 있다
		 * 해결: 비교한다
		 * 이야 -> 안됨
		 * 문제: 2단계 전과 비교할 수 있으면 그 전과도 비교할 수 있다
		 * 해결: 1단계 전 값과 2단계 전 값을 비교해서 더 큰 값을 2단계 전 값으로 지정한다
		 * 이야 -> 안됨
		 * 문제: 1단계 전과 비교하다 2단계 전이 더 커서 바꾸면 flag도 바뀌어야 한다
		 * 해결: flag 바꾼다
		 * 이야
		 */
		
		boolean flag = false; // 계단이 3개일 때 마지막 두 계단을 연달아서 밟는지
		/////// 계단 수가 0~3인 경우
		if(N == 0) {
			System.out.println(0);
			System.exit(0);
		}
		else if(N == 1) {
			System.out.println(scores[0]);
			System.exit(0);
		}
		else if(N == 2) {
			System.out.println(scores[0] + scores[1]);
			System.exit(0);
		}
		else if(N == 3) {
			if (scores[0] > scores[1]) { // 마지막 두 계단을 연달아 밟지 않았다
				System.out.println(scores[0] + scores[2]);
			}else { // 마지막 두 계단을 연달아 밟았다
				System.out.println(scores[1] + scores[2]);
			}
			System.exit(0);
		}
		////////
		int answer = 0;
		int[] temp = {0,0}; // 이전 또는 2단계 전 최대값을 저장
		temp[0] = scores[0] + scores[2]; // 계단 3개 첫 scores[0] > scores[1]인 경우
		if(scores[1] > scores[0]) { // 계단 3개 첫 scores[0] < scores[1]인 경우
			temp[0] = scores[1] + scores[2];
		}
		// 계단 4개일 때
		// 가능한 경우: 0+1+3 , 0+2+3
		temp[1] = scores[0] + scores[1] + scores[3];
		if(scores[0] + scores[2] + scores[3] > scores[0] + scores[1] + scores[3]) {
			temp[1] = scores[0] + scores[2] + scores[3];
			flag = true;
		}
		answer = temp[1]; // 계단 길이가 4인 경우 답
		
		if(scores[1] == scores[2]) { // 두번째 계단과 세번째 계단이 같은 경우는 귀찮으므로 두 경우 다 해보고 비교
			int answer1 = count(scores, true, temp, N);
			int answer2 = count(scores, false, temp, N);
			if(answer1 > answer2) {
				answer = answer1;
			}else {
				answer = answer2;
			}
		}else {
			answer = count(scores, flag, temp, N);
		}
		System.out.println(answer);
		

	}

}
