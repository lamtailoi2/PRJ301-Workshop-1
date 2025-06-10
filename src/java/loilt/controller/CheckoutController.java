/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loilt.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loilt.cart.CartItem;
import loilt.cart.CartObj;
import loilt.mobile.MobileDTO;
import loilt.orderdetails.OrderDetailsDAO;
import loilt.user.UserDTO;

/**
 *
 * @author HP
 */
@WebServlet(name = "CheckoutController", urlPatterns = {"/CheckoutController"})
public class CheckoutController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SUCCESS_PAGE = "checkoutSuccess.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }
        CartObj cart = (CartObj) session.getAttribute("CART");
        UserDTO user = (UserDTO) session.getAttribute("USER");
        if (cart != null) {
            try {
                OrderDetailsDAO dao = new OrderDetailsDAO();
                for (CartItem item : cart.getItems().values()) {
                    MobileDTO mobile = item.getMobile();
                    dao.insertOrderDetail(mobile.getMobileId(), item.getQuantity(), mobile.getPrice(), user.getUserId());
                }
                session.removeAttribute("CART");
                url = SUCCESS_PAGE;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                response.sendRedirect(url);
            }
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
        processRequest(request, response);
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
