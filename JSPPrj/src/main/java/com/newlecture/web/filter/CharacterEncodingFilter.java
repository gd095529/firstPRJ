package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req,
			ServletResponse resp,
			FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("j");
		req.setCharacterEncoding("UTF-8");//모든 서블릿이 실행전에 시작
		
		chain.doFilter(req, resp);//필터 이후 관할
		System.out.println("j");

	}

}
