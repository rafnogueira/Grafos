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
    private final boolean isMoving;
    private final String objTexture = "./src/res/deathstar.jpg";
    private final String mapTexture = "./src/res/mapa.png";
    

    public jpMapa() {
        deathstar = new Plane(40,40,objTexture);
        deathstar.setPosition(Plane.Pontos.RJO.ordinal());

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
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }


    @Override
    public void mousePressed(MouseEvent e)
    {

        //Se o mouse for clicado irá ir para o ponto de teste
        deathstar.setDestination(Plane.Pontos.MAN.ordinal());
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
