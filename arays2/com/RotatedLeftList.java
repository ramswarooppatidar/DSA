package arays2.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class RotatedLeftList {
	public static List<Integer> rotatedLeft(List<Integer> arr, int d){
		int n = arr.size()-1;
		while(d>0) {
			Integer num= arr.get(0);
			arr.remove(0);
			arr.add(num);
			d--;
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> resultIntegers = rotatedLeft(list, 2);
		System.out.println(resultIntegers);
		

	}

}
