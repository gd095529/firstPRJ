package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");//사용자에게 보내는
		resp.setContentType("text/html; charset=UTF-8");//웹의 contentType를 내가 정할수있다.
		
		PrintWriter out = resp.getWriter();
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String op = req.getParameter("operator");
		int x =0;
		int y =0;
		
		int result = 0;
		
		if(!x_.equals("")) x=Integer.parseInt(x_);
		if(!y_.equals("")) y=Integer.parseInt(y_);
		
		if(op.equals("덧셈")) {
			result = x+y;
		}else {
			result = x-y;
		}
		
		out.printf("result is : %d", result);
		
	}
}
