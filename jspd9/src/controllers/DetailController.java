package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.NewsDAO;
import models.News;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsDAO newsDAO=new NewsDAO();
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			News List= newsDAO.listDetail(id);
			request.setAttribute("List", List);
		}
		
			
		request.getRequestDispatcher("/views/anews/chitiet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
