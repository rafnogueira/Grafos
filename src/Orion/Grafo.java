

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael Nogueira 2017
 */
public class Grafo {
    //Variáveis Staticas globais
    private List<Node> nodes;
    private int nodesSize;
    
    //Se for necessário matriz de incidência
    private int[][] nodeMatrix;
    
    public Grafo() {
        System.out.println("Criando Grafo");
        nodes = new ArrayList<Node>();
    }
    
    public void addNode(int valor, int peso, boolean ativo,String label,int index)
    {
        Node newVertex =  new Node(valor,peso,ativo,label,index);
        this.nodes.add(newVertex);
        this.nodesSize = nodes.size();
    }
    public void addNode(Node n)
    {
        this.nodes.add(n);
        this.nodesSize = nodes.size();
    }
    public void makeConnection(Node n1 , Node n2)
    {
        if(nodes.contains(n1) && nodes.contains(n2))
        {
            n1.addConnectionAdj(n2);
        }
    }

    public void printAllNodesLinks()
    {
        for(int i = 0 ; i < nodes.size() ; i++)
        {
            printLinks(nodes.get(i));
        }
    }
    public void printLinks(Node n)
    {
        System.out.print("AdjList |HEAD| "+n.label +" "+n.index);
        for(int i = 0; i < n.getAdj().size(); i++)
        {
            Node tmp = n.getAdj().get(i);
            System.out.print(" -> "+tmp.label +" "+tmp.index);
        }
        System.out.println("");
    }

}
