import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try{
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            String name = getServletConfig().getInitParameter("name");
            String password = getServletConfig().getInitParameter("pass");
            Object request1 = request.getParameter("name");
            Object request2 = request.getParameter("pass");
            if(request1 != null && request2 != null){
                if(((String)request1).equals(name) && ((String)request2).equals(password)){
                    out.println("<html><body>Login Successful<br> Welcome "+name+"</body></html>");
                }
                else{
                    out.println("<html><body>Login Failed</body></html>");
                    RequestDispatcher rd=request.getRequestDispatcher("login.html");  
                    rd.include(request, response);  
                }
            }
            else{
                response.sendRedirect("login.html");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}