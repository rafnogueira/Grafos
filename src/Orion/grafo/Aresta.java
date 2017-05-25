/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.grafo;


/**
 *
 * @author rafael
 */
public class Aresta
{

    int pesoMetricaA;
    int pesoMetricaB;
    int pesoMetricaC;
    
    int peso;
    No destino;
    No origem;
    public Aresta(No src ,No dst, int a,int b,int c)
    {
        this.origem = src;
        this.destino = dst;
        this.pesoMetricaA = a;
        this.pesoMetricaB = b;
        this.pesoMetricaC = c;        
        
        this.peso = b;
        
    }
    public Aresta(No src ,No dst, int peso)
    {
        this.origem = src;
        this.destino = dst;
        this.peso = peso;
    }    

}
