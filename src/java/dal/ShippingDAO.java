/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Shipping;

/**
 *
 * @author Admin
 */
public class ShippingDAO extends DBContext {

    public int createReturnId(Shipping shipping) {
        try {
            String sql = "INSERT INTO [dbo].[Shipping]\n"
                    + "           ([name]\n"
                    + "           ,[phone]\n"
                    + "           ,[address])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // sau khi thuc thi tu tra ve key da dk tang
            
            // Chuyen param cho ?
            pst.setString(1, shipping.getName());
            pst.setString(2, shipping.getPhone());
            pst.setString(3, shipping.getAddress());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys(); // lay tat cac key tu tang
            if (rs.next()) {
                return rs.getInt(1); // trar ve vtr 1 la id
            }

        } catch (SQLException e) {
            Logger.getLogger(ShippingDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

}