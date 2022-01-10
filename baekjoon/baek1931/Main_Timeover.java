package baek1931;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_Timeover {
	
	public static void calculate(ArrayList<int[]> meetings) {
		
		int size = meetings.size();
		for(int i = 0; i < size; i++) {
			int[] least = meetings.get(i);
			for(int j = 0; j < size; j++) {
				if(i == j) {
					continue;
				}
				int t = 0;
				int[] temp = meetings.get(j);
				if((least[0] <= temp[0] && temp[0] < least[1])
						|| (temp[0] <= least[0] && least[0] < temp[1])) {
					t++;
				}
				least[2] = t;
			}
		}
		
		Collections.sort(meetings,new Comparator<int[]>() {

		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	if (o1[2] < o2[2]) {
		            return 1;
		        } else {

		            return -1;

		        }
		    }}
		);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int start;
		int end;
		ArrayList<int[]> meetings = new ArrayList<int[]>(); 
		
		
		for(int i = 0; i < N; i++) {
			start = scn.nextInt();
			end = scn.nextInt();
			meetings.add(new int[] {start,end, 0});
		}
		
		calculate(meetings);
		
		
		while(true) {
			if(meetings.get(0)[2] == 0) {
				break;
			}
			meetings.remove(0);

			calculate(meetings);

		}

		System.out.println(meetings.size());
		

	}

}
