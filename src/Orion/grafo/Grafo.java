package Orion.grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Nogueira 2017
 */
public final class Grafo {

    private List<No> nos;
    private int size;

    public Grafo() {

        System.out.println("Iniciando Grafo");
        //Inicia Lista de nós como vazios
       

        //imprimirNos(encontrarCaminho(this, nA, nD));
    }
    
    public void imprimirNos(List<No> nos)
    {
        for(No n : nos)
        {
            JOptionPane.showMessageDialog(null, "Nó" + n.getDistancia());
        }
    }

    public void addNo(No n) {
        
        if (nos.contains(n)) {
            JOptionPane.showMessageDialog(null, "Nó adicionado já existe");
        } else {
            this.nos.add(n);
            this.size = nos.size();
        }
        
    }
    
    public void updateNoList(List<No> nos)
    {
        this.nos = nos;
    }

    public List<No> encontrarCaminho(Grafo g ,No n1 , No n2)
    {
        List<No> menorCaminho  = new ArrayList<No>();
        List<No> naoVisitados = new ArrayList<No>();

        No verticeCaminho  = new No();
        No verticeAtual  = new No();
        No vizinho  = new No();

        menorCaminho.add(n1);

        for(int i = 0; i < g.nos.size(); i++)
        {
            if(g.nos.get(i).getNome().equals(n1.getNome()))
            {
                g.nos.get(i).setDistancia(0);
            }else{
                g.nos.get(i).setDistancia(Integer.MAX_VALUE);
            }
            naoVisitados.add(g.nos.get(i));
        }
        
        Collections.sort(naoVisitados);
        
        while(!naoVisitados.isEmpty())
        {
            verticeAtual = naoVisitados.get(0);
            //Adquirindo vértice
                        
            for(int i = 0; i < verticeAtual.getListAdj().size(); i++)
            {//Verifica vizinhos
                vizinho = verticeAtual.getListAdj().get(i).destino;
                 
                if(!vizinho.isVisitado())
                {

                    if(vizinho.getDistancia() > ( verticeAtual.getDistancia()+ verticeAtual.getListAdj().get(i).peso ))
                    {
                        vizinho.setDistancia(verticeAtual.getDistancia() + verticeAtual.getListAdj().get(i).peso);
                        vizinho.setAnterior(verticeAtual);

                        if(vizinho == n2)
                        {
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);

                            while(verticeCaminho.getAnterior() != null)
                            {
                                menorCaminho.add(verticeCaminho.getAnterior());
                                verticeCaminho = verticeCaminho.getAnterior();
                            }
                            Collections.sort(menorCaminho);
                        }

                    }

                }
            }
            
            
            verticeAtual.visitado = true;
            naoVisitados.remove(verticeAtual);
            Collections.sort(naoVisitados);
            
        }
        
        return menorCaminho;
        
    }
    

}
