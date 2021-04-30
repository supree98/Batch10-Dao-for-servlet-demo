package com.tyss.gmail.signup;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.dao.Dao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Login() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			if(Dao.verify(username, password)) {
				response.sendRedirect("welcome.html");
			} else {
				response.sendRedirect("index.html");
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
	}


}
