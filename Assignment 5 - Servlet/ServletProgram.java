import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class ServletProgram extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello World</h1>");
        out.println("</body></html>");

        String id=req.getParameter("book_id");
        out.println("<table><tr><th>Book ID</th><th>Book Name</th><th>Author Name</th><th>Price</th></tr></table>");
         try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/wtl_assignment_4","Anuj","Anuj 16 @ MySql");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from book_details where book_id="+id);
            while(rs.next())
            {
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("</tr>");
                out.println("</table>");
            }
            con.close();
         }catch(Exception e){
             out.println(e);
         }

        out.close();
    }
}