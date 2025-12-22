package array4.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddNumberToArray {
	
	// public List<Integer> addToArrayForm(int[] num, int k) {
    //     List<Integer> list = new ArrayList<>();
    //     int carry = 0;
    //     for(int i = num.length - 1; i>= 0 ; i--){
    //         if(k > 0){
    //             int sum = num[i] + carry + k % 10;
    //             k /= 10;
    //             list.add(sum % 10);
    //             carry = sum/10;
    //         }else{
    //             int sum2 = num[i] + carry;
    //             list.add(sum2 % 10);
    //             carry = sum2/10;
    //         }
    //     }
    //     while(k>0){
    //         list.add(k % 10);
    //         k /= 10;
    //     }
    //     if (carry > 0) {
    //         list.add(carry);   
    //     }
        
    //     Collections.reverse(list);
    //     return list;
    // }

    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length - 1;
        int carray = 0;
        List<Integer> result = new ArrayList<>();
        while(n >= 0 || k > 0 || carray > 0 ){
            int digit1 = n >= 0 ? num[n] : 0;
            int digit2 = k% 10 ;
            k /= 10;
            int sum = digit1 + digit2 + carray;
            result.add(sum%10);
            carray = sum/10;
            n--;
        }
        System.out.println(result);
        Collections.reverse(result);
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
