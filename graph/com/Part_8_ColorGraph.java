package graph.com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Part_8_ColorGraph {
	public Map<Integer, Integer> colorGraph(Part_5_weightedDirection graph){
		List<GraphEdge>[] vertices = graph.getVetices();
		Map<Integer, Integer> colorMap = new HashMap<Integer, Integer>();
		
		//ITRATE over eaach vertex
		for(int vertex = 0; vertex < vertices.length; vertex++) {
			Set<Integer> neighborColor = new HashSet<Integer>();
			
			for(GraphEdge edge : vertices[vertex]) {
				if(colorMap.containsKey(edge.getDestination())) {
					neighborColor.add(colorMap.get(edge.getDestination()));
				}
			}
			
			int color = 1;
			while(neighborColor.contains(color)) {
				color++;
			}
			colorMap.put(vertex, color);
		}
		return colorMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
