package com.string3;

public class BinaryGap {
     public static int binayGap(String binary) {
    	 int maxDistance = -1;
    	 int fix = 0,run =0;
    	 for(int i =0; i<binary.length(); i++){
    		 char ch = binary.charAt(i);
    		 if(ch == '1') {
    			 int dist = (run - fix);
    			 maxDistance = Math.max(maxDistance, dist);
    			 fix = run;
    		 }
    		 run++;
    	 }
    	 System.out.println("max distance :"+maxDistance);
    	 return maxDistance;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub  101  1000   10110
		binayGap("101101010001");   //4
		binayGap("101");   //2
		binayGap("1000");   //0
		binayGap("10110");  //2
	}

}
