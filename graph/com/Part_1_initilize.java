package graph.com;

import java.util.spi.AbstractResourceBundleProvider;

public class Part_1_initilize {
	private int adjecentMatrix[][];
	private int numVertices;
	public Part_1_initilize(int numVertices) {
		this.numVertices = numVertices;
		adjecentMatrix = new int[numVertices][numVertices];
	}
	public void adddEdage(int i, int j) {
		adjecentMatrix[i][j] = 1;
		adjecentMatrix[j][i] = 1;
		
	}
	public void removeEdge(int i, int j) {
		adjecentMatrix[i][j] = 0;
		adjecentMatrix[j][i] = 0;
	}
	public void addVertex(int v) {
		int newAdjcentMatrix[][] = new int[numVertices+1][numVertices + 1];
		for(int i =0; i<numVertices; i++) {
			for(int j =0; j<numVertices; j++) {
				newAdjcentMatrix[i][j] = adjecentMatrix[i][j];	
			}
		}
		adjecentMatrix = newAdjcentMatrix;
		numVertices++;
	}
	public void removeVertex(int v) {
		int newAdjcentMatrix[][] = new int[numVertices-1][numVertices - 1];
		for(int i =0; i<numVertices; i++) {
			for(int j =0; j<numVertices; j++) {
				if(i != v && j != v) 
				newAdjcentMatrix[i][j] = adjecentMatrix[i][j];
				
			}
		}
		adjecentMatrix = newAdjcentMatrix;
		numVertices--;
	}
	public static void main(String arg[]) {
		Part_1_initilize grpah = new Part_1_initilize(4);
	}
}
