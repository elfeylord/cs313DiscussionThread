<%-- 
    Document   : SignUp
    Created on : Mar 6, 2015, 8:43:54 AM
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
            <h1>Sign Up!</h1>
            <form action ="SignUp" method="POST">
                <input type ="text" name ="username"/> User Name<br/>
                <input type ="password" name ="password"/> Password<br/>
                <input type ="submit" value ="PUSH ME and BE HAPPY!"/>
            </form>
        </div>
    </body>
</html>
