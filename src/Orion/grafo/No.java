package Orion.grafo;


import java.util.LinkedList;

/**
 * 
 *
 * @author Rafael Nogueira 2017
 */
public class No implements Comparable<No>{
    
    
    boolean ativo = true;
    boolean visitado = false;
    private int index;
    private int distancia = Integer.MAX_VALUE;
    private String nome;    
    private No anterior;
    private LinkedList<Aresta> listAdj;

    
    public No(String nome , int index)
    {

        this.ativo = true;
        this.nome = nome ;
        this.index = index;
        //Inicia lista de adj vazia
        listAdj = new LinkedList<>();
        
    }
    
    public No()
    {
        
    }
    
    public void addAresta(No n , int peso)
    {
        this.listAdj.add(new Aresta(this,n,peso));
    }
    
    public void addAresta(No n,int a,int b,int c)
    {
        //Adiciona Aresta ligando o nós
        this.listAdj.add(new Aresta(this,n, a,b,c));
        
    }

    public String isAtivo()
    {
        return ativo ?  "Ativo" : "Desativado";
    }
    
    public boolean checkAtivo(){
        return this.ativo;
    }
    
    public void desabilitar()
    {
        this.ativo = false;
    }

    public void visitar()
    {
        this.visitado = true;
    }
    public boolean isVisitado()
    {
        return this.visitado;
    }
    
    @Override
    public int compareTo(No no) 
    {
        if(!this.ativo)
        {
            this.distancia =  Integer.MAX_VALUE;
        }

        if(this.distancia < no.distancia){
            return -1;
        }else if (this.distancia  == no.distancia){
            return 0;
        }

        return 1;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public LinkedList<Aresta> getListAdj() {
        return listAdj;
    }

    public void setListAdj(LinkedList<Aresta> listAdj) {
        this.listAdj = listAdj;
    }
    
    
    

}
