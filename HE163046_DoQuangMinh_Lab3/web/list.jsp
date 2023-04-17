<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : list
    Created on : Apr 19, 2022, 10:09:49 AM
    Author     : AD
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <h1> Student List </h1>
    <br/>
        <%
            ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
        %>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>
                    ID
                </td>
                <td>
                    Name
                </td>
                <td>
                    Gender
                </td>
                <td>
                    DOB
                </td>
                <td>
                    Action
                </td>
            </tr>
            <c:forEach var="st" items="${students}">
                        <tr>
                            <td>${st.getId()}</td>
                            <td>${st.getName()}</td>
                            <td>${st.isGender()}</td>
                            <td>${st.getDob()}</td>
                            <td><a href="getinfo?id=${st.getId()}">update</a> 
                                &nbsp;
                                <a href="delete?id=${st.getId()}">delete</a></td>
                        </tr>
                    </c:forEach>
        </table>
        <a href="add.jsp">Create</a>
    </body>
</html>