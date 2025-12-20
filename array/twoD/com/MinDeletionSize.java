package array.twoD.com;

public class MinDeletionSize {
	 public static int minDeletionSize(String[] strs) {
	        int n = strs.length;
	        int count = 0;
	        for(int i =0; i<strs[0].length(); i++){
	            for(int j =0; j<n-1 ; j++){
	                if(strs[j].charAt(i) > strs[j+1].charAt(i)){
	                    count++;
	                    break;
	                }
	            }
	        }
	        return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = minDeletionSize(new String[] {"cba", "daf", "ghi"});
		System.out.println(res);
		
		int res1 = minDeletionSize(new String[] {"zyx", "wvu", "tsr"});
		System.out.println(res1);

	}

}
