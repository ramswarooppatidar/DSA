package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PreviousSmaller {
	public static int[] previousSmaller(int arr[]) {
		int result[] = new int[arr.length];
		Stack<Integer> stack=new Stack<>();
		
		for(int i =0; i<arr.length; i++) {
			
			while( !stack.isEmpty() && stack.peek()>=arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				result[i] = -1;
			}else {
				result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return result;
	}
	
	public static int[] previousSmaller2(int arr1[], int arr2[]) {
		
		Stack<Integer> stack=new Stack<>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i =0; i<arr2.length; i++) {
			
			while( !stack.isEmpty() && stack.peek()>=arr2[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				map.put(arr2[i], -1);
			}else {
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
		int []arr = {1,4,8,0,1,7};
		int result[] = previousSmaller(arr);
		for(int i : result) {
			System.err.print(i+" ");
		}
		
		System.out.println();
		int [] nums = {0,7,4,1};
		int result1[] = previousSmaller2(nums, arr);
		for(int i : result1) {
			System.err.print(i+" ");
		}
	}

}
