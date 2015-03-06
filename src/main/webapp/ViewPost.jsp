<%-- 
    Document   : ViewPost
    Created on : Mar 5, 2015, 1:12:02 PM
    Author     : Cole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel = "stylesheet" type = "text/css" href = "display.css" />
    </head>
    <body>
        <div id ="wrapper">
            <h1>View Post Page</h1>
            <a href ="NewPostPage.jsp">Add More Posts!</a>
            <table>
                
                <c:forEach items="${posts}" var="post">
                    <tr>
                    <td>
                    <p>${post.text}</p>
                    <p>${post.username} <br/> ${post.date}</p>
                    </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
