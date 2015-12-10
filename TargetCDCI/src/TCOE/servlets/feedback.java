package TCOE.servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import TCOE.utils.ConnectionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 *
 * @author ignite403
 */
public class feedback extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // @Override
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String feed = request.getParameter("feedback");
        String name = request.getParameter("name");
        
        Connection con=null;
       
        if (!name.equals("") && !feed.equals("")) {

            try {


               
                  ConnectionManager conman=new ConnectionManager();
               con= conman.createConnection(); 
                String rquery = "insert into feedback_i  values('" + name + "','" + feed + "')";
               
                PreparedStatement ps = con.prepareStatement(rquery);
                ps.executeUpdate();
                ps.close();
                con.close();
                request.setAttribute("name", name);
                request.setAttribute("feed", feed);
                //request.setAttribute("sname", sname);
                RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
                view.forward(request, response);


            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                request.setAttribute("warning", "you have already given your feedback Thank you..");
                RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
                view.forward(request, response);
                ex.printStackTrace();
            }
        } 
        else {

            request.setAttribute("msg", "please enter details");
            RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
            view.forward(request, response);
//            response.sendRedirect("Notice1.jsp");


        }
        
    }
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
