package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");//사용자에게 보내는
		resp.setContentType("text/html; charset=UTF-8");//웹의 contentType를 내가 정할수있다.
		
		//req.setCharacterEncoding("UTF-8");//톰캣에서 입력값을 얻어올때 방식
		
		PrintWriter out = resp.getWriter();//out이라는 이름으로 응답 저장
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		out.print(title);
		out.print(content);
	}
}
