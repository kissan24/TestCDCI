package TCOE.servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ignite403
 */


   import java.io.*;

public class DisplayImage extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
	response.setContentType("image/jpeg");
	ServletOutputStream out;
	out = response.getOutputStream();
	FileInputStream fin = new FileInputStream("C:\\Documents and Settings\\ignite403\\Desktop\\A2-Avengers\\A2-Avengers\\web\\image\\kishan&abhishek.jpg");
	
	BufferedInputStream bin = new BufferedInputStream(fin);
	BufferedOutputStream bout = new BufferedOutputStream(out);
	int ch =0; ;
	while((ch=bin.read())!=-1)
	{
	bout.write(ch);
	}
	
	bin.close();
	fin.close();
	bout.close();
	out.close();
	}
	}

