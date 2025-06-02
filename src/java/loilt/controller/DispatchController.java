package loilt.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DispatchController", urlPatterns = {"/DispatchController"})
public class DispatchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_CONTROLLER = "LoginController";
    private final String SEARCH_CONTROLLER = "SearchController";
    private final String DELETE_CONTROLLER = "DeleteController";
    private final String UPDATE_CONTROLLER = "UpdateController";
    private final String CREATE_MOBILE_CONTROLLER = "CreateMobileController";
    private final String ADD_TO_CART_CONTROLLER = "AddToCartController";
    private final String REMOVE_FROM_CART_CONTROLLER = "RemoveFromCartController";
    private final String CHECKOUT_CONTROLLER = "CheckoutController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        String action = request.getParameter("btAction");
        try {
            if (action == null) {

            } else if (action.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals("Search")) {
                url = SEARCH_CONTROLLER;
            } else if (action.equals("Delete")) {
                url = DELETE_CONTROLLER;
            } else if (action.equals("Update")) {
                url = UPDATE_CONTROLLER;
            } else if (action.equals("Create")) {
                url = CREATE_MOBILE_CONTROLLER;
            } else if (action.equals("Add To Cart")) {
                url = ADD_TO_CART_CONTROLLER;
            } else if (action.equals("Remove Item")) {
                url = REMOVE_FROM_CART_CONTROLLER;
            } else if (action.equals("Checkout")) {
                url = CHECKOUT_CONTROLLER;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        processRequest(request, response);
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
