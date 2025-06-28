package arays2.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Pair<T, U>{
	T frequency;
	U length;
	Pair(T fre, U len){
		this.frequency = fre;
		this.length = len;
	}
}
public class MaxFrequestShortestLengthSubArray {

	public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
               if(map.containsKey(nums[i])){
                  map.get(nums[i]).add(i);
               }else{
                  ArrayList<Integer> list = new ArrayList<>();
                  list.add(i);
                  map.put(nums[i], list);
               }
        }
        
       System.out.println("map :"+ map);
        int fre = 1;
         HashMap<Integer, Integer> freLenMap = new HashMap<>();

        for(int i : map.keySet()){
           List<Integer> list = map.get(i);
           int minLength= Integer.MAX_VALUE;
//           System.out.println(list);
           if(fre <= list.size()){
                if(Math.abs(list.get(list.size() - 1) - list.get(0)) < minLength){
                minLength = Math.abs(list.get(list.size() - 1) - list.get(0));
                fre = list.size();
                System.out.println("elements "+ i+" freq :"+list.size()+" minLength :"+minLength);
                freLenMap.put(list.size(), minLength);
            }
           }  
        }
        int maxFre = 0;
        for(int i : freLenMap.keySet()){
            if(maxFre<= i){
            		 maxFre = i; 
            }
        }
        
        int finalLength = Integer.MAX_VALUE;
        System.out.println("freLenMap"+freLenMap);
        for(int i : freLenMap.keySet()){
            if(maxFre == i){
                if(freLenMap.get(i)<finalLength) {
                	finalLength = freLenMap.get(i);
                	System.out.println("if finallength :"+finalLength);
                }
                maxFre = i;
            }else if(maxFre<i){
            	finalLength = freLenMap.get(i);
            	System.out.println("else finallength :"+finalLength);
            	maxFre = i;
            }
            System.out.println("free");
        }
        return finalLength+1;
        
//       return freLenMap.get(maxFre) + 1;
     
    }
	public static int findShortestSubArray2(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
               if(map.containsKey(nums[i])){
                  map.get(nums[i]).add(i);
               }else{
                  ArrayList<Integer> list = new ArrayList<>();
                  list.add(i);
                  map.put(nums[i], list);
               }
        }
        
       System.out.println("map :"+ map);
        int fre = 1;
         HashMap<Integer, Pair<Integer, Integer>> ElefreLenMap = new HashMap<>();

        for(int i : map.keySet()){
           List<Integer> list = map.get(i);
           int minLength= Integer.MAX_VALUE;
//           System.out.println(list);
           if(fre <= list.size()){
                if(Math.abs(list.get(list.size() - 1) - list.get(0)) < minLength){
                minLength = Math.abs(list.get(list.size() - 1) - list.get(0));
                fre = list.size();
                System.out.println("elements "+ i+" freq :"+list.size()+" minLength :"+minLength);
                
                
                ElefreLenMap.put(i, new Pair(list.size(), minLength));
            }
           }  
        }
        System.out.println("ElefreLenMap :"+ElefreLenMap);
        int maxFre = -1;
        int len = Integer.MAX_VALUE;
        for(int i : ElefreLenMap.keySet()){
        	Pair<Integer, Integer> pair = ElefreLenMap.get(i);
            if(maxFre == pair.frequency){
            	  System.out.println("");
            		 if(pair.length<len) {
            			 len = pair.length;
            		 }
            }else if(maxFre<pair.frequency) {
            	maxFre = pair.frequency;
            	  len = pair.length;
            }
        }
        return len+1;
        
//        int finalLength = Integer.MAX_VALUE;
//        System.out.println("freLenMap"+freLenMap);
//        for(int i : freLenMap.keySet()){
//            if(maxFre == i){
//                if(freLenMap.get(i)<finalLength) {
//                	finalLength = freLenMap.get(i);
//                	System.out.println("if finallength :"+finalLength);
//                }
//                maxFre = i;
//            }else if(maxFre<i){
//            	finalLength = freLenMap.get(i);
//            	System.out.println("else finallength :"+finalLength);
//            	maxFre = i;
//            }
//            System.out.println("free");
//        }
//        return finalLength+1;
        
//       return freLenMap.get(maxFre) + 1;
     
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {47,47,72,47,72,47,79,47,12,92,13,47,47,83,33,15,18,47,47,
				47,47,64,47,65,47,47,47,47,70,47,47,55,47,15,60,47,47,47,47,47,46,
				30,58,59,47,47,47,47,47,90,64,37,20,47,100,84,47,47,47,47,47,89,47,
				36,47,60,47,18,47,34,47,47,47,47,47,22,47,54,30,11,47,47,86,47,55,40,
				49,34,19,67,16,47,36,47,41,19,80,47,47,27};
		   int length = findShortestSubArray2(nums);
		   System.out.println("length is :"+length);
		   
		int nums2[] = {1,3,2,2,3,1};
		 int length1 = findShortestSubArray2(nums2);
		   System.out.println("length is :"+length1);
		
		}
	

				
}


