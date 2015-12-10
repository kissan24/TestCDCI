package TCOE.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TCOE.dao.GetOnlineMembers;
import TCOE.dao.getFishComments;

/**
 * Servlet implementation class OnlineMember
 */
//@WebServlet("/OnlineMember")
public class OnlineMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlineMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("onlmem");

            if ("LetsChat".equalsIgnoreCase(action)) {
                response.setContentType("application/json");

                out.print(new GetOnlineMembers().allOnlineMembers("Yes"));

            }
        } finally {
            out.close();
        }
	}
	
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("onlmem");

            if ("LetsChat".equalsIgnoreCase(action)) {
                response.setContentType("application/json");

                out.print(new GetOnlineMembers().allOnlineMembers("Yes"));

            }
        } finally {
            out.close();
        }
	}

}
