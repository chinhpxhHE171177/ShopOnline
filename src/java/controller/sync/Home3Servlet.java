/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.sync;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author Admin
 */
public class Home3Servlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet Home3Servlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home3Servlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        final int PAGE_SIZE = 12;
        List<Product> listpro = new ProductDAO().getCoffeeProducts();

        // Set the page and totalPage attributes
        int page = 1; // Default to page 1
        String pageStr = request.getParameter("page");
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }

        int totalProducts = new ProductDAO().getTotalProduct(); // Assuming you have a method to get the total number of products
        int pageSize = PAGE_SIZE; // Set your desired page size

        int totalPage = calculateTotalPage(listpro.size(), pageSize);

        request.setAttribute("page", page);
        request.setAttribute("totalPage", totalPage);

        // Retrieve the sublist of products for the current page
        List<Product> listproducts = listpro.subList((page - 1) * PAGE_SIZE, Math.min(page * PAGE_SIZE, listpro.size()));
        request.setAttribute("listpro", listproducts);
        request.getRequestDispatcher("home_3.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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

        ProductDAO pdao = new ProductDAO();
        try {
            ArrayList<Product> list = null;
            String selectedOption = "";
            switch (sortBy) {
                case "price-up":
                    list = (ArrayList<Product>) pdao.sortCoffeeByPriceUp();
                    selectedOption = "price-up";
                    break;
                case "price-down":
                    list = (ArrayList<Product>) pdao.sortCoffeeByPriceDown();
                    selectedOption = "price-down";
                    break;
                case "name-up":
                    list = (ArrayList<Product>) pdao.sortCoffeeByNameUp();
                    selectedOption = "name-up";
                    break;
                case "name-down":
                    list = (ArrayList<Product>) pdao.sortCoffeeByNameDown();
                    selectedOption = "name-down";
                    break;
            }
            request.setAttribute("listpro", list);
            request.setAttribute("sortBY", selectedOption);
            request.getRequestDispatcher("home_3.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", "Not Found Coffee");
            request.getRequestDispatcher("home_3.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
     public int calculateTotalPage(int listSize, int pageSize) {
        if (listSize <= 0 || pageSize <= 0) {
            return 0;
        }
        return (int) Math.ceil((double) listSize / pageSize);
    }

}
