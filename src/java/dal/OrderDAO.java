/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import jakarta.servlet.jsp.jstl.sql.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public int createReturnId(Order order) {
        try {
            String sql = "INSERT INTO [dbo].[Orders]\n"
                    + "           ([account_id]\n"
                    + "           ,[totalPrice]\n"
                    + "           ,[note]\n"
                    + "           ,[shipping_id])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";

            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, order.getAccountId());
            pst.setDouble(2, order.getTotalPrice());
            pst.setString(3, order.getNote());
            pst.setInt(4, order.getShippingId());

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    public int getAllOrder() {
        String sql = "SELECT COUNT(*) FROM [Orders]";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }

        return 0;
    }

    public List<Order> OrderDetail() {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "    o.id AS OrderId,\n"
                    + "    od.productName AS ProductName,\n"
                    + "    od.quantity AS Quantity,\n"
                    + "    od.productPrice AS Price,\n"
                    + "    o.note AS Note,\n"
                    + "    o.date AS CreatedDate,\n"
                    + "    o.totalPrice AS TotalPrice,\n"
                    + "    s.name AS Name,\n"
                    + "    s.phone AS Phone,\n"
                    + "    s.address AS Address\n"
                    + "FROM \n"
                    + "    OrderDetail od\n"
                    + "JOIN \n"
                    + "    Orders o ON od.order_id = o.id\n"
                    + "JOIN \n"
                    + "    Shipping s ON o.shipping_id = s.id;";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("OrderId"),
                        rs.getString("productName"),
                        rs.getInt("Quantity"),
                        rs.getDouble("Price"),
                        rs.getString("Note"),
                        rs.getDate("CreatedDate"),
                        rs.getDouble("TotalPrice"),
                        rs.getString("Name"),
                        rs.getString("Phone"),
                        rs.getString("Address"));
                // Thêm đối tượng Order vào danh sách
                list.add(order);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần
        }
        return list;
    }

    public static void main(String[] args) {
        OrderDAO odao = new OrderDAO();
//        int count = odao.getAllOrder();
//        System.out.println(count);
        List<Order> list = odao.OrderDetail();
        for (Order order : list) {
            System.out.println(order);
        }
    }
}
