package graph.com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Part_6_PrismAlgorithum {
	private List<GraphEdge>[] adjacentLists;
	public List<GraphEdge> prismMST(Part_5_weightedDirection graph){
		List<GraphEdge>[] vertices = graph.getVetices();
		
		for(int i =0; i<vertices.length; i++) {
			List<GraphEdge> graphEdges = vertices[i];
			for(GraphEdge gEdge : graphEdges) {
				System.out.println("source : "+gEdge.getSource()+" destination : "+gEdge.getDestination()+" weight : "+gEdge.getWeight());
			}
			System.out.println();
		}
		boolean[] inMST = new boolean[vertices.length];
		
		/*
		 You are creating a new empty priority queue.
         It is meant to hold objects of type GraphEdge.
         The queue will automatically sort its elements based on the result of GraphEdge.getWeight().
         That is, edges with smaller weight will come out first when you poll() the queue.
		 */
		PriorityQueue<GraphEdge> priorityQueue =
				new PriorityQueue<GraphEdge>(Comparator.comparing(GraphEdge::getWeight));
		
		while (!priorityQueue.isEmpty()) {
		    GraphEdge edge = priorityQueue.poll(); // removes and returns the smallest
		    System.out.println("Weight: " + edge.getWeight());
		}

		
		List<GraphEdge> mstEdges = new ArrayList<>();
		
		//strat from vertex zero
//		int stratVertex = 0;
		int stratVertex = 1;
		inMST[stratVertex] = true;
		
		//add all edges from vertex to priority queue
		priorityQueue.addAll(vertices[stratVertex]);
		
		while(!priorityQueue.isEmpty()) {
			GraphEdge graphEdge = priorityQueue.poll();
			System.out.println(" while source : "+graphEdge.getSource()+" destination : "+graphEdge.getDestination()+" weight : "+graphEdge.getWeight());
			int destination = graphEdge.getDestination();
			
			//eskip if destination already inMst
			if(inMST[destination]) continue;
			
			//else add current edge to mst
			mstEdges.add(graphEdge);
			inMST[destination] = true;
			
			//add all edges from the desitination tothe priority queue
			List<GraphEdge> graphEdge2 = vertices[destination];
			for(GraphEdge ge : graphEdge2) {
				System.out.println(" while vertices[destination] destination : "+ge.getDestination());
	
			}
			System.out.println();
			priorityQueue.addAll(vertices[destination]);
			
		}
		return mstEdges;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Part_5_weightedDirection wightedGraph = new Part_5_weightedDirection(5);
//		wightedGraph.addDirectedEdge(0, 1, 6);
//		wightedGraph.addDirectedEdge(0, 2, 4);
//		wightedGraph.addDirectedEdge(2, 1, 1);
//		wightedGraph.addDirectedEdge(2, 4, 7);
//		wightedGraph.addDirectedEdge(1, 3, 8);
//		wightedGraph.addDirectedEdge(4, 3, 2);
		
		//second graph
		Part_5_weightedDirection wightedGraph = new Part_5_weightedDirection(8);
		wightedGraph.addUndirecedEdge(1, 2, 2);
		wightedGraph.addUndirecedEdge(1, 5, 3);
		wightedGraph.addUndirecedEdge(1, 3, 5);
		wightedGraph.addUndirecedEdge(2, 5, 1);
		wightedGraph.addUndirecedEdge(2, 3, 4);
		wightedGraph.addUndirecedEdge(5, 6, 9);
		
		wightedGraph.addUndirecedEdge(5, 7, 1);
		wightedGraph.addUndirecedEdge(3, 4, 8);
		wightedGraph.addUndirecedEdge(3, 7, 7);
		wightedGraph.addUndirecedEdge(4, 7, 2);
		
		Part_6_PrismAlgorithum psmAlgorithum = new Part_6_PrismAlgorithum();
		List<GraphEdge> resultEdges = psmAlgorithum.prismMST(wightedGraph);
		for(GraphEdge graphEdge : resultEdges) {
			System.out.println("source--> "+graphEdge.getSource() +" weight---> "+graphEdge.getWeight()+" destination--->"+graphEdge.getDestination());
		}
		


	}

}
