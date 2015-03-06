<%-- 
    Document   : SignIn
    Created on : Mar 5, 2015, 12:51:04 PM
    Author     : Cole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel = "stylesheet" type = "text/css" href = "display.css" />
    </head>
    <body>
        <div id ="wrapper">
            <h1>Welcome</h1>
            <a href ="SignUp.jsp">Sign up buddy!</a>
            <form action ="VerifySignIn" method="POST">
                <input type ="text" name ="username"/> User Name<br/>
                <input type ="password" name ="password"/> Password<br/>
                <input type ="submit" value ="PUSH ME!"/>
            </form>
        </div>
    </body>
</html>
