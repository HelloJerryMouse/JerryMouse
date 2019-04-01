/**
 * 
 */
package com.lc.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.web.HttpRequest.HttpRequest;
import javax.web.HttpResponse.HttpResponse;
import javax.web.Servlet.Servlet;

import com.lc.test.entry.Student;

/**   
 * @ClassName:  MyServlet   
 * @Description:TODO(������һ�仰��������������)   
 * @author: �޳� 
 * @date:   2019��3��25�� ����4:20:31      
 */
public class MyServlet implements Servlet{

	/* (non-Javadoc)
	 * @see javax.web.Servlet.Servlet#Service(javax.web.HttpRequest.HttpRequest, javax.web.HttpResponse.HttpResponse)
	 */
	@Override
	public void Service(HttpRequest request, HttpResponse response) {
		
		String name=request.getParameter("name");
		
		String age=request.getParameter("age");
		Student student =null;
		if (name!=null) {
			 student =new Student(name, 0);
			 request.getHttpSession().setAttribue("student", student);
		}
		
		
		
		
		PrintWriter printWriter=null;
		try {
			printWriter=response.getPrintWriet();
			printWriter.print("<html>");
			printWriter.print("<head><title>hello</title><meta content='text/html;charset=utf-8'/></head>");
			printWriter.print("<body>");
			printWriter.print("<h1>JerryMouse</h1>");
			if (student!=null) {
				Student students=(Student)request.getHttpSession().getAttribute("student");
			printWriter.println("<p>Hello"+student.getName()+"session="+students.toString()+"����  GreenServer</p>");
			}
			printWriter.println("</body>");
			printWriter.print("</html>");
			printWriter.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			
			printWriter.close();
			
		}
		
		
	}
	
	

}
