import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServletd extends HttpServlet{
    Statement st;
	ResultSet rs;
	int col_cnt;
	ResultSetMetaData rsmd;
	Connection con;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            org.postgresql.Driver driver=new org.postgresql.Driver();
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WT","postgres","cse");
            st=con.createStatement();
            

            Object id = request.getParameter("name");
            Object password = request.getParameter("pass");

            PrintWriter out = response.getWriter();
            response.setContentType("text/html");

            if(id!=null && password!=null){
                String sql = "SELECT * FROM users WHERE id = '"+((String)id)+"' AND password = '"+((String)password)+"'";
                rs=st.executeQuery(sql);
                if(rs.next()){
                    out.println("<html><body>Login Successful<br>Welcome "+((String)id)+"</body></html>");
                }
                else{
                    out.println("Login Failed");
                    RequestDispatcher rd = request.getRequestDispatcher("login.html");
                    rd.include(request,response);
                }
            }
            else{
                response.sendRedirect("login.html");
            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}