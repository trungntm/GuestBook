<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<fmt:requestEncoding value="UTF-8" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>GuestBook</title>
</head>
<body>
	<h2>Guest Book</h2>
		<!-- connect databse -->
		<sql:setDataSource var="data"
			driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
			url="jdbc:sqlserver://localhost:1433; instance=MSSQLSERVER; databaseName=GuestBook; user=login; password=12345678;"/>
			
		<sql:query dataSource="${data}" var="result">
         	select * from dbo.Guest;
        </sql:query>
		<table border='1'>
		  	<thead>
				<tr>
				  <th>ID</th>
				  <th>Name</th>
				  <th>Message</th>
				  <th colspan='2'>Option</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${result.rows}">
					<tr>
						<td>${row.ID}</td>
						<td>${row.Name}</td>
						<td>${row.Message}</td>
						<td>
							<form action="${pageContext.request.contextPath}/UpdateGuestBook?id=${row.ID}&Name=${row.Name}&Mess=${row.Message}" method="post">
								<input type="submit" name="edit" value="Edit">						
							</form>
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/DeleteGuestBook?id=${row.ID}" method="post">
								<input type="submit" name="delete" value="Delete">						
							</form>
						</td>
					</tr>
				</c:forEach>	
			</tbody>	
		</table>
		<p><a href='AddCommentWithDB'>Add Comment</a></p>
</body>
</html>