package controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import daos.ContactDAO;
import models.Contact;

@WebServlet("/contact")
@MultipartConfig
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DIR_UPLOAD = "images" + File.separator + "tmp";
	public ContactController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/anews/lienhe.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone");
		String web = request.getParameter("web");
		String gender = request.getParameter("gender");
		String content = request.getParameter("content");
		request.setAttribute("name", name);
		request.setAttribute("phone", phone1);
		request.setAttribute("web", web);
		request.setAttribute("gender", gender);
		if (name == "") {
			request.setAttribute("err", "vui lòng nhập tên!");
			request.getRequestDispatcher("/views/anews/lienhe.jsp").forward(request, response);
			return;
		}
		if (phone1 == "") {
			request.setAttribute("err", "vui lòng nhập số điện thoại!");
			request.getRequestDispatcher("/views/anews/lienhe.jsp").forward(request, response);
			return;
		}
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		if (web == "") {
			request.setAttribute("err", "vui lòng nhập trang web của bạn!");
			request.getRequestDispatcher("/views/anews/lienhe.jsp").forward(request, response);
			return;
		}
		
		String fileName = "";

		Part filePart = request.getPart("picture");
		String fileType=request.getContentType();
		fileName = filePart.getSubmittedFileName();// lấy tên thư mục gốc

		try {

			if(fileType.startsWith("image")) {
				throw new Exception();
			}
			String contextRoot = request.getServletContext().getRealPath("");
			String dirUpload = contextRoot + DIR_UPLOAD;
			File saveDir = new File(dirUpload);
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmss");
			String fname = sdf.format(date);
			String firstName = fileName.split("\\.")[0];
			String lastName = fileName.split("\\.")[1];
			fileName = firstName + "_" + fname + "." + lastName;

			String filePath = dirUpload + File.separator + fileName;
			filePart.write(filePath);
		} catch (Exception e) {
			request.setAttribute("err", "Vui lòng chọn file hình ảnh!!!");
			request.getRequestDispatcher("/views/anews/lienhe.jsp").forward(request, response);
			return;
		}
		System.out.println(fileName);
		request.setAttribute("picture", fileName);
		request.setAttribute("content", content);
		
		if (content== "") {
			request.setAttribute("err", "vui lòng nhập nội dung!");
			request.getRequestDispatcher("/views/anews/lienhe.jsp").forward(request, response);
			return;
		}
		Contact objAdd=new Contact(name, phone, web, gender, fileName, content);
		if(ContactDAO.addItem(objAdd)>0) {
			// Thêm thành công
						response.sendRedirect(request.getContextPath()+"/contact?msg=1");
						return;

		}else {
			// Thêm thất bại
			request.setAttribute("err", "Thêm liên hệ thất bại!");
			request.getRequestDispatcher("/views/anews/lienhe.jsp").forward(request, response);
			return;
		}
	}

}
