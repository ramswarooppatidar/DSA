package array3.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPairZeroSum {

	public static  int[] twoPairZeroSum(int arr[]) {
		int index[] = new int[2];
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0; i<arr.length; i++) {
			int complements = -arr[i];
			List<Integer> l = new ArrayList<Integer>();
			if(map.containsKey(complements)) {
				index[0] = map.get(complements);
				index[1] = i;
				l.add(map.get(complements));
				l.add(i);
				list.add(l);
			}else {
				map.put(arr[i], i);
			}
		}
		System.out.println(list);
		return index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-1,0,2,1,4, -2,-4};
		int res[] = twoPairZeroSum(arr);
		for(int num : res) {
			System.out.print(num+" ");
		}

	}

}
