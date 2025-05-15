package arays2.com;

import java.util.ArrayList;
import java.util.List;

public class RangeSummary {

	 public static List<String> summaryRanges(int[] nums) {
	        List<String> list = new ArrayList<>();
	       int n = nums.length;
	       if(n== 0) {
	    	   return list;
	       }
	       boolean flag = true;
	        for(int i =1; i<nums.length; i++){
	             String temp="";
	             temp += nums[i-1];
	             int val = nums[i-1];
	             while(i<n && nums[i-1]+1== nums[i]){
	                i++;
	                if(i == n) {
	                	flag= false;
	                }
	             }
	            
	            if(val != nums[i-1]) {
	            	temp += "->";
	            	temp += nums[i-1];
	            }
	             
	            list.add(new String(temp));   
	        }
	        if(flag) {
            	String tempString = nums[n -1]+"";
            	list.add(tempString);
            }
             
	        return list;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {0,1,2,4,5,10,11,12,13,14,16,22,23,19, 24,25,26,30 ,31};
		int nums2[]= {0,2,3,4,6,8,9};
		List<String> list = summaryRanges(nums);
		List<String> list2 = summaryRanges(nums2);
		System.out.println(list);
		System.out.println(list2);
		/*
		 [0->2, 4->5, 10->14, 16, 22->23, 19, 24->26, 30->31]
         [0, 2->4, 6, 8->9]

		 */


	}

}
