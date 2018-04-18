package com.learning.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.learning.user.bo.UserBO;
import com.learning.user.bo.UserBOImpl;
import com.learning.user.model.User;
import com.learning.user.utils.Constants;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = -4751096228274971485L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userAction = request.getParameter("useraction");

		System.out.println("userAction is " + userAction);
		HttpSession session = request.getSession();
		session.removeAttribute(Constants.USER_OPERATION_ERROR);
		session.removeAttribute(Constants.USER_SESSION_ATTR);
		User user=setUserProperties(request);
		if (StringUtils.isEmpty(userAction)) {
			response.sendRedirect(Constants.USER_CREATE_VIEW_PAGE);

		} else if (StringUtils.equalsIgnoreCase(Constants.USER_ACTION_SAVE, userAction)) {
			UserBO userBO = new UserBOImpl();
			try {
				user = userBO.saveUser(user);
				session.setAttribute(Constants.USER_SESSION_ATTR, user);
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute(Constants.USER_OPERATION_ERROR, "Error Creating User.");
			}
			response.sendRedirect(Constants.USER_CREATE_VIEW_PAGE);

		} else if (StringUtils.equalsIgnoreCase(Constants.USER_ACTION_SEARCH, userAction)) {
			UserBO userBO = new UserBOImpl();
			try {
				//user = userBO.saveUser(user);
				request.setAttribute(Constants.USER_LIST_SESSION_ATTR, userBO.searchUser(user));
			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute(Constants.USER_OPERATION_ERROR, "Error Searching User.");
			}
			request.getRequestDispatcher(Constants.USER_SEARCH_VIEW_PAGE).forward(request, response);
		} else {
			System.out.println("UserAction not implemented: " + userAction);
			response.sendRedirect(Constants.USER_CREATE_VIEW_PAGE);
		}

	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}

	private User setUserProperties(HttpServletRequest request) {
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setUserFirstName(request.getParameter("userFirstName"));
		user.setUserLastName(request.getParameter("userLastName"));
		user.setUserEmail(request.getParameter("userEmail"));
		user.setUserPassword(request.getParameter("userPassword"));
		return user;

	}
}
