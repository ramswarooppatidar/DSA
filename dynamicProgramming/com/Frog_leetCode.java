package dynamicProgramming.com;
import java.util.*;
public class Frog_leetCode {
	/*403
	 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

 

Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
	 * */
	public static boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i =0; i<stones.length; i++){
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(stones[0]).add(1);
        for(int i = 0 ; i<stones.length; i++){
            int current = stones[i];
            HashSet<Integer> jumps = map.get(current);
            for(int jump : jumps){
                int pos = current + jump;
                if(pos == stones[stones.length - 1]){
                    return true;
                }
                if(map.containsKey(pos)){
                     if(jump - 1>0){
                    map.get(pos).add(jump - 1);
                    }
                    map.get(pos).add(jump);
                    map.get(pos).add(jump + 1);
                    }
               
            }
        }
        return false;
    }
	
	public static boolean canCross_dp(int[] stones) {
        // Edge case: if the first jump is more than 1 unit, return false.
        if (stones[1] != 1) return false;

        // Map to store stone position and possible jump sizes to reach that position
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();

        // Initialize DP map
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        // Start with the first stone, where the initial jump size is 0
        dp.get(stones[0]).add(0);

        // Iterate through all stones
        for (int stone : stones) {
            HashSet<Integer> jumps = dp.get(stone);
            for (int jump : jumps) {
                // Possible jump sizes from the current stone
                for (int step = jump - 1; step <= jump + 1; step++) {
                    if (step > 0 && dp.containsKey(stone + step)) {
                        dp.get(stone + step).add(step);
                    }
                }
            }
        }

        // Check if the last stone can be reached
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[] = {0,1,3,5,6,8,12,17};
		int stones2[] = {0,1,2,3,4,8,9,11};
//		boolean res = canCross(stones2);
//		canCross(stones);
		boolean res = canCross_dp(stones);
		System.out.println("canCross :"+res);

	}

}
