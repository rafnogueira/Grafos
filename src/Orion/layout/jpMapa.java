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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rafael
 */
public final class jpMapa extends JPanel implements MouseListener,Runnable
{
    
    private BufferedImage mapa = null;
    //private Plane deathstar = null;
    private Plane deathstar = null;
    private Thread thread = null;
    private final boolean isMoving;
    private final String objTexture = "./src/res/deathstar.png";
    private final String mapTexture = "./src/res/mapa.png";
    

    public jpMapa() {
        deathstar = new Plane(40,40,objTexture);
        deathstar.setPosition(Plane.Pontos.CUI.ordinal());

        isMoving = false;
        loadMap();
        repaint();
        addMouseListener(this);
        thread = new Thread(this);
        thread.start();
        
        
    }
       
    public void loadMap()
    {
        
        try {
            mapa = ImageIO.read(new File(mapTexture));            
        } catch (IOException ex) {
                    Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(mapa == null)
        {
            JOptionPane.showMessageDialog(null, "Imagem não carregada!");
        }
    }

   
    @Override
    public void paint(Graphics g) 
    {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.RED);
        g.drawImage(mapa, 0,0, 700,600, null);
        
        if(deathstar.isloaded())
        {
            g.drawImage(deathstar.getTextura(),deathstar.getPosX(),
                        deathstar.getPosY(), deathstar.getWidth(), 
                        deathstar.getHeight(), this);
        
            if(deathstar.isMoving())
            {
                Graphics2D g2d =  (Graphics2D) g;
                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(Color.MAGENTA);
                g2d.draw(new Line2D.Float(deathstar.getPosX() + deathstar.getWidth()/2, deathstar.getPosY() + deathstar.getHeight()/2, deathstar.getDstX(), deathstar.getDstY()));
              
            }
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }


    @Override
    public void mousePressed(MouseEvent e)
    {
        JOptionPane.showMessageDialog(null, e.getX()  +", "+ e.getY());
        //Se o mouse for clicado irá ir para o ponto de teste
        deathstar.setDestination(Plane.Pontos.NTL.ordinal());
        deathstar.setIsMoving(true);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }

    @Override
    public void run() {
 
        while(true)
        {
            try {
                Thread.sleep(30);
                deathstar.Update();
                repaint();
      
            } catch (InterruptedException ex) {
                Logger.getLogger(jpMapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
