package com.stack;

import java.awt.desktop.AboutHandler;
import java.util.Stack;

public class StockSpam {
	public static int[] stockSpan(int arr[]) {
		int ans[] = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		for(int i =0; i<arr.length; i++) {
			while( stack.size()>0 && arr[stack.peek()]<= arr[i]) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				ans[i] = i + 1;
			}else {
				ans[i] = i - stack.peek();
			}
			
			stack.push(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []result = stockSpan(new int[] {100, 80, 60, 70, 60, 75, 85});
		for(int i : result) {
			System.out.print(i+" ");
		}

	}

}
