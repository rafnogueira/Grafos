package Orion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex> {
	public final String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}
}

class Edge {
	public final Vertex target;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		target = argTarget;
		weight = argWeight;
	}
}

public class Dijkstra2 {
	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);
					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);
		Collections.reverse(path);
		return path;
	}

	public static void printGraph(Vertex[] vertices){
		for(Vertex v : vertices){
			for(Edge e : v.adjacencies){
				System.out.print(v.name);
				System.out.print(" -");
				System.out.print(e.weight);
				System.out.print("-> ");
				System.out.println(e.target.name);
			}
		}
	}

	public static void main(String[] args) {
		Vertex POA = new Vertex("POA");
		Vertex FLO = new Vertex("FLO");
		Vertex BLU = new Vertex("BLU");
		Vertex CUR = new Vertex("CUR");
		Vertex LON = new Vertex("LON");
                Vertex SPO = new Vertex("SPO");
		Vertex SJC = new Vertex("SJC");
		Vertex RJO = new Vertex("RJO");
		Vertex BHO = new Vertex("BHO");
		Vertex CAM = new Vertex("CAM");
                Vertex RBP = new Vertex("RBP");
		Vertex BAU = new Vertex("BAU");
		Vertex CPG = new Vertex("CPG");
		Vertex CUI = new Vertex("CUI");
		Vertex MAN = new Vertex("MAN");
                Vertex BEL = new Vertex("BEL");
		Vertex BSB = new Vertex("BSB");
		Vertex NTL = new Vertex("NTL");
		Vertex REC = new Vertex("REC");
		Vertex SLV = new Vertex("SLV");
                

		POA.adjacencies = new Edge[] {   //POA vai para...
                    new Edge(FLO, 6),            //FLO
                    new Edge(BLU, 7)             //BLU
                };
                
		FLO.adjacencies = new Edge[] {   //FLO vai para...
                    new Edge(POA, 6),            //POA
                    new Edge(BLU, 1),            //BLU
                    new Edge(CUR, 2),            //CUR
                    new Edge(RJO, 12)            //RJO
                };
                
		BLU.adjacencies = new Edge[] {   //BLU vai para...
                    new Edge(POA, 7),            //POA
                    new Edge(FLO, 1),            //FLO
                    new Edge(CUR, 2)             //CUR
                };
                
		CUR.adjacencies = new Edge[] {  //CUR vai para...
                    new Edge(FLO, 2),           //FLO            
                    new Edge(BLU, 2),           //BLU
                    new Edge(LON, 6),           //LON
                    new Edge(SPO, 5)            //SPO
                };
                
                LON.adjacencies = new Edge[]{   //LON vai para...
                    new Edge(CUR, 6),           //CUR
                    new Edge(BAU, 3),           //BAU
                    new Edge(SPO, 7)            //SPO
                };
                
                SPO.adjacencies = new Edge[]{   //SPO vai para...
                    new Edge(CUR, 5),           //CUR
                    new Edge(LON, 7),           //LON
                    new Edge(RJO, 5),           //RJO
                    new Edge(CAM, 1),           //CAM
                    new Edge(SJC, 2)            //SJC
                };
                
                SJC.adjacencies = new Edge[]{   //SJC vai para...
                    new Edge(SPO, 2),           //SPO
                    new Edge(CAM, 2),           //CAM
                    new Edge(RJO, 3),           //RJO
                    new Edge(BHO, 7)            //BHO
                    
                };
                
                RJO.adjacencies = new Edge[]{   //RJO vai para...
                    new Edge(FLO, 12),          //FLO
                    new Edge(SPO, 5),           //SPO
                    new Edge(SJC, 3),           //SJC
                    new Edge(BHO, 7),           //BHO
                    new Edge(SLV, 20)           //SLV
                };
                
                BHO.adjacencies = new Edge[]{   //BHO vai para...
                    new Edge(SJC, 7),           //SJC
                    new Edge(RJO, 7),           //RJO
                    new Edge(BSB, 9)            //BSB
                };
                
                CAM.adjacencies = new Edge[]{   //CAM vai para...
                    new Edge(SPO, 1),           //SPO
                    new Edge(SJC, 2),           //SJC
                    new Edge(BAU, 3),           //BAU
                    new Edge(RBP, 2)            //RBP
                };
                
                RBP.adjacencies = new Edge[]{   //RBP vai para...
                    new Edge(CAM, 2),           //CAM
                    new Edge(BSB, 8)            //BSB
                };
                
                BAU.adjacencies = new Edge[]{   //BAU vai para...
                    new Edge(LON, 3),           //LON
                    new Edge(CAM, 3),           //CAM
                    new Edge(CPG, 10)           //CPG
                };
                
                CPG.adjacencies = new Edge[]{
                    new Edge(BAU, 10),
                    new Edge(CUI, 8)
                };
                
                CUI.adjacencies = new Edge[]{
                    new Edge(CPG, 8),
                    new Edge(MAN, 20)
                };
                
                MAN.adjacencies = new Edge[]{
                    new Edge(CUI, 20),
                    new Edge(BSB, 22),
                    new Edge(BEL, 18)
                };
                
                BEL.adjacencies = new Edge[]{
                    new Edge(MAN, 18),
                    new Edge(NTL, 21)
                };
                
                BSB.adjacencies = new Edge[]{
                    new Edge(RBP, 8),
                    new Edge(BHO, 9),
                    new Edge(MAN, 22),
                    new Edge(NTL, 22)
                };
                
                NTL.adjacencies = new Edge[]{
                    new Edge(BEL, 21),
                    new Edge(BSB, 22),
                    new Edge(SLV, 15),
                    new Edge(REC, 4)
                };
                
                REC.adjacencies = new Edge[]{
                    new Edge(NTL, 4),
                    new Edge(SLV, 8)
                };
                
                SLV.adjacencies = new Edge[]{
                    new Edge(NTL, 15),
                    new Edge(REC, 8),
                    new Edge(RJO, 20)
                };
                
		Vertex[] vertices = {POA, FLO, BLU, CUR, LON, SPO, SJC, RJO,
                    BHO, CAM, RBP, BAU, CPG, CUI, MAN, BEL, BSB, NTL, REC, SLV};
		printGraph(vertices);
		computePaths(POA);
		for (Vertex v : vertices) 
                {
			System.out.println("\nDistancia de " + v + ": " + v.minDistance);
			List<Vertex> path = getShortestPathTo(v);
			System.out.println("Passa por: " + path);
		}
	}
}