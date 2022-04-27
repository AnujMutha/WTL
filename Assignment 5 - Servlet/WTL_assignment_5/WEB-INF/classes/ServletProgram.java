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

            out.println(" <style>");
            out.println(" html, body {");
            out.println("     font-family: Arial, Helvetica, sans-serif;");
            out.println("     height: 100%;");
            out.println("     background-color: #a9ffc2;");
            out.println("     color: white;");
            out.println(" }");

            out.println(" html {");
            out.println("     display: table;");
            out.println("     margin: auto;");
            out.println(" }");

            out.println(" body {");
            out.println("     display: table-cell;");
            out.println("     vertical-align: middle;");
            out.println(" }");
            out.println(" td{");
            out.println("     padding: 5px;");
            out.println(" }");
            out.println(" label{");
            out.println("     font-size: 20px;");
            out.println("     font-weight: bold;");
            out.println(" }");
            out.println(" tr{");
            out.println("     background-color: #b585fc;");
            out.println("     padding: 7px;");
            out.println(" }");
            out.println("th{padding:7px;}");
            out.println(" table{ border:1px solid black;");
            out.println("</style>");

        out.println("<html><body>");
        out.println("<center><h1>Book Records</h1></center>");
        out.println("</body></html>");

        String id=req.getParameter("book_id");
        if(id.equals("All")){
            id="select * from book_details";
        }else{
            id="select * from book_details where book_id="+id;
        }
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wtl_assignment_4","Anuj","Anuj 16 @ MySql");
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery(id);
            out.println("<table>");
            out.println("<tr><th>Book ID</th><th>Book Name</th><th>Author Name</th><th>Price</th></tr>");

            while(rs.next())
            {
         
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("</tr>");
                
            }
            out.println("</table>");
            con.close();
         }catch(Exception e){
             out.println(e);
         }

        out.close();
    }
}