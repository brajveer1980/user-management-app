package com.learning.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LearningJava extends HttpServlet {

	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		System.out.println("In learning java...");
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Learning java is not fun :(</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}

}
