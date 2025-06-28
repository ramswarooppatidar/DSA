package tree.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

public class TopView {
	public static List<Integer> topView(BinaryTreeNode<Integer> root) {
		Queue<Pairs<BinaryTreeNode<Integer>, Integer>> queue = new LinkedList<>();
		queue.add(new Pairs<BinaryTreeNode<Integer>, Integer>(root, 0));
		SortedMap<Integer, Integer> map = new TreeMap<>();
		List<Integer> list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			Pairs<BinaryTreeNode<Integer>, Integer> pair = queue.poll();
			BinaryTreeNode<Integer> current = pair.first;
			int horDis = pair.second;
			
			if(!map.containsKey(horDis)) {
				map.put(horDis, current.data);
			}
			
			if(current.left != null) {
				queue.add(new Pairs<BinaryTreeNode<Integer>, Integer>(current.left, horDis - 1));
			}
			if(current.right != null) {
				queue.add(new Pairs<BinaryTreeNode<Integer>, Integer>(current.right, horDis + 1));
			}
		}
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
	      
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
