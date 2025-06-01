package loilt.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loilt.mobile.CreateMobileError;
import loilt.mobile.MobileDAO;
import loilt.mobile.MobileDTO;
import loilt.util.ValidationHelper;

@WebServlet(name = "CreateMobileController", urlPatterns = {"/CreateMobileController"})
public class CreateMobileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String SUCCESS_PAGE = "createSuccess.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mobileId = request.getParameter("txtMobileId");
        String mobileName = request.getParameter("txtMobileName");
        String price = request.getParameter("txtMobilePrice");
        String description = request.getParameter("txtDescription");
        String quantity = request.getParameter("txtQuantity");
        String yearOfProduction = request.getParameter("txtYearOfProduction");
        String notSale = request.getParameter("txtNotSale");
        String url = "createMobile.jsp";
        try {
            MobileDAO dao = new MobileDAO();
            CreateMobileError errors = new CreateMobileError();
            boolean foundError = false;

            if (dao.getMobileById(mobileId) != null) {
                errors.setIdIsExisted("Id is Existed!!!");
                foundError = true;
            }

            if (!ValidationHelper.matchWithPattern(mobileName, ValidationHelper.VALID_MOBILE_NAME)) {
                errors.setMobileNameLengthError("Mobile name must be between 3 and 20 characters!!!");
                foundError = true;
            }

            if (ValidationHelper.isPositiveFloat(price) == false) {
                errors.setPriceIsNotPositiveNumber("Price must be a positive float number!!!");
                foundError = true;
            }

            if (!ValidationHelper.matchWithPattern(description, ValidationHelper.VALID_DESCRIPTION)) {
                errors.setDescriptionLengthError("Description must be between 3 and 250 characters!!!");
                foundError = true;
            }

            if (!ValidationHelper.isPositiveInt(quantity)) {
                errors.setQuantityIsNotPositiveNumber("Price must be a positive integer number!!!");
                foundError = true;
            }

            if (!ValidationHelper.isPositiveInt(yearOfProduction)) {
                errors.setYearOfProductionIsNotPositiveNumber("Year of Production must be a positive integer number!!!");
                foundError = true;
            }

            if (foundError) {
                request.setAttribute("CREATE_ERRORS", errors);
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                return;
            }

            // Insert Logic
            MobileDTO dto = new MobileDTO(mobileId, mobileName, Float.parseFloat(price), description, Integer.parseInt(quantity), Integer.parseInt(yearOfProduction), notSale != null);
            boolean result = dao.insertMobile(dto);
            if (result) {
                url = SUCCESS_PAGE;
            }
            response.sendRedirect(url);
        } catch (SQLException ex) {
            Logger.getLogger(CreateMobileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateMobileController.class.getName()).log(Level.SEVERE, null, ex);
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
