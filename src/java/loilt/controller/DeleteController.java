package loilt.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loilt.mobile.MobileDAO;
import loilt.user.UserDTO;

@WebServlet(name = "DeleteController", urlPatterns = {"/DeleteController"})
public class DeleteController extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Check role
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(LOGIN_PAGE);
            return;
        } else {
            UserDTO user = (UserDTO) session.getAttribute("USER");
            if (user == null || user.getRole() != 2) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        String mobileId = request.getParameter("txtMobileId");
        String lastSearchValue = request.getParameter("lastSearchValue");
        String role = request.getParameter("txtRole");
        String url = "";
        try {
            MobileDAO dao = new MobileDAO();
            boolean result = dao.deleteById(mobileId);
            if (result) {
                url = "DispatchController"
                        + "?btAction=Search"
                        + "&txtSearchValue="
                        + lastSearchValue
                        + "&txtRole="
                        + role;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(url);
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
