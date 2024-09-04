//*To change this license header, choose License Headers in Project Properties.
 //*To change this template file, choose Tools | Templates*//
 //*and open the template in the editor.*//
 
package MovieTicket;

import DbConnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdatemovieBE extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdatemovieBE</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet UpdatemovieBE at " + request.getContextPath() + "</h1>");
            String movname=request.getParameter("mname");
            String movtime=request.getParameter("show_timings");
            String movprice=request.getParameter("ticket_price");
            String movdate=request.getParameter("show_date");
            Connection con=dbconnection.getConnectTomovieticket();
             String sql = "INSERT INTO movie( mname, mtimings, mtprice,mdate) VALUES (?, ?, ?, ?)";
               PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,movname );
        ps.setString(2, movtime);
        ps.setString(3, movprice);
        ps.setString(4,movdate);
        int i = ps.executeUpdate();
        if (i > 0) {
            out.println("<script> alert('movie added');</script>");
            request.getRequestDispatcher("UpdatemovieFE.html").include(request, response);
        } else {
            out.println("<script> alert('movie not added');</script>");
            request.getRequestDispatcher("UpdatemovieFE.html").include(request, response);
        }
      
            con.close();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdatemovieBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdatemovieBE.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdatemovieBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdatemovieBE.class.getName()).log(Level.SEVERE, null, ex);
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
