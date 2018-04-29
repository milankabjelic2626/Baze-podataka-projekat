
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author milankabjelic
 */
public class Konekcija 
{ 
    private static Connection con;
    private static String url = "jdbc:mysql://localhost:8889/it350-projekat";
    private static String user = "mima";
    private static String password = "";
    
    private Konekcija(){
        
    }
    
    public static Connection getInstance()
    {
        if(con == null){
            try {
                con = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }
}
