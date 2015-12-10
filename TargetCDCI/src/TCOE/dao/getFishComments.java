/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TCOE.dao;

import TCOE.utils.ConnectionManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ignite403
 */
public class getFishComments {

    public JsonArray allComments(String s) {
        
        JsonArray products = new JsonArray();
        Connection con = null;
        try {
            con = new ConnectionManager().createConnection();
             StringBuilder sb = new StringBuilder();

        sb.append("select * from fishpond_i1");
        
        sb.append(" where sname='");
        sb.append( s+"'");
        
            PreparedStatement ps = con.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                JsonObject product = new JsonObject();
                product.addProperty("comment", rs.getString("comments"));
                
                products.add(product);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
             ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
        }
        return products;
    }
    }
}
    

