package loilt.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loilt.mobile.MobileDAO;
import loilt.mobile.MobileDTO;
import loilt.util.ValidationHelper;

@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

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
        String url = "";
        String mobileId = request.getParameter("txtMobileId");
        String price = request.getParameter("txtPrice");
        String description = request.getParameter("txtDescription");
        String quantity = request.getParameter("txtQuantity");
        String yearOfProduction = request.getParameter("txtYearOfProduction");
        String notSale = request.getParameter("txtNotSale");
        String lastSearchValue = request.getParameter("lastSearchValue");
        String role = request.getParameter("txtRole");

        try {
            MobileDAO dao = new MobileDAO();
            MobileDTO dto = dao.getMobileById(mobileId);
            dto.setQuantity(ValidationHelper.isPositiveInt(quantity) ? Integer.parseInt(quantity) : dto.getQuantity());
            dto.setPrice(ValidationHelper.isPositiveFloat(price) ? Float.parseFloat(price) : dto.getPrice());
            dto.setYearOfProduction(ValidationHelper.isPositiveInt(yearOfProduction) ? Integer.parseInt(yearOfProduction) : dto.getYearOfProduction());
            dto.setNotSale(notSale != null);
            dto.setDescription(ValidationHelper.isEmpty(description) ? dto.getDescription() : description);
            boolean result = dao.updateMobile(dto);
            if (result) {
                url = "DispatchController"
                        + "?btAction=Search"
                        + "&txtSearchValue="
                        + lastSearchValue
                        + "&txtRole="
                        + role;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
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
