/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package real.estate.management;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author KID_UNTAMED
 */
public class RealEstateManagement {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        login vlog = new login();
        vlog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vlog.setSize(1000, 800);
        vlog.setVisible(true);
    }
    
}
