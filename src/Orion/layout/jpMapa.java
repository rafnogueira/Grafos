/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rafael Nogueira
 */
public final class jpMapa extends JPanel implements Runnable {

    private BufferedImage mapa = null;
    //private Plane deathstar = null;
    private Plane plane = null;
    private Thread thread = null;
    private ArrayList<Plane.Pontos> pontos = null;
    private List<Integer> inPontos = null;
    private boolean threadRunning = false;
    private final String objTexture = "resources/plane.png";
    private final String mapTexture = "resources/mapa.png";
    private String szCaminho = null;
    private boolean havePath;
    
    private JLabel lblCaminho = null;
    
    public jpMapa() {
        
        pontos = new ArrayList<>();
        inPontos = new ArrayList<>();
        plane = new Plane(40, 40, objTexture);
        szCaminho = "";
        
        lblCaminho = new JLabel("");       
        setLayout(null);
        lblCaminho.setLocation(0, 50);
        lblCaminho.setSize(300, 800);
        this.add(lblCaminho);
        
        
        loadMap();
        repaint();

    }

    public void loadMap() {
        try {
            mapa = ImageIO.read(getClass().getResource(mapTexture));
        } catch (IOException ex) {
            Logger.getLogger(GrafosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mapa == null) {
            JOptionPane.showMessageDialog(null, "Imagem não carregada!");
        }
    }

    public void makePath(ArrayList<Plane.Pontos> p) {

        if(havePath == true && threadRunning == true)
        {
            //JOptionPane.showMessageDialog(null, "Espero até a animação atual terminar!");
        }else{
            
        havePath = true;
        this.pontos = p;
        this.threadRunning = true;
        thread = new Thread(this);
        thread.start();
        }
    }
    
     public ArrayList<Plane.Pontos> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<Plane.Pontos> pontos) {
        this.pontos = pontos;
    }

    public boolean isHavePath() {
        return havePath;
    }

    public void setHavePath(boolean havePath) {
        this.havePath = havePath;
    }

    public boolean isThreadRunning() {
        return threadRunning;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D plane = (Graphics2D) g;

        plane.setColor(Color.RED);
        plane.drawImage(mapa, 0, 0, 700, 600, null);

        if (this.plane.isloaded()) {

            plane.drawImage(this.plane.getTextura(), this.plane.getPosX(), this.plane.getPosY(), this.plane.getWidth(),
                    this.plane.getHeight(), this);

            if (this.plane.isMoving()) {
                //Se estiver se movendo  desenhar uma linha para o destino
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(Color.MAGENTA);
                g2d.draw(new Line2D.Float(this.plane.getPosX() + this.plane.getWidth() / 2,
                        this.plane.getPosY() + this.plane.getHeight() / 2, this.plane.getDstX(), this.plane.getDstY()));
            }
        }

    }
    
    

    @Override
    public void run() {
        //thread de rendereização

        while (true) {
            lblCaminho.setText(szCaminho);
            try {
                for (int i = 0; i < pontos.size(); i++) {
                    plane.setPosition(pontos.get(i).ordinal());
                    plane.setDestination(pontos.get(i + 1).ordinal());
                    boolean destination = false;

                    while (!destination) {
                        try {

                            thread.sleep(20);
                            plane.setIsMoving(true);
                            plane.Update();
                            repaint();
                            
                            if (!plane.isMoving()) {
                                destination = true;
                                thread.sleep(500);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(jpMapa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            } catch (IndexOutOfBoundsException index) {
                //System.out.println("Erro de index do vetor minimizado" + index.getMessage());
            }
            System.out.println("Thread encerrada!");
            this.havePath = false;
            threadRunning = false;
            thread.interrupt();
            break;
        }
    }

    public String getSzCaminho() {
        return szCaminho;
    }

    public void setSzCaminho(String szCaminho) {
        this.szCaminho = szCaminho;
    }

}
