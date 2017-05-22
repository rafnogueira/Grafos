
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rafael Nogueira 2017
 */
public class Node {
    int index;
    int valor;
    int peso;
    boolean ativo;
    String label;
    List<Node> adj;

    public Node(int valor, int peso, boolean ativo, String label, int index) {
        this.valor = valor;
        this.peso = peso;
        this.ativo = ativo;
        this.index = index;
        this.label = label;

        adj = new ArrayList<Node>();
    }
    
    public void addConnectionAdj(Node n2)
    {        
        this.adj.add(n2);        
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Node> getAdj() {
        return adj;
    }

    public void setAdj(List<Node> adj) {
        this.adj = adj;
    }

}
