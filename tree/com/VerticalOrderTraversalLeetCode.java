package tree.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalLeetCode {
	public static List<List<Integer>> verticalOrderTraversalLeet(BinaryTreeNode<Integer> root){
		Queue<Triplate<BinaryTreeNode<Integer>, Integer, Integer>> queue = new LinkedList<>();
		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		List<List<Integer>> ansList = new ArrayList<>();
		queue.add(new Triplate(root, 0, 0));
		while(!queue.isEmpty()) {
			Triplate<BinaryTreeNode<Integer>, Integer, Integer> front = queue.poll();
			BinaryTreeNode<Integer> current = front.first;
			int x = front.second;
			int y = front.third;
			
			if(!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
			}
			if(!map.get(x).containsKey(y)) {
//				map.put(y, new TreeMap<>());
				map.get(x).put(y, new PriorityQueue<>());
			}
			map.get(x).get(y).add(current.data);
			
			if(current.left != null) {
				queue.add(new Triplate(current.left, x - 1, y + 1));
			}
			if(current.right != null) {
				queue.add(new Triplate(current.right, x + 1, y + 1));
			}
		}
		for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()) {
			TreeMap<Integer, PriorityQueue<Integer>> treeMap = entry.getValue();
			List<Integer> list = new ArrayList<>();
			for(Map.Entry<Integer, PriorityQueue<Integer>> entry2 : treeMap.entrySet()) {
				PriorityQueue<Integer> pq = entry2.getValue();
				while(!pq.isEmpty()) {
					list.add(pq.poll());
				}
			}
			ansList.add(list);
		}
		return ansList;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
