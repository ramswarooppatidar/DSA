package graph.com;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Part_3_DepthFirstSearch {
	private Map<Integer, List<Integer>> adacencyListMap;
	public Part_3_DepthFirstSearch() {
		adacencyListMap = new HashMap<Integer, List<Integer>>();
		
	}
	public void addVertex(int v) {
		adacencyListMap.put(v, new LinkedList<>());
	}
	public void addEdge(int source, int destination) {
		adacencyListMap.get(source).add(destination);
		adacencyListMap.get(destination).add(source);
	}
	public void DFS(int startVertex){
		Set<Integer> visisted = new HashSet<Integer>();
		DFS_Recurssive(startVertex, visisted);
		
	}
	public void DFS_Recurssive(int vertex, Set<Integer> visited) {
		visited.add(vertex);
		System.out.println(vertex + " ");
		
		for(int negbour : adacencyListMap.getOrDefault(vertex, Collections.emptyList())) {
			if(!visited.contains(negbour)) {
				DFS_Recurssive(negbour, visited);
			}
		}
	}
	public void DFSIterative(int startVertex) {
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(startVertex);
		while(!stack.isEmpty()) {
			int currentVertex = stack.pop();
			System.out.println("current Vertex : "+currentVertex);
			visited.add(currentVertex);
			/*
			 *  adacencyListMap.getOrDefault(currentVertex, Collections.emptyList())
               This gets the list of neighbors for the current vertex:

                If the key currentVertex exists, it returns its corresponding List<Integer>.
			 */
			for(int neigbour :
				adacencyListMap.getOrDefault(currentVertex, Collections.emptyList())
				) {
				if(!visited.contains(neigbour)) {
					stack.push(neigbour);
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part_3_DepthFirstSearch G = new Part_3_DepthFirstSearch();
		G.addVertex(1);
		G.addVertex(2);
		G.addVertex(3);
		G.addVertex(4);
		
		G.addEdge(1, 3);
		G.addEdge(1, 4);
		G.addEdge(2, 3);
		G.addEdge(4, 3);
		
		G.DFSIterative(1);
		G.DFS(1);

	}

}
