<%@page import="daos.CategoryDAO"%>
<%@page import="models.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>Danh mục tin</h3>
<ul>
<%
	ArrayList<Category> catList= new CategoryDAO().findAll();
	if (catList.size() > 0) {
		for(Category cat:catList){
%>
	<li><a href="<%=request.getContextPath() %>/indexcat?cat_id=<%=cat.getId() %>"><%=cat.getName()%></a></li>
<%
		}
	}

%>
</ul>