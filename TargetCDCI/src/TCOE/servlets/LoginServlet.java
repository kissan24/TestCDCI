package TCOE.servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import TCOE.beans.SignInData;
import TCOE.utils.ConnectionManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ignite403
 */
public class LoginServlet extends HttpServlet {

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
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /*
//             * TODO output your page here. You may use following sample code.
//             */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LoginServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
//    }

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            request.getSession().invalidate();
        response.sendRedirect("Notice.jsp");
        
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SignInData sgnData=new SignInData();
        sgnData.setUsername(request.getParameter("uname").trim());
        sgnData.setPassword(request.getParameter("password").trim());
       
        
        Connection con=null;
          try {
        	  ConnectionManager conman=new ConnectionManager();
              con= conman.createConnection(); 
              
                String rquery1 = "select * from register_i where name= '"+ sgnData.getUsername() +"' and password='"+ sgnData.getPassword() +"'";
                PreparedStatement ps;
                ps = con.prepareStatement(rquery1);
                ResultSet rs=ps.executeQuery();
                HttpSession session =request.getSession(false);
                
                
                if(rs.next() && sgnData.getUsername().equalsIgnoreCase((rs.getString("name"))) && sgnData.getPassword().equalsIgnoreCase(rs.getString("password"))){
                   session.setAttribute("name1", rs.getString("name"));
                RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
                view.forward(request, response);
                    
                }else{
                    request.setAttribute("msgs", "Invalid login");
                RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
                view.forward(request, response);
                }
                
                ps.close();
                con.close();
//                request.setAttribute("name", name);
//                request.setAttribute("feed", feed);
                
                

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //request.setAttribute("warning", "you have already given your feedback Thank you..");
                RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
                view.forward(request, response);
                ex.printStackTrace();
            }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
}
