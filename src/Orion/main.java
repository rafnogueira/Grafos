/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orion;

import Orion.layout.GrafosFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author rafael
 */
public class main {

    public static void main(String[] args) 
    {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            GrafosFrame app = new GrafosFrame();
            app.setLocationRelativeTo(null);
            app.setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
