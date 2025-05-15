package com.stack;

import java.util.Stack;

//leetcode 84
public class LargerRectangleArea {
	public int largestRectangleArea(int[] heights) {
        int rightSmaller[] = new int[heights.length];
        int leftSmaller[] = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = heights.length - 1; i>=0; i--){
             while(!stack.isEmpty() &&  heights[stack.peek()] >= heights[i]){
                stack.pop();
             }
             rightSmaller[i] = stack.isEmpty() ? -1 :  stack.peek();
             stack.push(i);
        }
         while(!stack.isEmpty()){
            stack.pop();
         }
         for(int i = 0; i<heights.length; i++){
             while(!stack.isEmpty() &&  heights[stack.peek()] >= heights[i]){
                stack.pop();
             }
             leftSmaller[i] = stack.isEmpty() ? -1 :  stack.peek();
             stack.push(i);
        }

        int maxArea = 0;
        for(int i =0; i<heights.length; i++){
            int right = rightSmaller[i] == -1 ? heights.length : rightSmaller[i];
            int width = right - leftSmaller[i] - 1;
            //index value we are not include in width bcz this is smaller strip so formula is valid

            //  int right = rightSmaller[i] == -1 ? heights.length : rightSmaller[i];
            //  int left = leftSmaller[i] == -1 ? 0 : leftSmaller[i];
            //  int width = right - left -1;

            int area= heights[i]*width;
           maxArea = Math.max(maxArea, area);

        }
        return maxArea;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
