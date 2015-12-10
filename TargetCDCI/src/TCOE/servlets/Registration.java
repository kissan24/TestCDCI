package TCOE.servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import TCOE.beans.RegistrationData;
import TCOE.utils.ConnectionManager;
import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registration</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registration at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        response.setContentType("text/html");
        RegistrationData regdata=new RegistrationData();
        
        
       Connection con=null;
       boolean bool=false;
        try {
            regdata.setUsername(request.getParameter("uname"));
            regdata.setPassword(request.getParameter("password"));
            regdata.setEmpId(Integer.parseInt(request.getParameter("empid")));

          ConnectionManager conman=new ConnectionManager();
               con= conman.createConnection(); 
            String qstring1 = "insert into register_i values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(qstring1);
            ps.setString(1, regdata.getUsername());
            ps.setString(2, regdata.getPassword());
            ps.setInt(3, regdata.getEmpId());
            
            
            ps.executeUpdate();
           
            ps.close();
            con.close();
            bool=true;
//            pw.println("<script>alert('submitted');</script>");


        }
         catch (Exception ex) {
          
            request.setAttribute("regerr", "Registration failed!!!");
                RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
                view.forward(request, response);
                ex.printStackTrace();
        }
        if(bool){
            request.setAttribute("regsucc", "Successfully Registered, Please login!!!");
                RequestDispatcher view = request.getRequestDispatcher("Notice.jsp");
                view.forward(request, response);
        }
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
