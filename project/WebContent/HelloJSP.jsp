<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%--BEGIN SETDATASOURCE --%>

<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/jwd_1718"
	user="root"
	password="1234"
/>
<%--End setDataSource --%>

<%--BEGIN QUERY --%>
<sql:query var="items" sql="SELECT * FROM Items"/>
<%--End query --%>

<table>
	<c:forEach items="${items.rows}" var="row">
	<%--tr --%>
		<c:forEach items="${row}" var="col">
			<tr>
				<td>${col.key }</td><td>${col.value}</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>