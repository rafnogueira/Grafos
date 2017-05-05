/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class Plane
{
    private BufferedImage textura = null;
    private int Width, Height ;
    private int posX, posY;
    private int dstX,dstY;
    
    float dx;
    float dy;
    float angle;
    
    private int Speed;
    private boolean isMoving;
    
    public Plane() 
    {
        isMoving = false;
        this.Width  = 40;
        this.Height = 40;
        this.Speed = 5;
        
    }
    public Plane(int width , int height , String src) 
    {
        isMoving = false;
        this.Width  = width;
        this.Height = height;
        this.Speed = 5;
        loadTextura(src);
        
    }

    public final void loadTextura(String src)
    {
        try 
        {
            textura = ImageIO.read(new File(src));            
        } catch (IOException ex) {    
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        if(textura == null)
        {
            JOptionPane.showMessageDialog(null, "Imagem não carregada!");
        }   
        
    }
    
    public boolean isloaded()
    {
    
        if(textura != null)
        {
            return true;
        }else{
            return false;
        }
        
    }
    
    public void Update()
    {
        
        if(isMoving)
        {
            this.posX +=  Speed * Math.sin(angle);
            this.posY += Speed * Math.cos(angle);   
        }
        
    }
    public void setDestination(int x , int y)
    {
        this.dstX = x;
        this.dstY = y;
        
         this.dx = dstX-posX;
         this.dy = dstY-posY;
        
         this.angle = (float) Math.atan2(dx, dy);
         
    }
    
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    public int getWidth() {
        return Width;
    }

    public void setWidth(int Width) {
        this.Width = Width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }
    
    public Plane(int Width, int Height) {
        this.Width = Width;
        this.Height = Height;
    }
    
    public BufferedImage getTextura() {
        return textura;
    }

    public void setTextura(BufferedImage textura) {
        this.textura = textura;
    }

    public void setIsMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    

    
}
