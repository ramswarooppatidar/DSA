package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGraterElement {

	public static int[] nextElementForAllIndex(int []arr1, int arr2[]) {
		Stack<Integer> stack = new Stack<Integer>();
		int result[] = new int[arr2.length];
		for(int i = arr2.length - 1; i>=0; i--) {
				
				while(!stack.isEmpty() && stack.peek()<=arr2[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					result[i] = -1;
					
				}else {
					result[i] = stack.peek();
					
				}
				stack.push(arr2[i]);	
		}
		return result;
	}
	
	public static int[] nextElementL(int []arr1, int arr2[]) {
		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result[] = new int[arr2.length];

		for(int i = arr2.length - 1; i>=0; i--) {
				
				while(!stack.isEmpty() && stack.peek()<=arr2[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					result[i] = -1;
					map.put(arr2[i], -1);
					
				}else {
					result[i] = stack.peek();
					map.put(arr2[i], stack.peek());
					
				}
				stack.push(arr2[i]);	
		}
		int k=0;
		for(int i : arr1) {
			arr1[k++] = map.get(i);
		}
		return arr1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {6,8,0,1};
//	int result[]=	nextElement(arr, new int[] {6,8,0,1,3});
//	for(int i : result) {
//		System.out.print(i+" ");
//	}
		
		int result[]=	nextElementL(arr, new int[] {6,8,0,1,3});
		for(int i : result) {
			System.out.print(i+" ");
		}

	}

}
