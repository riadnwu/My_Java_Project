/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javademo;

//STEP 1. Import required packages
import java.sql.*;

/**
 *
 * @author JHON-PC
 */
public class JavaDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new loginJFrame().setVisible(true);
            }
        });

    }
}
