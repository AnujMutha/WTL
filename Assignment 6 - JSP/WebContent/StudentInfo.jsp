<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Students Information</title>
	<style>
		*{
		font-family: Product Sans;
		}
		table{
			text-align: center;
			corner-radius:5px;
			border-collapse: collapse;
		    margin: 25px 0;
		    font-size: 0.9em;
		    min-width: 400px;
		    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
		}
		table thead tr {
		    background-color: #009879;
		    color: #ffffff;
		    text-align: left;
		}
	    table th,td {
		    padding: 12px 15px;
		}
		table tbody tr {
    		border-bottom: 1px solid #dddddd;
		}
		
		table tbody tr:nth-of-type(even) {
		    background-color: #f3f3f3;
	    	color: #009879;
		}
		
		table tbody tr:last-of-type {
		    border-bottom: 2px solid #009879;
		}
		
}
		
	</style>
</head>
<body>
    
    <%
    out.print("<h1><center>Student Records</center></h1>");
    	try{
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/wtl_assignment_6","Anuj","Anuj 16 @ MySql");
    		Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from students_info");
            out.print("<center>");
            out.println("<table>");
            out.println("<tr><thead><th>ID</th><th>NAME</th><th>DIVISION</th><th>CITY</th></thead></tr>");
            out.print("<tbody>");
            while(rs.next())
            {
                
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getString(4)+"</td>");
                out.println("</tr>");
                
            }
            out.print("</tbody>");
            out.println("</table>");
            out.print("</center>");
            con.close();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    %>

</body>

</html>