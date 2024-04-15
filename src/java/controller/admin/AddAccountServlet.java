/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import model.Account;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddUserServlet", urlPatterns = {"/add-account"})
public class AddAccountServlet extends HttpServlet {

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
            out.println("<title>Servlet AddUserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddUserServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        AccountDAO adao = new AccountDAO();
        List<Account> list = adao.getAllAccount();
        request.setAttribute("users", list);

        request.getRequestDispatcher("addaccount.jsp").forward(request, response);
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
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int role = Integer.parseInt(request.getParameter("role"));

        AccountDAO adao = new AccountDAO();

        if (name.isEmpty() || password.isEmpty() || fullname.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            String ms = "Not be empty!!!";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("addaccount.jsp").forward(request, response);
            return; // exit if there are empty fields
        }

        if (adao.checkUsername(name)) {
            // quay ve dang ki lai
            String ms = "Username existed";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("addaccount.jsp").forward(request, response);
            return; // exit if the username exists
        }

        if (adao.checkEmail(email)) {
            // quay ve dang ki lai
            String ms = "Email existed";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("addaccount.jsp").forward(request, response);
            return; // exit if the email exists
        }

        if (adao.checkPhone(phone)) {
            // quay ve dang ki lai
            String ms = "Phone existed";
            request.setAttribute("error", ms);
            request.getRequestDispatcher("addaccount.jsp").forward(request, response);
            return; // exit if the phone exists
        }
        // neu account chua co 
        try {
            Account account = new Account(name, password, fullname, address, email, phone, role);
            adao.addUser(account);
            response.sendRedirect("account-management");
        } catch (SQLException e) {
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

}
