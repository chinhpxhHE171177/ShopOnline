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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

///////////////////////////////////////////////////////////// Get Product ////////////////////////////////////////////////////
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * From Product";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product p \n"
                    + "                         INNER JOIN DateExp d ON d.cid = p.category_id";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"),
                        rs.getDate("mfgDate"));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

////////////////////////////////////////////////////////////////// Get Last Product ///////////////////////////////////////////////////////////                  
    public Product getLastProduct() {
        String sql = "SELECT TOP 1 * FROM Product\n"
                + "ORDER BY id DESC";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                return p;
            }
        } catch (SQLException e) {
        }
        return null;
    }

//////////////////////////////////////////////////////////// Get Product from id ///////////////////////////////////////////////////////////////
    public List<Product> getFoodProducts() {
        List<Product> foodProducts = new ArrayList<>();
        try {
            // Assuming there is a category_id column in the Product table
            String sql = "SELECT p.* FROM Product p\n"
                    + "JOIN Category c ON p.category_id = c.id\n"
                    + "WHERE c.id IN (1, 2, 3, 4, 5, 6);";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"));
                foodProducts.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
            e.printStackTrace();
        }
        return foodProducts;
    }

    public List<Product> getDrinkProducts() {
        List<Product> drinkProducts = new ArrayList<>();
        try {
            // Assuming there is a category_id column in the Product table
            String sql = "SELECT p.*\n"
                    + "FROM Product p\n"
                    + "JOIN Category c ON p.category_id = c.id\n"
                    + "WHERE c.id IN (7, 8)";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"));
                drinkProducts.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
            e.printStackTrace();
        }
        return drinkProducts;
    }

    public List<Product> getCoffeeProducts() {
        List<Product> coffeeProducts = new ArrayList<>();
        try {
            // Assuming there is a category_id column in the Product table
            String sql = "SELECT p.* FROM Product p\n"
                    + "JOIN Category c ON p.category_id = c.id\n"
                    + "WHERE c.id = 9;";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"));
                coffeeProducts.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
            e.printStackTrace();
        }
        return coffeeProducts;
    }

    public Product getProductById(int productId) {
        String sql = "select * from Product where id =?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, productId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

/////////////////////////////////////////////////////////// Get Product by CategoryId ///////////////////////////////////////////////////////
    public List<Product> getProductByCategoryId(int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE Product.category_id = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, categoryId);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
            e.printStackTrace();
        }
        return list;
    }
////////////////////////////////////////////////// Get Total /////////////////////////////////////////////////////
    // count num of product in db 

    public int getTotalProduct() {
        String sql = "SELECT COUNT(*) FROM Product";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt(1); // total 156
            }
        } catch (SQLException e) {
        }

        return 0;
    }

//////////////////////////////////////////////////////////////////////// Search //////////////////////////////////////////////////////////
    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product\n"
                    + "Where [name] like ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, "%" + txtSearch + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> searchProductByPrice2() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE price BETWEEN 31.000 AND 99.000 ORDER BY price ASC";
        try (
                PreparedStatement pst = connection.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> searchProductByPrice1() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE price BETWEEN 8 AND 30 ORDER BY price ASC";
        try (
                PreparedStatement pst = connection.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Product> searchProductByPrice3() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE price BETWEEN 100 AND 400 ORDER BY price ASC";
        try (
                PreparedStatement pst = connection.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getString("image_url"),
                        rs.getInt("category_id"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<Product> getProductWithPaging(int page, int PAGE_SIZE) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product\n"
                    + "order by Id\n"
                    + "offset ? rows fetch first ? rows only;";
            PreparedStatement pst = connection.prepareStatement(sql);
            int offset = (page - 1) * PAGE_SIZE;
            pst.setInt(1, offset);
            pst.setInt(2, PAGE_SIZE);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

///////////////////////////////////////////////////////////////// Insert Delete Add Update Sort ///////////////////////////////////////////////////////////
    public void insert(Product product) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([name]\n"
                + "           ,[quantity]\n"
                + "           ,[price]\n"
                + "           ,[description]\n"
                + "           ,[image_url]\n"
                + "           ,[category_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, product.getName());
            st.setInt(2, product.getQuantity());
            st.setDouble(3, product.getPrice());
            st.setString(4, product.getDescription());
            st.setString(5, product.getImageUrl());
            st.setInt(6, product.getCategoryId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void delete(int id) {
        String sql = "Delete from [dbo].[Product]\n"
                + "     where ID =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Product pNew) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [name] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[image_url] = ?\n"
                + "      ,[category_id] = ?\n"
                + " WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, pNew.getName());
            pst.setInt(2, pNew.getQuantity());
            pst.setDouble(3, pNew.getPrice());
            pst.setString(4, pNew.getDescription());
            pst.setString(5, pNew.getImageUrl());
            pst.setInt(6, pNew.getCategoryId());
            pst.setInt(7, pNew.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
        }

    }

    public List<Product> sortProductByPriceUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product\n"
                    + "ORDER BY price ";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortFoodByPriceUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (1,2,3,4,5,6)\n"
                    + "ORDER BY price";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortDrinkByPriceUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (7,8)\n"
                    + "ORDER BY price";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortCoffeeByPriceUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id = 9\n"
                    + "ORDER BY price";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortProductByPriceDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product\n"
                    + "ORDER BY price DESC ";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortFoodByPriceDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (1,2,3,4,5,6)\n"
                    + "ORDER BY price DESC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortDrinkByPriceDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (7,8)\n"
                    + "ORDER BY price DESC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortCoffeeByPriceDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id = 9\n"
                    + "ORDER BY price DESC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary

        }
        return list;
    }

    public List<Product> sortProductByNameUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product\n"
                    + "ORDER BY [name]";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

    public List<Product> sortFoodByNameUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (1,2,3,4,5,6)\n"
                    + "ORDER BY [name]";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

    public List<Product> sortDrinkByNameUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (7,8)\n"
                    + "ORDER BY [name]";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

    public List<Product> sortCoffeeByNameUp() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id = 9\n"
                    + "ORDER BY [name]";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

    public List<Product> sortProductByNameDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product\n"
                    + "ORDER BY [name] DESC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

    public List<Product> sortFoodByNameDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (1,2,3,4,5,6)\n"
                    + "ORDER BY [name] DESC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

    public List<Product> sortDrinkByNameDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id IN (7,8)\n"
                    + "ORDER BY [name] DESC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }

    public List<Product> sortCoffeeByNameDown() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product WHERE category_id = 9\n"
                    + "ORDER BY [name] DESC";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7));
                list.add(p);
            }
        } catch (SQLException e) {
            // Handle the exception, log it, or rethrow if necessary
        }
        return list;
    }
////////////////////////////////////////////////////////////////////////// MAIN /////////////////////////////////////////////////////////

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<Product> productList = productDAO.getAllProducts();
        //List<Product> productList = productDAO.getProductByCategoryId(1);
        List<Product> sort = productDAO.sortDrinkByNameDown();
        List<Product> searchPrice = productDAO.searchProductByPrice1();
//        System.out.println("Products with price between 8000 and 30000:");
//        for (Product product : searchPrice) {
//            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: " + product.getPrice());
//        }
        for (Product product : productList) {
            System.out.println(product);
        }
        //System.out.println(sort);
//        System.out.println(productDAO.getTotalAccount());

//         Product p = productDAO.getProductById(1);
//         System.out.println(p);
    }

}
