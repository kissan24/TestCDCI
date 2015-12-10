/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TCOE.dao;

import TCOE.beans.reset;
import TCOE.utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignite403
 */
public class ResetPass {

    public void resetpass(reset rs) {
        try {
            String npass=rs.getNpass();
            String uname=rs.getUname();
            String opass=rs.getOpass();
            Connection con=new ConnectionManager().createConnection();
            
            String str="update login_i set password='"+ npass +"' where name='"+ uname +"' and password='"+ opass +"' ";
            PreparedStatement ps=con.prepareStatement(str);
           
                ps.executeUpdate();
            
            ps.close();
            con.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResetPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ResetPass.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
