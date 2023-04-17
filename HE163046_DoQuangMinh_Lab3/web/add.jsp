<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : add
    Created on : Apr 16, 2023, 10:20:25 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${student!=null}">
        <form action="update" method="POST">
            <input hidden type="text" name="id" value="${student.getId()}" /> 
            Name: <input type="text" name="name"value="${student.getName()}" /><br>
            Gender:
            <input type="radio" name="gender" value="male" <c:if test="${student.isGender()==true}">
                   checked
                   </c:if> /> Male
            <input type="radio" name="gender" value="female" <c:if test="${student.isGender()!=true}">
                   checked
                   </c:if>/>Female <br>
            DOB:<input type="date" name="dob"  value="${student.getDob()}" /><br>
            <input type="submit" value="update" />
        </form>
    </c:if>
    <c:if test="${student==null}">
        <form action="add" method="POST">
            
            Name: <input type="text" name="name" /> <br>
            Gender:
            <input type="radio" name="gender" value="male" /> Male
            <input type="radio" name="gender" value="female" />Female <br>
            DOB:<input type="date" name="dob"  /><br>
            <input type="submit" value="Create" />
        </form>
    </c:if>
        
        
    </body>
</html>
