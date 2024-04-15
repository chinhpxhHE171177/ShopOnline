/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO extends DBContext {

    public void saveCart(int orderId, Map<Integer, Cart> carts) {
        try {

            String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                    + "           ([order_id]\n"
                    + "           ,[productName]\n"
                    + "           ,[productImage]\n"
                    + "           ,[productPrice]\n"
                    + "           ,[quantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, orderId);
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer productId = entry.getKey();
                Cart cart = entry.getValue();
                pst.setString(2, cart.getProduct().getName());
                pst.setString(3, cart.getProduct().getImageUrl());
                pst.setDouble(4, cart.getProduct().getPrice());
                pst.setDouble(5, cart.getQuantity());// boi vi khi thanh toan khong lay tat ca san pham trong product
                // luu san pham quantity trong gio hang thoi
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
