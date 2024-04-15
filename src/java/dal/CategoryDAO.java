/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Category";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"),
                        rs.getString("name"));
                list.add(c);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void insert(Category c) {
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([name])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Category getCategoryById(int id) {
        String sql = "select * from Category where id =?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("id"),
                        rs.getString("name"));
                return c;

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Category]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Category cNew) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [name] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, cNew.getName());
            pst.setInt(2, cNew.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // count num of category in db 
    public int getTotalCategory() {
        int totalCategories = 0;
        try {
            String sql = "SELECT COUNT(*) FROM Category"; // Assuming 'categories' is the table name

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                totalCategories = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return totalCategories;
    }

    public static void main(String[] args) {
        CategoryDAO cdao = new CategoryDAO();
        List<Category> list = cdao.getAllCategory();
        int count = cdao.getTotalCategory();
        System.out.println(count);
        System.out.println(list.get(0).getName());
        for (Category category : list) {
            System.out.println(category);
        }
    }
}
