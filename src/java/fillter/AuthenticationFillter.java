/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fillter;

import dal.AccountDAO;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Admin
 */
@WebFilter(filterName = "AuthenticationFillter", urlPatterns = {"/add-to-cart", "/add-to-cart1", "/add-to-cart2", "/add-to-cart3", "/add-to-cart3-async", "/carts", "/check-out", "/delete-cart", "/update-quatity"})
public class AuthenticationFillter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        // check login 
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            // logined --> pass
            chain.doFilter(request, response);
        } else {
            //check cookie
            Cookie[] cookies = req.getCookies();
            String username = null;
            String password = null;
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    username = cooky.getValue();
                }
                if (cooky.getName().equals("password")) {
                    password = cooky.getValue();
                }
                if (username != null && password != null) {
                    break;
                }
            }

            // co luu cookie trong tinh duyet
            if (username != null && password != null) {
                Account acc = new AccountDAO().login(username, password);
                if (account != null) {
                    session.setAttribute("account", account);
                    chain.doFilter(request, response); // cho pass
                    return;
                }
            }
            res.sendRedirect("login");
        }
    }

    @Override
    public void destroy() {
    }

    /**
     * Init method for this filter
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }
}
