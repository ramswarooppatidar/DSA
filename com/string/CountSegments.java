package com.string;

public class CountSegments {

	public static int countSegment(String s) {
		String str[] = s.trim().split("\\s+");
		for(String st: str) {
			System.out.print(st+" ");
		}
		int count=0;
		for(String seg:str) {
			if(!seg.isEmpty()) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSegment(" , ,    , ram,        a, vabba"));
		System.out.println(countSegment(", , , ,        a, eaefa"));
	}

}
