package tree.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
public static List<List<Integer>> verticalOrderTraversal(BinaryTreeNode<Integer> root){
		
		List<List<Integer>> ans = new ArrayList<>();
		Queue<Pairs<BinaryTreeNode<Integer>, Integer>> queue = new LinkedList<>();
		queue.add(new Pairs(root, 0));
		Map<Integer, List<Integer>> map = new TreeMap<>();
		
		while(!queue.isEmpty()) {
			Pairs<BinaryTreeNode<Integer>, Integer> front = queue.poll();
			BinaryTreeNode<Integer> current = front.first;
			Integer horizonatDistance = front.second;
			
			if(!map.containsKey(horizonatDistance)) {
				map.put(horizonatDistance, new ArrayList<Integer>());
				map.get(horizonatDistance).add(current.data);	
			}else {
				map.get(horizonatDistance).add(current.data);
			}
//			map.put(horizonatDistance, map.getOrDefault(horizonatDistance, new ArrayList<Integer>()) , current.data);
			if(current.left != null) {
				queue.add(new Pairs(current.left, horizonatDistance - 1));
			}
			if(current.right != null) {
				queue.add(new Pairs(current.right, horizonatDistance + 1));
			}
		}
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> sortLi = entry.getValue();
			Collections.sort(sortLi);
			ans.add(sortLi);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
