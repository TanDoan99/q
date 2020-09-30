package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.NewsDAO;
import models.News;
@WebServlet("/indexcat")
public class IndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewsDAO newsDAO=new NewsDAO();
		if (request.getParameter("cat_id") != null) {
			int cat_id = Integer.parseInt(request.getParameter("cat_id"));
			ArrayList<News> newList= newsDAO.tinTuc(cat_id);
			request.setAttribute("newList", newList);
		}
		
			
		request.getRequestDispatcher("/views/anews/danhmuc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
