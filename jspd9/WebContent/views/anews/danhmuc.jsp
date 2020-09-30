<%@page import="models.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/anews/inc/header.jsp"%>
		
		<!-- end content -->
		<div id="content">
			<div class="content-left fl">
				<%@ include file="/views/anews/inc/sidebar.jsp"%>
			</div>
			<div class="content-right fr">
				<h3>Tin tức :: Thời sự</h3>
				<div class="main-content items-new">
					<ul>
					<%
						if(request.getAttribute("newList")!=null){
							ArrayList<News> newList=(ArrayList<News>)request.getAttribute("newList");
							for(News list:newList){
					%>
						<li>
							<h2>
								<a href="<%=request.getContextPath() %>/detail?id=<%=list.getId()%>" title=""><%=list.getName() %></a>
							</h2>
							<div class="item">
								<p><%=list.getDescription() %></p>
								<div class="clr"></div>
							</div>
						</li>
						<%		}
							} 
						%>
						
					</ul>
				</div>
			</div>
			<div class="clr"></div>
		</div>
		<!-- end content -->
		
<%@ include file="/views/anews/inc/footer.jsp"%>