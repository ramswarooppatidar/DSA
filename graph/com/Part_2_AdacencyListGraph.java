package graph.com;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Part_2_AdacencyListGraph {
	private Map<Integer, List<Integer>> adjacancyListMap;
	Part_2_AdacencyListGraph(){
		this.adjacancyListMap = new HashMap<>();
	}
	public void addVertx(int v) {
		adjacancyListMap.put(v, new LinkedList<>());
	}
	public void addEdge(int source, int destination) {
		adjacancyListMap.get(source).add(destination);
		adjacancyListMap.get(destination).add(source);
	}
	public void removeEdge(int source, int destination) {
		adjacancyListMap.get(source).remove(destination);
		adjacancyListMap.get(destination).remove(source);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part_2_AdacencyListGraph G = new Part_2_AdacencyListGraph();
		G.addVertx(1);
		G.addVertx(2);
		G.addVertx(3);
		G.addVertx(4);
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		G.addEdge(4, 3);

	}

}
