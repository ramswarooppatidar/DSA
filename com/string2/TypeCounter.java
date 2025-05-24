package com.string2;

public class TypeCounter {
	 public static void typeCounter(String sentence) {
	        String sentence1 = sentence.trim();
	        String str[] = sentence1.split("\\s+");
	        int values =0;
	        int doubless = 0;
	        int stringg = 0;
	        for(int i =0; i<str.length; i++){
	            try{
	                Integer.parseInt(str[i]);
	                values++;
	            }catch(Exception e){
	                try{
	                 Double.parseDouble(str[i]);
	                doubless++;  
	                }catch(Exception ex){
	                	
	                	boolean flag = true;
	                	for(char ch : str[i].toCharArray()) {
	                		if(!Character.isLetter(ch)) {
	                			flag = false;
	                		}
	                	}
	                	if(str[i].equals(str[i].toLowerCase())) {
	                		if(flag) {
	                			stringg++;
	                		}
	                	}
		                    
	                }    
	            }    
	        }
	        System.out.println("string "+stringg);
	         System.out.println("integer "+values);
	          System.out.println("double "+doubless);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		typeCounter(" sdds 23 dffs 1 fg 3 hqQdj   2.3 fgs*//  2.3 gRh th 10 ");

	}

}
