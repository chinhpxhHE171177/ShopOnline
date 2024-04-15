/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.sync;

import dal.CategoryDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author Admin
 */
public class ShopServlet extends HttpServlet {

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
            out.println("<title>Servlet ShopServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopServlet at " + request.getContextPath() + "</h1>");
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
        final int PAGE_SIZE = 12;

        // Retrieve list of categories
        List<Category> listca = new CategoryDAO().getAllCategory();
        request.setAttribute("listca", listca);
        // Retrieve list of Products
        List<Product> listpro = new ProductDAO().getAllProduct();
        // Retrieve newest product
        Product lastPro = new ProductDAO().getLastProduct();
        request.setAttribute("lastpro", lastPro);

        // Set the page and totalPage attributes
        int page = 1; // Default to page 1
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        int totalProducts = new ProductDAO().getTotalProduct(); // Assuming you have a method to get the total number of products
        int pageSize = PAGE_SIZE; // Set your desired page size

        int totalPage = calculateTotalPage(totalProducts, pageSize);

        request.getSession().setAttribute("urlHistory", "shop");
        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);

        // Retrieve the sublist of products for the current page
        List<Product> listproducts = listpro.subList((page - 1) * PAGE_SIZE, Math.min(page * PAGE_SIZE, listpro.size()));
        request.setAttribute("listpro", listproducts);

        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
        //processRequest(request, response);
        String sortBy = request.getParameter("sort-by");
        String price = request.getParameter("searchByPrice");

        ProductDAO pdao = new ProductDAO();
        CategoryDAO cdao = new CategoryDAO();
        List<Category> listca = cdao.getAllCategory();
        Product lastpro = pdao.getLastProduct();
        try {
            ArrayList<Product> list = null;
            String selectedOption = "";
            switch (sortBy) {
                case "price-up":
                    list = (ArrayList<Product>) pdao.sortProductByPriceUp();
                    selectedOption = "price-up";
                    break;
                case "price-down":
                    list = (ArrayList<Product>) pdao.sortProductByPriceDown();
                    selectedOption = "price-down";
                    break;
                case "name-up":
                    list = (ArrayList<Product>) pdao.sortProductByNameUp();
                    selectedOption = "name-up";
                    break;
                case "name-down":
                    list = (ArrayList<Product>) pdao.sortProductByNameDown();
                    selectedOption = "name-down";
                    break;
            }
           
            request.setAttribute("listpro", list);
            request.setAttribute("listca", listca);
            request.setAttribute("lastpro", lastpro);
            request.setAttribute("sortBY", selectedOption);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", "Not Found Product");
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        }
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

    public int calculateTotalPage(int totalProducts, int pageSize) {
        if (totalProducts <= 0 || pageSize <= 0) {
            return 0; // Handle invalid input
        }
        return (int) Math.ceil((double) totalProducts / pageSize);

    }
}

// error 404 --> url 
// erorr 505 --> jsp attribute 
