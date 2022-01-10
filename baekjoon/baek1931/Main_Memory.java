package baek1931;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main_Memory {
	


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int start;
		int end;
		int max = 0;
		int[] maxkey = new int[2];
		int[] tempMaxKey = new int[2];
		HashMap<int[], ArrayList<int[]>> meetings = new HashMap<int[], ArrayList<int[]>>();
		
		
		for(int i = 0; i < N; i++) {
			start = scn.nextInt();
			end = scn.nextInt();
			if(meetings.get(new int[] {start,end}) != null) {
				continue;
			}
			meetings.put(new int[] {start,end}, new ArrayList<int[]>());
		}
		Set<int[]> keyset = meetings.keySet();
		
		for(int[] i : keyset) {
			int temp = 0;
			for(int[] j : keyset) {
				if(i == j) {
					continue;
				}
				if((i[0] <= j[0] && j[0] < i[1]) || (j[0] <= i[0] && i[0] < j[1])) {
					meetings.get(i).add(j);
					temp++;
				}
				
				if (temp > max) {
					max = temp;
					maxkey = i;
				}
			}
		}
		
		while(true) {
			if (max == 0) {
				break;
			}
			meetings.remove(maxkey);
			keyset = meetings.keySet();
			max = 0;
			
			for(int[] i : keyset) {
				meetings.get(i).remove(maxkey);
				if(meetings.get(i).size() > max) {
					max = meetings.get(i).size();
					tempMaxKey = i;
				}
			}
			maxkey = tempMaxKey;
		}
		System.out.println(meetings.size());
		/*for(int[] i : meetings.keySet()) {
			System.out.print(Arrays.toString(i)+": ");
			for(int[] j : meetings.get(i)) {
				System.out.print(Arrays.toString(j));
			}
			System.out.println();
			
		}*/
		
		
		
	}
}
