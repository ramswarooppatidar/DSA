package arays2.com;

public class CanPlacedFlower {
//	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int m = flowerbed.length;
////        {1,0,0,0,1,0,0}
//        for(int i =0;i<m ;i++){
//        	if(i==0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
//        		flowerbed[i] = 1;
//       		    n--;
//        	}
//        	else if(i == m-1 && flowerbed[i-1] == 0 && flowerbed[i] == 0) {
//        		 flowerbed[i] = 1;
//        		 n--;
//        	}
//        	else if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] != 1){
//                flowerbed[i] = 1;
//                n--;
//            }
//        }
//        return n == 0;
//    }
	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
//        {1,0,0,0,1,0,0}
        for(int i =0;i<m ;i++){
        	System.out.println("first");
        	if(i == 0) {
        		if(flowerbed[i] == 0 && flowerbed[i+1] == 0 ) {
        			flowerbed[i] = 1;
            		System.out.println("first");
                    n--;
        		}
        		
        	}else if(i == m-1 ) {
        		if(flowerbed[i-1] == 0 &&  flowerbed[i] == 0 ) {
        			flowerbed[i] = 1;
            		System.out.println("second");
                    n--;
        		}
        		
        	}
        	else if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] != 1){
                flowerbed[i] = 1;
                System.out.println("third");
                n--;
            }
        }
        return n == 0;
    }
	 public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
	        int m = flowerbed.length;
	        for(int i =0;i<m;i++){
	            if(i == 0){
	                if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
	                    flowerbed[i] = 1;
	                    n--;
	                }
	            }else if( i == m-1){
	                if(flowerbed[i] == 0 && flowerbed[i-1] == 0){
	                    flowerbed[i] = 1;
	                    n--;
	                }
	            }else if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] != 1){
	                  flowerbed[i] = 1;
	                  n--;
	            }  
	        }
	        return n == 0;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 boolean flag =	canPlaceFlowers(new int[] {1,0,0,0,1,0,0}, 2);
	 System.out.println("isPlaced "+flag);
	 
	 boolean flag2 =	canPlaceFlowers2(new int[] {1,0,0,0,1,0,0}, 2);
	 System.out.println("isPlaced "+flag2);

	}

}
