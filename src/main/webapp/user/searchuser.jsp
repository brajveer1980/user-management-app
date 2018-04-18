<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.learning.user.model.*"%>

<% List<User> userList = (ArrayList)request.getAttribute("userListSessionAttr");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>User Management Application</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<link rel="stylesheet" type="text/css"
	href="/user-management-app/style/user.css">
</HEAD>
<BODY>
	<Div class="_container">
		<div class="_header">
			<%@ include file="../home.jsp"%>
		</div>
		<Div class="_subContainer">
			<form action="/user-management-app/saveUser.htm">
				<input type="hidden" name="useraction" value="searchuser">
				<div class="_field">
					<div class="_fieldText">User ID:</div>
					<div class="_fieldNameInput">
						<input type="text" name="userId">
					</div>
				</div>

				<div class="_field">
					<div class="_fieldText">User First Name:</div>
					<div class="_fieldNameInput">
						<input type="text" name="userFirstName">
					</div>
				</div>
				<div class="_field">
					<div class="_saveButton">
						<input type="Submit" value="Search">
					</div>
				</div>
			</form>
		</Div>
		<hr>
		<Div class="_subContainer">
		<% if(userList!=null && userList.size()>0){%>
		
			<table class=_table">
			<tr><td>User Id</td><td>User First Name</td><td>User Last Name</td><td>User Email</td><td>User Password</td></tr>
		<%
    for(int i=0; i<userList.size();i++){
    User user=userList.get(i);
    %>
				<tr>
					<td><%= user.getUserId() %></td>
					<td><%= user.getUserFirstName() %></td>
					<td><%= user.getUserLastName() %></td>
					<td><%= user.getUserEmail() %></td>
					<td><%= user.getUserPassword() %></td>
				</tr>
				<%}%>
			</table>
			<% }%>
		</Div>
	</Div>

</BODY>
</HTML>
