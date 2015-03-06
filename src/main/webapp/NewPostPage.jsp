<%-- 
    Document   : NewPostPage
    Created on : Mar 5, 2015, 1:06:03 PM
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
            <h1>New Post Page</h1>
            <a href ="LoadPost">View Posts</a><br/>
            <form id ="myForm" action ="CreatePost" method ="POST">
                <textarea name ="text" form ="myForm"></textarea><br/>
                <input type ="submit" value ="PUSH ME BRO"/>
            </form>
        </div>
    </body>
</html>
