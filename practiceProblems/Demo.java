package practiceProblems;

import java.util.HashMap;
import java.util.Map;

public class Demo {
	 public static void manipulateString(String str){
	        Map<String, Integer> map = new HashMap<>();
	        String s[] = str.split(" ");
	        for(int i =0; i<s.length; i++){
	            map.put(s[i], s[i].length());
	        }
	        for(Map.Entry<String, Integer> entry : map.entrySet()){
	            System.out.print(entry.getKey()+"="+entry.getValue()+" ");
	        }
	    }
	   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		manipulateString("Hi welocme to programming");

	}

}
