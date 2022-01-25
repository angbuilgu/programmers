package baek1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int M = scn.nextInt();
		int starts = scn.nextInt();
		int start = starts;
		int t = 0;
		ArrayList<Integer> sq = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> map2 = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < M; i++) {
			int temp1 = scn.nextInt();
			int temp2 = scn.nextInt();
			if(map.get(temp1) == null) map.put(temp1,new ArrayList<Integer>());
			if(map.get(temp2) == null) map.put(temp2,new ArrayList<Integer>());
			if(map2.get(temp1) == null) map2.put(temp1,new ArrayList<Integer>());
			if(map2.get(temp2) == null) map2.put(temp2,new ArrayList<Integer>());
			if(map.get(temp1).contains(temp2)) continue;
			map.get(temp1).add(temp2);
			map.get(temp2).add(temp1);
			map2.get(temp1).add(temp2);
			map2.get(temp2).add(temp1);
		}
		for(ArrayList<Integer> i : map.values()) {
			Collections.sort(i);
			Collections.reverse(i);
		}
		if(map.get(start) == null) {
			System.out.println(start);
			System.out.println(start);
		}
		else {
			
			System.out.print(start);
			for(int i : map.get(start)) {
				sq.add(i);
				for(int j = 0; j < map.get(i).size(); j++) {
					if(map.get(i).get(j) == start) {
						map.get(i).remove(j);
						break;
					}
				}
			}
			
			while(true) {
				if(sq.size() == 0) {
					System.out.println();
					break;
				}
				System.out.print(" ");
				start = sq.get(sq.size()-1);
				sq.remove(sq.size()-1);
				System.out.print(start);
				for(int i : map.get(start)) {
					for(int j = 0; j < sq.size(); j++) {
						if(sq.get(j) == i) {
							sq.remove(j);
							j--;
						}
					}
					sq.add(i);
					for(int j = 0; j < map.get(i).size(); j++) {
						if(map.get(i).get(j) == start) {
							map.get(i).remove(j);
							break;
						}
					}
				}
			}
			start = starts;
			temp.add(start);
			for(ArrayList<Integer> i : map2.values()) {
				Collections.sort(i);
			}
			
			System.out.print(start);
			for(int i : map2.get(start)) {
				sq.add(i);
				for(int j = 0; j < map2.get(i).size(); j++) {
					if(map2.get(i).get(j) == start) {
						map2.get(i).remove(j);
						break;
					}
				}
			}
			
			while(true) {
				if(sq.size() == 0) {
					System.out.println();
					break;
				}
				System.out.print(" ");
				start = sq.get(0);
				temp.add(start);
				sq.remove(0);
				System.out.print(start);
				for(int i : map2.get(start)) {
					int flag = 0;
					if(sq.contains(i) || temp.contains(i)) {
						flag = 1;
					}
					if(flag == 0) {
						
						sq.add(i);
						for(int j = 0; j < map2.get(i).size(); j++) {
							if(map2.get(i).get(j) == start) {
								map2.get(i).remove(j);
								break;
							}
						}
					}
				}
			}
		}

	}

}




