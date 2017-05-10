/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rafael
 */
public final class jpMapa extends JPanel implements Runnable {

    private BufferedImage mapa = null;
    //private Plane deathstar = null;
    private Plane deathstar = null;
    private Thread thread = null;

    private ArrayList<Plane.Pontos> pontos;

    private boolean threadRunning;
    private final String objTexture = "./src/res/deathstar.png";
    private final String mapTexture = "./src/res/mapa.png";

    private boolean havePath;

    public jpMapa() {
        deathstar = new Plane(40, 40, objTexture);

        loadMap();
        repaint();

    }

    public void loadMap() {
        try {
            mapa = ImageIO.read(new File(mapTexture));
        } catch (IOException ex) {
            Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mapa == null) {
            JOptionPane.showMessageDialog(null, "Imagem não carregada!");
        }
    }

    public void makePath(ArrayList<Plane.Pontos> p) {

        havePath = true;
        this.pontos = p;
        this.threadRunning = true;
        thread = new Thread(this);
        thread.start();
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

        if (deathstar.isloaded()) {

            plane.drawImage(deathstar.getTextura(), deathstar.getPosX(), deathstar.getPosY(), deathstar.getWidth(),
                    deathstar.getHeight(), this);

            if (deathstar.isMoving()) {
                //Se estiver se movendo  desenhar uma linha para o destino
                Graphics2D g2d = (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(Color.MAGENTA);
                g2d.draw(new Line2D.Float(deathstar.getPosX() + deathstar.getWidth() / 2,
                        deathstar.getPosY() + deathstar.getHeight() / 2, deathstar.getDstX(), deathstar.getDstY()));

            }
        }

    }

    @Override
    public void run() {
        //thread de rendereização

        while (!thread.isInterrupted()) {
            for(int i=0; i<pontos.size() ; i++)
            {
                deathstar.setPosition(pontos.get(i).ordinal());
                deathstar.setDestination(pontos.get(i+1).ordinal());
                boolean destination = false;

                while (!destination) {
                    try {

                        thread.sleep(30);
                        deathstar.setIsMoving(true);

                        deathstar.Update();
                        repaint();
                        if (!deathstar.isMoving()) {
                            destination = true;
                            
                            thread.sleep(500);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(jpMapa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

            System.out.println("Thread encerrada!");
            thread.interrupt();
        }
    }
}
