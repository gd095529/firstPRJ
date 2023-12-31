package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");//사용자에게 보내는
		resp.setContentType("text/html; charset=UTF-8");//웹의 contentType를 내가 정할수있다.
		
		ServletContext application = req.getServletContext();//이어주는역할 이름 application객체
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		PrintWriter out = resp.getWriter();
		
		String v_ = req.getParameter("v");
		
		String op = req.getParameter("operator");
		int v =0;
		if(!v_.equals("")) v=Integer.parseInt(v_);
			
		//계산
		if(op.equals("=")) {
			
			//int x= (Integer)application.getAttribute("value");
			//int x= (Integer)session.getAttribute("value");
			int x =0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			int y= v;
			//String operator =(String)application.getAttribute("op");
			//String operator =(String)session.getAttribute("op");
			String operator ="";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;

			if(operator.equals("+")) {
				result = x+y;
			}else {
				result = x-y;
			}
			out.printf("result is : %d", result);
			
		}else {//값을저장
			
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			
			//session.setAttribute("value", v);
			//session.setAttribute("op", op);
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/add");
			opCookie.setPath("/add");
			
			resp.addCookie(valueCookie);
			resp.addCookie(opCookie);
		}
		
	}
}
