/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion.layout;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class Plane {

    private BufferedImage textura = null;
    private int Width, Height;
    private int posX, posY;
    private int dstX, dstY;

    private float dx;
    private float dy;
    private float angle;

    private int Speed;
    private boolean isMoving;

    private final int[][] coords = {{247, 154}, {457, 106}, {685, 177}, {697, 219}, {630, 288}, {461, 326},
    {315, 313}, {344, 389}, {438, 429}, {461, 412}, {472, 437}, {532, 383}, {408, 441},
    {485, 448}, {537, 438}, {504, 436}, {445, 473}, {434, 494}, {449, 506}, {406, 549},};

//NTL 686, 177
    public enum Pontos {
        MAN, BEL, NTL, REC, SLV, BSB, CUI, CPG, BAU, RBP, CMP, BHO, LON, SPO, RJO, SJC, CUR, BLU, FLO, POA
    };

    public Plane() {
        isMoving = false;
        this.Width = 40;
        this.Height = 40;
        this.Speed = 5;

    }

    public Plane(int width, int height, String src) {
        isMoving = false;
        this.Width = width;
        this.Height = height;
        this.Speed = 5;
        loadTextura(src);
    }

    public final void loadTextura(String src) {
        try {
            
            textura = ImageIO.read(getClass().getResource(src));
            
            //textura = ImageIO.read(new File(src));
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        if (textura == null) {
            JOptionPane.showMessageDialog(null, "Imagem não carregada!");
        }

    }

    public boolean isloaded() {

        if (textura != null) {
            return true;
        } else {
            return false;
        }
    }

    public void Update() {

        if (isMoving) {
            this.dx = this.dstX - this.posX;
            this.dy = this.dstY - this.posY;
            this.angle = (float) Math.atan2(this.dx, this.dy);

            this.posX += Speed * Math.sin(this.angle);
            this.posY += Speed * Math.cos(this.angle);

            float distancia = (int) Math.sqrt((this.dstX - this.posX) * (this.dstX - this.posX) + (this.dstY - this.posY) * (this.dstY - this.posY));
//            System.out.println("Distance:" + distancia);

            if (distancia <= 5) {
                this.isMoving = false;
            }
        }
    }

    
    
    public void setDestination(int flag) {
        this.dstX = coords[flag][0];
        this.dstY = coords[flag][1];

    }

    //Recebe  um valor int para identificar como ponto
    public void setPosition(int flag) {
        //X ,Y
        this.setPosX(coords[flag][0]);
        this.setPosY(coords[flag][1]);

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

    public boolean isMoving() {
        return this.isMoving;
    }

    public int getDstX() {
        return dstX;
    }

    public int getDstY() {
        return dstY;
    }
    
    public void setAngle(float angle)
    {
        this.angle = angle;
    }
    
    public float getAngle()
    {
        return this.angle;
    }

    
}
