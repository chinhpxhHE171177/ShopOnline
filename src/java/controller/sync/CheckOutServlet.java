/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.sync;

import dal.OrderDAO;
import dal.OrderDetailDAO;
import dal.ShippingDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import model.Cart;
import model.Order;
import model.Shipping;

/**
 *
 * @author Admin
 */
public class CheckOutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckOutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
        if (carts == null) {
            carts = new LinkedHashMap<>();
        }

        // total money
        double totalMoney = 0;
        for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
            Integer productId = entry.getKey();
            Cart cart = entry.getValue();

            totalMoney += cart.getQuantity() * cart.getProduct().getPrice();

        }
        request.setAttribute("totalMoney", totalMoney);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String note = request.getParameter("note");

        if (name == null || name.isEmpty() || phone == null || phone.isEmpty()
                || address == null || address.isEmpty()) {
            request.setAttribute("mess", "Please fill out completely");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } else {

            // save in db
            // save shipping 
            Shipping shipping = new Shipping();
            shipping.setName(name);
            shipping.setPhone(phone);
            shipping.setAddress(address);

            ShippingDAO shippingDAO = new ShippingDAO();
            int shippingId = shippingDAO.createReturnId(shipping);

            // total money
            HttpSession session = request.getSession();
            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
            if (carts == null) {
                carts = new LinkedHashMap<>();
            }

            double totalMoney = 0;
            for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                Integer productId = entry.getKey();
                Cart cart = entry.getValue();

                totalMoney += cart.getQuantity() * cart.getProduct().getPrice();
            }

            // save order 
            Order order = new Order();
            order.setAccountId(1); // you need to set the actual account id here
            order.setTotalPrice(totalMoney);
            order.setNote(note);
            order.setShippingId(shippingId);

            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.createReturnId(order);

            // save order detail
            OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
            orderDetailDAO.saveCart(orderId, carts);

            session.removeAttribute("carts"); // after placing the order, remove the cart from the session
            response.sendRedirect("thanks");
        }
    }

//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        String name = request.getParameter("name");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
//        String note = request.getParameter("note");
//
//        //luu vào database
//        //Luu Shipping 
//        Shipping shipping = Shipping.builder()
//                .name(name)
//                .phone(phone)
//                .address(address)
//                .build();
//        int ShippingId = new ShippingDAO().createReturnId(shipping); // tra ve id tu tang cua ban ghi vua luu vao database
//
//        // Ham tinh totalPrice
//        HttpSession session = request.getSession();
//        Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");
//        if (carts == null) {
//            carts = new LinkedHashMap<>();
//        }
//        //Tinh tong tien Total Amount
//        double totalPrice = 0;
//        for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
//            Integer productId = entry.getKey();
//            Cart cart = entry.getValue();
//
//            totalPrice += cart.getQuantity() * cart.getProduct().getPrice();
//        }
//
//        //luu Order
//        Order order = Order.builder()
//                .accountId(1)
//                .totalPrice(ShippingId)
//                .totalPrice(totalPrice)
//                .note(note)
//                .shippingId(ShippingId)
//                .build();
//        int orderId = new OrderDAO().createReturnId(order);
//
//        //Luu OrderDetail
//        new OrderDetailDAO().saveCart(orderId, carts); // luu ca gio hang vao database
//        session.removeAttribute("carts"); // sau khi thanh toan doan hang thanh cong thi xoa sp tren cart
//        response.sendRedirect("thanks");
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
