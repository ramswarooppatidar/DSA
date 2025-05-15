package com.stack;

import java.awt.geom.AffineTransform;
import java.util.Stack;

public class EvaluteExpression {
	static int i =0;
	static Stack<Integer> stack = new Stack<Integer>();
	public static int evaluteExpression(String s) {		
		char sign = '+';
		int num =0;
		int n = s.length();
//		for(int i =0; i<n; i++) {
		while(i <n) {
			char ch = s.charAt(i);

			if(Character.isDigit(ch)) {
				num = num*10 + (ch-'0');
			}
			
			if(ch == '(') {
				i++;
				num = evaluteExpression(s);
			}
			
//			if(!Character.isDigit(ch) && ch != ' ' || i != n - 1)
				 if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1){
				
				if(sign == '+') {
					stack.push(num);
				}else if(sign == '-') {
					stack.push(-num);
				}else if(sign == '*') {
					stack.push(stack.pop()*num);
				}else if(sign == '/') {
					stack.push(stack.pop()/num);
				}
				
				if(ch == ')') {
					break;
				}
				
				sign = ch;
				num = 0;
			}
			i++;
		}
		int result =0;
		System.out.println(stack);
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		System.out.println(result);
		return result;
		
	}
	
	static int j =0;
	public static int evalueExpression2(String s) {
		int result =0;
		int lastNum = 0;
		int num =0;
		int sign ='+';
		int n = s.length();
		
		while(j < n) {
			char ch = s.charAt(j);
			if(Character.isDigit(ch)) {
				num = num*10 + (ch -'0');
			}
			
			if(ch == '(') {
				j++;
				num = evalueExpression2(s);
			}
			if((!Character.isDigit(ch) && ch !=' ') || j == n - 1) {
				if(sign == '+') {
					result += lastNum;
					lastNum = num;
				}else if(sign == '-') {
					result += lastNum;
					lastNum = -num;
				}else if(sign == '*') {
					lastNum = lastNum*num;
				}else if(sign == '/') {
					lastNum = lastNum/num;
				}
				
				if(ch ==')') {
					break;
				}
				sign = ch;
				num = 0;
			}
			j++;
		}

		int ans = result + lastNum;
		System.out.println("evaluate 2 :"+ans);
		return ans;
	}
	
	static int k =0;
	private static int helper(String s) {
        int num = 0;
        char sign = '+'; 
        int result = 0;
        int lastNum = 0;

        while (k < s.length()) {
            char c = s.charAt(k);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                k++;
                num = helper(s); // solve inner bracket first
            }

            if ((!Character.isDigit(c) && c != ' ') || k == s.length() - 1) {
                if (sign == '+') {
                    result += lastNum;
                    lastNum = num;
                } else if (sign == '-') {
                    result += lastNum;
                    lastNum = -num;
                } else if (sign == '*') {
                    lastNum = lastNum * num;
                } else if (sign == '/') {
                    lastNum = lastNum / num;
                }

                if (c == ')') {
//                    i++;
                    break; // end current bracket
                }

                sign = c;
                num = 0;
            }
            k++;
        }
        int ans = result + lastNum;
        System.out.println(ans);
        return result + lastNum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String expression = "1*2 + 3*2 + 1";
		String expression = "1*2+(1-2+(2+3)+1) + 3*2 + 1";
		evaluteExpression(expression);
		evalueExpression2(expression);
		helper(expression);

	}

}
