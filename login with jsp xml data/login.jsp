<% 
	String name = config.getInitParameter("name");
    String password = config.getInitParameter("pass");
    Object request1 = request.getParameter("name");
    Object request2 = request.getParameter("pass");
	if(request1 != null && request2 != null){
		
		if(((String)request1).equals(name) && ((String)request2).equals(password)){
            response.sendRedirect("success.jsp?name="+name);
        }
        else{
            out.println("<html><body>Login Failed</body></html>");
        }
    }
%>
<html>
    <body>
        <form method="POST" action="login">
            UserName: <input name="name" type="text" required><br>
            Password: <input name="pass" type="password" required><br>
            <input type="submit" type="submit" value="submit">
        </form>
    </body>
</html>