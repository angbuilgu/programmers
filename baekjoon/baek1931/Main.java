package baek1931;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int start;
		int end;
		int max = 0;
		int answer = 0;
		ArrayList<int[]> meetings = new ArrayList<int[]>();
		
		
		for(int i = 0; i < N; i++) {
			start = scn.nextInt();
			end = scn.nextInt();
			meetings.add(new int[] {start,end});
		}
		
		Collections.sort(meetings,new Comparator<int[]>() {

		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	if (o1[0] > o2[0]) { // 낮은순
		            return 1;
		        }
		    	else if (o1[0] == o2[0]) {
		    		return 0;
		    	}
		    	else {
		            return -1;

		        }
		    }}
		);
		
		Collections.sort(meetings,new Comparator<int[]>() {

		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	if (o1[1] > o2[1]) { // 낮은순
		            return 1;
		        }
		    	else if (o1[1] == o2[1]) {
		    		return 0;
		    	}
		    	else {

		            return -1;

		        }
		    }}
		);
		
		for(int[] i : meetings) {
			if(i[0] >= max) {
				max = i[1];
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
		
		
	}
}
