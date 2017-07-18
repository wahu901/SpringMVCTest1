<%-- 
    Document   : customer
    Created on : 2017/5/25, 上午 09:26:44
    Author     : Wayne.Hu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
    </head>
 
    <body>
       Customer List
 
        <hr><ol> 
       <c:forEach items="${customerList}" var="customer">
		${customer.name} 
		<br />
	</c:forEach>
        </ol><hr>
 
       
     </body>
 </html>
