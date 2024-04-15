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
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Account;
import model.Cart;
import model.Product;

/**
 *
 * @author Admin
 */
public class AddToCartServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartServlet at " + request.getContextPath() + "</h1>");
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
        int productId = Integer.parseInt(request.getParameter("productId"));
        // map key:productId | Value: cart
        HttpSession session = request.getSession();

        // cai nay duoc thay the bang fillter
//        //check login 
//        Account account = (Account) session.getAttribute("account");
//        if(account == null) {
//            response.sendRedirect("login");
//            return;
//        }

        Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
        if (carts == null) {
            carts = new LinkedHashMap<>(); // no co thu tu
        }

        // 1. Lay product ung voi id nhan duoc
        // 2 TH
        if (carts.containsKey(productId)) { // san pham co tren gio hang
            int oldQuantity = carts.get(productId).getQuantity();
            carts.get(productId).setQuantity(oldQuantity + 1);
        } else { // sp chua co tren gio hang
            // Corrected line: Create a Product object using the ProductDAO
            Product product = new ProductDAO().getProductById(productId);
            Cart mycart = new Cart();
            mycart.setProduct(product);
            mycart.setQuantity(1);
            carts.put(productId, mycart); // Nếu chưa có sản phẩm thì đặt quantity mặc định là 1
        }

        // Luu carts len Session
        session.setAttribute("carts", carts);
        String urlHistory = (String) session.getAttribute("UrlHistory");
        if (urlHistory == null) {
            urlHistory = "shop";
        }
        //response.sendRedirect("detail?productId=" + productId);
        //response.sendRedirect((String)session.getAttribute("urlHistory"));
        String referer = request.getHeader("referer"); // Lấy URL của trang trước đó
        if (referer != null && referer.contains("detail")) {
            // Nếu referer chứa "detail", tức là đã thêm sản phẩm từ trang detail, 
            // vì vậy quay lại trang detail
            response.sendRedirect("detail?productId=" + productId);
        } else {
            // Nếu không, quay lại trang khác
            //response.sendRedirect((String) session.getAttribute("urlHistory"));
            response.sendRedirect("shop");
        }
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
