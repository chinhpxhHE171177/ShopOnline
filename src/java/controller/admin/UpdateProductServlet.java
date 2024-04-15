/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/update-product"})
public class UpdateProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        ProductDAO pdao = new ProductDAO();
        CategoryDAO cdao = new CategoryDAO();

        int id;
        try {
            id = Integer.parseInt(id_raw);
            Product pro = pdao.getProductById(id);
            List<Category> list1 = cdao.getAllCategory();
            request.setAttribute("catego", list1);
            request.setAttribute("product", pro);

        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("updateproduct.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        String describe = request.getParameter("describe");
        String image = request.getParameter("image");
        String cateId = request.getParameter("categoryId");

        int quantity, categoryId = 0, id;
        double price;
        ProductDAO pdao = new ProductDAO();
        try {
            id = Integer.parseInt(id_raw);
            quantity = Integer.parseInt(quantity_raw);
            price = Double.parseDouble(price_raw);
            categoryId = Integer.parseInt(cateId);

            // Tạo đối tượng Product mới
            Product pNew = new Product(id, name, quantity, price, describe, image, categoryId);

            // Gọi phương thức update từ ProductDAO
            pdao.update(pNew);

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        response.sendRedirect("filter-category-dashboard?categoryId=" + categoryId);
//        response.sendRedirect("product-management");
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
