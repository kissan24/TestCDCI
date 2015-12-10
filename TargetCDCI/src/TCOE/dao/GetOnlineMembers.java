package TCOE.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TCOE.utils.ConnectionManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GetOnlineMembers {

	
public JsonArray allOnlineMembers(String s) {
        
        JsonArray products = new JsonArray();
        Connection con = null;
        try {
            con = new ConnectionManager().createConnection();
             StringBuilder sb = new StringBuilder();

        sb.append("select name from register_i");
        
        sb.append(" where loggedin='");
        sb.append( s+"'");
        
            PreparedStatement ps = con.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                JsonObject product = new JsonObject();
                product.addProperty("onlinemem", rs.getString("name"));
                
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
