/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Rafael da Silva Nogueira
 */
public class GrafosEstudo {

    
    public static void main(String[] args) {
       
        
        Grafo g = new Grafo();

        Node n1 =  new Node(1,5,true,"MAN",0);
        Node n2 =  new Node(1,3,true,"SPO",1);
        Node n3 =  new Node(1,2,true,"SPO",2);
       
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);

        g.makeConnection(n1, n2);
        g.makeConnection(n2, n1);
        g.makeConnection(n1, n3);
        
        g.printAllNodesLinks();

    }
    
}
