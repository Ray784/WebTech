<%@page import="java.sql.*"%>
<% 
    Statement st;
    ResultSet rs;
    int col_cnt;
    ResultSetMetaData rsmd;
    Connection con;
    try{
        org.postgresql.Driver driver=new org.postgresql.Driver();
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WT","postgres","cse");
        st=con.createStatement();

        Object id = request.getParameter("name");
        Object password = request.getParameter("pass");

        if(id!=null && password!=null){
            String sql = "SELECT * FROM users WHERE id = '"+((String)id)+"' AND password = '"+((String)password)+"'";
            rs=st.executeQuery(sql);
            if(rs.next()){
                response.sendRedirect("success.jsp?name="+((String)id));
            }
            else{
                out.println("Login Failed");
            }
        }
        st.close();
        con.close();
    }
    catch(Exception e){
        e.printStackTrace();
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