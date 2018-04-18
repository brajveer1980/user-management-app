<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>User Management Application</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<link rel="stylesheet" type="text/css" href="../style/user.css">
</HEAD>
<BODY>
	<Div class="_container">
	<div class="_header">
	<%@ include file="../home.jsp" %>
	</div>
		<Div class="_subContainer">
			<form action="/user-management-app/saveUser.htm">
			<input type="hidden" name="useraction" value="saveuser">
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
					<div class="_fieldText">User Last Name:</div>
					<div class="_fieldNameInput">
						<input type="text" name="userLastName">
					</div>
				</div>
				
				<div class="_field">
					<div class="_fieldText">User Email:</div>
					<div class="_fieldNameInput">
						<input type="text" name="userEmail">
					</div>
				</div>
				
				<div class="_field">
					<div class="_fieldText">User Password:</div>
					<div class="_fieldNameInput">
						<input type="text" name="userPassword">
					</div>
				</div>
				
				<div class="_field">
					<div class="_saveButton">
						<input type="Submit">
					</div>
				</div>
			</form>
		</Div>
	<hr>
	</Div>

</BODY>
</HTML>
