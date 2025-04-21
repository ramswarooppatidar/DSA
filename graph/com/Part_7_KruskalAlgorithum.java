package graph.com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import javax.management.relation.InvalidRoleInfoException;

public class Part_7_KruskalAlgorithum {
	
	public List<GraphEdge> kruskalAlgo(Part_5_weightedDirection graph){
		List<GraphEdge>[] vertices = graph.getVetices();
		
		PriorityQueue<GraphEdge> priorityQueue =
				new PriorityQueue<GraphEdge>(Comparator.comparingInt(GraphEdge :: getWeight));
		
		//add all edge to the queue
		for(List<GraphEdge> edges  : vertices) {
			priorityQueue.addAll(edges);
		}
		
		//create list to store mstEdge
		List<GraphEdge> mstEdges = new ArrayList<GraphEdge>();
		
		//create set to store vertices that all already in mst
		Set<Integer> inMst = new HashSet<Integer>();
		
		//keep polling edges until queue is empty
		while(!priorityQueue.isEmpty()) {
			GraphEdge currentEdge = priorityQueue.poll();
			int source = currentEdge.getSource();
			int destination = currentEdge.getDestination();
			
			 
			//skips if the edge forms a cycle
			if(inMst.contains(source) && inMst.contains(destination)) {
				continue;
			}
			//else add the curent forms a cycle
			mstEdges.add(currentEdge);
			inMst.add(source);
			inMst.add(destination);
			
		}
		return mstEdges;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
