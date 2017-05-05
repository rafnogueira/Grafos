/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    private boolean isMoving;
    
    public jpMapa() {
    
        isMoving = false;
        loadMap();
        repaint();
        addMouseListener(this);
        deathstar = new Plane(40,40,"/Users/rafael/Projects/Netbeans/Grafos/src/res/deathstar.jpg");
        thread = new Thread(this);
        thread.start();
        
    }
    
    public void loadMap()
    {
        int w,h ;
        String src = "/Users/rafael/Projects/Netbeans/Grafos/src/res/mapa.png";
        
        try {
            mapa = ImageIO.read(new File(src));            
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
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        
        deathstar.setDestination(e.getX(), e.getY());      
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
                Thread.sleep(10);

                    deathstar.Update();
                    repaint();
      
            } catch (InterruptedException ex) {
                Logger.getLogger(jpMapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
