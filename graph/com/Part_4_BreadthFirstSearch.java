package graph.com;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Part_4_BreadthFirstSearch {

	private Map<Integer, List<Integer>> adjecantListMap;
	public Part_4_BreadthFirstSearch() {
		adjecantListMap = new HashMap<Integer, List<Integer>>();
	}
	public void addVertex(int v) {
		adjecantListMap.put(v, new LinkedList<>());
	}
	public void addEdge(int source, int destination) {
		adjecantListMap.get(source).add(destination);
		adjecantListMap.get(destination).add(source);
	}
	public void breadthFirstSearchIterative(int startVertex) {
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startVertex);
		visited.add(startVertex);
		while(!queue.isEmpty()) {
			int currentVertex = queue.poll();
			System.out.print(currentVertex + " ");
			for(int negbour : adjecantListMap.getOrDefault(currentVertex, Collections.emptyList())) {
				if(!visited.contains(negbour)) {
					queue.add(negbour);
					visited.add(negbour);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part_4_BreadthFirstSearch g = new Part_4_BreadthFirstSearch();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(3, 2);
		g.addEdge(3, 5);
		
		g.breadthFirstSearchIterative(1);

	}

}
