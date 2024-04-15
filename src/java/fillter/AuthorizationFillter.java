/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillter;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Admin
 */
@WebFilter(filterName = "AuthorizationFillter", urlPatterns = {"/product-management", "/add-product", "/add-category", 
    "/update-category", "/update-product", "/filter-category-dashboard", "/account-management", "/add-account", "/dashboard", "/order-detail"})
public class AuthorizationFillter implements Filter {

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        // Retrieve the logged-in account from the session
        Account account = (Account) session.getAttribute("account");

        if (account != null && account.getRole() == 1) {
            // Allow the request to pass through the filter chain
            chain.doFilter(request, response);
            return;
        } else {
            // Redirect the user to the login page
            //res.sendRedirect("../login.jsp");
             res.sendRedirect(req.getContextPath() + "/login");
        }

    }

  
    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {

        return null;

    }

}
