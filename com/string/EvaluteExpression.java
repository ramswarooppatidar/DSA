package com.string;

import java.util.Stack;

public class EvaluteExpression {

	//handle only simple expression without brackets
	public static int evaluteExpression(String s) {
		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		int num =0;
		int n = s.length();
		for(int i =0; i<n; i++) {
			char c = s.charAt(i);
			 if(Character.isDigit(c)) {
				 num = num*10 + (c -'0');
			 }
			 
//			 if(!Character.isDigit(c) && c != ' ' || i == n-1) {
			 if ((!Character.isDigit(c) && c != ' ') || i == n - 1) { 
				 if(sign=='+') {
					 stack.push(num);
				 }else if(sign=='-') {
					 stack.push(-num);
				 }else if(sign=='*') {
					 stack.push(stack.pop()*num);
				 }else if(sign=='/') {
					 stack.push(stack.pop()/num);
				 }
				 
				 sign = c;
				 num =0;
			 }
			
				 
		}
		int result = 0;
		for(int i : stack) {
			result += i;
		}
		return result;
	}
	
	//take refernce from jenny lecture , and understand the concept prfix to postfix 
	    public static int evaluate2(String s) {
	        Stack<Integer> intVal = new Stack<>();
	        Stack<Character> operators = new Stack<>();
	        int num = 0;
	        int n = s.length();
	        boolean continueDigit = false;

	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);

	            if (Character.isWhitespace(c)) continue;

	            if (Character.isDigit(c)) {
	                num = num * 10 + (c - '0');
	                continueDigit = true;
	            } else {
	                if (continueDigit) {
	                	intVal.push(num);
	                    num = 0;
	                    continueDigit = false;
	                }

	                if (c == '(') {
	                    operators.push(c);
	                } 
	                else if (c == ')') {
	                    while (!operators.isEmpty() && operators.peek() != '(') {
	                        processTop(intVal, operators);
	                    }
	                    operators.pop(); // pop out the  incming bracket'('
	                } 
	                else { // this case for + - * /  check precsedence (left to right)**  
	                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
	                        processTop(intVal, operators);
	                    }
	                    operators.push(c);  //precedence less simpley add
	                }
	            }
	        }

	        if (continueDigit) {
	        	intVal.push(num);
	        }

	        while (!operators.isEmpty()) {
	            processTop(intVal, operators);
	        }

	        return intVal.pop();
	    }

	    private static void processTop(Stack<Integer> intVal, Stack<Character> operators) {
	        int b = intVal.pop();
	        int a = intVal.pop();
	        char op = operators.pop();
	        intVal.push(applyOp(a, b, op));
	    }
	    public static int precedence(char op) {
	        if (op == '+' || op == '-') return 1;
	        if (op == '*' || op == '/') return 2;
	        return 0;
	    }

	    public static int applyOp(int a, int b, char op) {
	        switch (op) {
	            case '+': return a + b;
	            case '-': return a - b;
	            case '*': return a * b;
	            case '/': return a / b;
	        }
	        return 0;
	    }
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="3*2-11*3-7+5";
		
//		String expression2 = "(1+(4+(15 -2/5)*2)*3)+(6-8)";
//		String expression2 = "(1+(4+(1*(7*2)/5)*2)*3)+(6-8)";
//		String expression2 = "(1+(1+(1+(5 +7*2/5))*2)*3)+(6-8)";
		String expression2 = "(1+(4+(1 +(5 +7*2/5)*2)*3))+(6-8)";
		
		System.out.println(evaluteExpression(expression2));
		System.out.println(evaluate2(expression2));
       
	}

}
