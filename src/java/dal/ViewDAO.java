package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ViewDAO extends DBContext {

    public int getView() {
        String sql = "SELECT * FROM [View]";
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

    public void updateView() {
        String sql = "UPDATE [View]\n"
                + "SET [view] = [view] + 1";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating view count: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ViewDAO vdao = new ViewDAO();
        int count = vdao.getView();
        System.out.println(count);
    }
}
