package graph.com;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

class GraphEdge{
	
	private final int source;
	private final int destination;
	private final int weight;
	
	public GraphEdge(int source, int destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	public int getSource() {
		return source;
	}
	public int getDestination() {
		return destination;
	}
	public int getWeight() {
		return weight;
	}
}
public class Part_5_weightedDirection {
	private int vetices;
	private List<GraphEdge>[] adjacentLists;
	
	public Part_5_weightedDirection(int vertices) {
		this.vetices = vertices;
		adjacentLists = new ArrayList[vertices];
		
		for(int i=0; i<vetices; i++) {
			adjacentLists[i] = new ArrayList<>();
		}
		
	}
	public void addDirectedEdge(int source, int destination, int weight) {
		GraphEdge edge = new GraphEdge(source, destination, weight);
		adjacentLists[source].add(edge);
	}
	public void addUndirecedEdge(int source, int destination, int weight) {
		GraphEdge sourceToDestinationEdge = new GraphEdge(source, destination, weight);
		GraphEdge destinationToSourceEdge = new GraphEdge(destination,source, weight);
		
		adjacentLists[source].add(sourceToDestinationEdge);
		adjacentLists[destination].add(destinationToSourceEdge);
	}
	public List<GraphEdge>[] getVetices(){
		return adjacentLists;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Part_5_weightedDirection gDirection = new Part_5_weightedDirection(6);
		gDirection.addDirectedEdge(1, 2, 40);
		gDirection.addDirectedEdge(1, 5, 60);
		gDirection.addDirectedEdge(2, 5, 10);
		gDirection.addUndirecedEdge(4, 2, 100);
     	gDirection.addUndirecedEdge(5, 3, 200);
		List<GraphEdge>[] outputLists = gDirection.getVetices();
		System.out.println(outputLists);
		for(int i =0; i<outputLists.length; i++) {
			System.out.println("edge from vertex :"+i+ " : ");
			for(GraphEdge edge : outputLists[i]) {
				 System.out.println("  To: " + edge.getDestination() + ", Weight: " + edge.getWeight());

			}
		}

	}

}
