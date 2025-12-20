package array3.com;

public class LeamondeChange {
	public static boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for(int i =0; i<bills.length; i++){
            if(i == 0 && bills[i] != 5){
                return false;
            }

            if(bills[i] == 5){
                fiveCount++;
                System.out.println("fiveCount :"+fiveCount+" , tenCount :"+tenCount);
            }else if(bills[i] == 10){
                if(fiveCount < 1){
                	System.out.println("else if condition 1");
                    return false;
                }
                fiveCount--;
                tenCount++;
                System.out.println("  fiveCount :"+fiveCount+" , tenCount :"+tenCount);
            }else{
            	if(tenCount >= 1 && fiveCount >= 1){
                    tenCount--;
                    fiveCount--;
                }else if(fiveCount >= 3){
                    fiveCount = fiveCount - 3;
                }else{
                    return false;
                }
            }
        }
        return fiveCount > 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		System.out.println(lemonadeChange(new int[] {5,5,5,10,5,5,10,20,20,20}));
		System.out.println(lemonadeChange(new int[] {5,5,5,5,20,20,5,5,20,5}));
		System.out.println(lemonadeChange(new int[] {5,5,5,5,10,5,10,10,10,20}));
		System.out.println(lemonadeChange(new int[] {5,5,5,10,5,5,10,20,20,20}));

	}

}
