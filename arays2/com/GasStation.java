package arays2.com;

public class GasStation {
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
		 int totalGas = 0;
	        int totalCost = 0;
	        for(int val : gas){
	            totalGas += val;
	        }
	        for(int val : cost){
	            totalCost += val;
	        }

	        if(totalGas < totalCost){
	            return -1;
	        }

	        int start =0;
	        int currGas = 0;
	        for(int i =0; i<gas.length; i++){
	            currGas += (gas[i] - cost[i]);
	            if(currGas < 0){
	                start = i + 1;
	                currGas = 0;
	            }
	        }
	        return start;
	 }
	 public static int canCompleteCircuit2(int[] gas, int[] cost) {
			 int totalGas = 0, totalCost = 0;
	         int start =0, currGas = 0;
	        for(int i =0; i<gas.length; i++){
	        	totalGas += gas[i];
	        	totalCost += cost[i];
	            currGas += (gas[i] - cost[i]);
	            if(currGas < 0){
	                start = i + 1;
	                currGas = 0;
	            }
	        }
	        return totalGas < totalCost ? -1 : start;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int gas[]= {1,2,3,4,5};
		int cost[] = {3,4,5,1,2};
	    int index =	canCompleteCircuit(gas, cost);
	    System.out.println(index);
	    
	    int gas1[]= {2,3,4};
		int cost1[] = {3,4,3};
	    int index1 =	canCompleteCircuit(gas1, cost1);
	    System.out.println(index1);
		

	}

}
