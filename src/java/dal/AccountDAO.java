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
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDAO extends DBContext {

    public Account login(String username, String password) {
        String sql = "SELECT * FROM Account WHERE username = ? AND password = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setDisplayName(rs.getString("displayName"));
                account.setAddress(rs.getString("address"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));
                account.setRole(rs.getInt("role"));
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM Account WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setDisplayName(rs.getString("displayName"));
                account.setAddress(rs.getString("address"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));
                account.setRole(rs.getInt("role"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM Account WHERE email = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setDisplayName(rs.getString("displayName"));
                account.setAddress(rs.getString("address"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));
                account.setRole(rs.getInt("role"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPhone(String phone) {
        String sql = "SELECT * FROM Account WHERE phone = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, phone);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setDisplayName(rs.getString("displayName"));
                account.setAddress(rs.getString("address"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));
                account.setRole(rs.getInt("role"));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Account";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("displayName"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("role"));
                list.add(account);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Account getAccountById(int id) {
        String sql = "SELECT * FROM Account WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("displayName"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("role"));
                return account;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public String getNewestAccount() {
        String newestnum = " ";
        try {
            String sql = "SELECT username FROM Account WHERE id = (SELECT MAX(id) FROM Account);";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                newestnum = rs.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newestnum;
    }

    //count num of account in db 
    public int getTotalAccount() {
        int totalCategories = 0;
        try {
            String sql = "SELECT COUNT(*) FROM Account"; // Assuming 'categories' is the table name

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                totalCategories = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return totalCategories;
    }

    public void changePass(Account acc) throws SQLException {
        String sql = "UPDATE Account SET password = ? WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, acc.getPassword());
        stmt.setString(2, acc.getUsername());
        stmt.executeUpdate();
    }

    public void changeProfile(Account account) throws SQLException {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [username] = ?\n"
                + "      ,[displayName] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone] = ?\n"
                + " WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, account.getUsername());
        pst.setString(2, account.getDisplayName());
        pst.setString(3, account.getAddress());
        pst.setString(4, account.getEmail());
        pst.setString(5, account.getPhone());
        pst.setInt(6, account.getId());
        pst.executeUpdate();
    }

    public void changeProfileAdmin(Account account) throws SQLException {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [username] = ?\n"
                + "      ,[displayName] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phone] = ?\n"
                + "      ,[role] = ?\n"
                + " WHERE id = ?";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, account.getUsername());
        pst.setString(2, account.getDisplayName());
        pst.setString(3, account.getAddress());
        pst.setString(4, account.getEmail());
        pst.setString(5, account.getPhone());
        pst.setInt(6, account.getRole());
        pst.setInt(7, account.getId());

        pst.executeUpdate();
    }

    public void register(Account account) throws SQLException {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[displayName]\n"
                + "           ,[address]\n"
                + "           ,[email]\n"
                + "           ,[phone])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account.getUsername());
            st.setString(2, account.getPassword());
            st.setString(3, account.getDisplayName());
            st.setString(4, account.getAddress());
            st.setString(5, account.getEmail());
            st.setString(6, account.getPhone());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addUser(Account account) throws SQLException {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[displayName]\n"
                + "           ,[address]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[role])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, account.getUsername());
            st.setString(2, account.getPassword());
            st.setString(3, account.getDisplayName());
            st.setString(4, account.getAddress());
            st.setString(5, account.getEmail());
            st.setString(6, account.getPhone());
            st.setInt(7, account.getRole());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account deleteAccount(int id) {
        String sql = "DELETE FROM Account WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        // Create an Account object with sample data
        Account account = new Account();
//        account.setUsername("testuser");
//        account.setPassword("testpassword");
//        account.setDisplayName("Test User");
//        account.setAddress("test");
//        account.setEmail("test@example.com");
//        account.setPhone("123456789");
//        // Create an instance of your DAO class
        AccountDAO adao = new AccountDAO();
//        // Call the insert method and pass the Account object
//        adao.register(account);
//        System.out.println("Account inserted successfully!");

        //List<Account> listca = adao.getAllAccount();
        // check deleteAccount 
        //adao.deleteAccount(97);
//        for (Account acc : listca) {
//            System.out.println(acc);
//        }
//        System.out.println(adao.getNewestAccount());

        int count = adao.getTotalAccount();
        System.out.println(count);
           String newest = adao.getNewestAccount();
           System.out.println(newest);
    }
}
