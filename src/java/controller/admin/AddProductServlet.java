/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.CategoryDAO;
import dal.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {

//    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO cdao = new CategoryDAO();
        List<Category> list1 = cdao.getAllCategory();
        request.setAttribute("catego", list1);
        String asd = "asd";
        request.setAttribute("er", asd);
        RequestDispatcher rd = request.getRequestDispatcher("addproduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        String describe = request.getParameter("describe");
        int price = Integer.parseInt(price_raw);
        int quantity = Integer.parseInt(quantity_raw);
        int cid = Integer.parseInt(request.getParameter("cid"));
        Part imagePart = request.getPart("image");
        String fileName = getFileName(imagePart);
        ProductDAO d = new ProductDAO();

        try {
            Product product = new Product(name, quantity, price, describe, fileName, cid);
            d.insert(product);
            Part filePart = request.getPart("image");
            String uploadPath = getServletContext().getRealPath("") + "/uploads/" + fileName;
            filePart.write(uploadPath);
//            response.sendRedirect("admin-product?cid" + cid);
////            response.sendRedirect("dashboard?cid=" + cid);
//            response.sendRedirect("dashboard");
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        response.sendRedirect("filter-category-dashboard?categoryId=" + cid);
    }

    private String getFileName(Part part) {
        String partHeader = part.getHeader("content-disposition");
        System.out.println("Part Header = " + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.lastIndexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
