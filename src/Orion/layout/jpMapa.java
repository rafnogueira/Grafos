/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import java.awt.Color;
import java.awt.Graphics;
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
public class jpMapa extends JPanel
{

    public jpMapa() {
        
        loadMap();
        repaint();
        
    }
    
    BufferedImage buffImage = null;
    public void loadMap()
    {
        int w,h ;
        String src = "/Users/rafael/Projects/Netbeans/Grafos/src/res/mapa.png";
        
        try {
            buffImage = ImageIO.read(new File(src));            
        } catch (IOException ex) {
            Logger.getLogger(Grafos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(buffImage == null)
        {
            JOptionPane.showMessageDialog(null, "Imagem não carregada!");
        }
    }

   
    @Override
    public void paint(Graphics g) {
    
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.RED);
        g.drawImage(buffImage, 0,0, 700,600, null);
            
    
    }
    
    
    
}
