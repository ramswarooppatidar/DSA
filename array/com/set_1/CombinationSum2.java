package array.com.set_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,0, combination, ans, target);
        return ans;
    }
    static Set<List<Integer>> set = new HashSet<>();
    private static void helper(int arr[], int i, List<Integer> comb, List<List<Integer>> ans, int target){
        if(target == 0){
            if(!set.contains(comb)){
                ans.add(new ArrayList<>(comb));
                set.add(comb);
            }
            return;
        }
        if(i == arr.length || target<0){
            return;
        }

         //single inculde
         comb.add(arr[i]);
         helper(arr, i+1, comb, ans, target - arr[i]);

        //backtrack
        comb.remove(comb.size() - 1);
         

         //exculde dublicate
         int index = i+1;
         while(index < arr.length && arr[index] == arr[index - 1])
         index++;
        
         helper(arr, index, comb, ans, target);

    }
    public static void main(String args[]) {
    	int arr[]= {2,5,2,1,2};
    	int arr2[]= {10,1,2,7,6,1,5};
    	List<List<Integer>> resultList =	combinationSum2(arr, 5);
    	System.out.println(resultList);
    	
    	List<List<Integer>> resultList2 =	combinationSum2(arr2, 8);
    	System.out.println(resultList2);
    }
}