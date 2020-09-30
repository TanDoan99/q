<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/anews/inc/header.jsp"%>
		
		<!-- end content -->
		<div id="content">
			<div class="content-left fl">
				<%@ include file="/views/anews/inc/sidebar.jsp"%>
			</div>
			<div class="content-right fr">
				<h3>Liên hệ</h3>
			 <%
				 String msg = (String) request.getParameter("msg");
			 	if("1".equals(msg)) out.print("<h3 style='color: green; font-weight: bold;'>Đã thêm thành công!</h3>");
			 %>
			 <h3 style="color: red">${err}</h3>
				<div class="main-content">
					<form  action="<%=request.getContextPath() %>/contact" method="post"enctype="multipart/form-data"class="frmContact">
						<p>Vui lòng điền đầy đủ các thông tin liên hệ sau: </p>
						<div class="row">
							<label>Họ tên: </label>
							<input type="text" name="name" value="${name}" />
						</div>
						<div class="row">
							<label>Số điện thoại: </label>
							<input type="text" name="phone" value="${phone}" />
						</div>
						<div class="row">
							<label>Website: </label>
							<input type="text" name="web" value="${web}" />
						</div>
						<div class="row">								
							<label>Giới tính: </label>
							<select name="gender">
								<option value="-1">-- Chọn giới tính --</option>
								<option value="1">Nam</option>
								<option value="0">Nữ</option>
							</select>
							
						</div>
						<div class="row">
							<label>Ảnh đại diện: </label>
							<input type="file" name="picture" value="" />
						</div>
						<div class="row">
							<label>Nội dung: </label>
							<textarea name="content" value="${content}"></textarea>
						</div>
						<div class="row">
							<input type="submit" name="submit" value="Gửi liên hệ" />
							<input type="reset" name="reset" value="Nhập lại" />
						</div>
					</form>
				</div>
			</div>
			<div class="clr"></div>
		</div>
		<!-- end content -->
		
<%@ include file="/views/anews/inc/footer.jsp"%>