import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class AddEvent extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        PrintWriter out=response.getWriter();
        //Fetching data from HTML form
        String a1=request.getParameter("EventNo");
        String a2=request.getParameter("EventName");
        String a3=request.getParameter("coName");
        String a4=request.getParameter("coNum");
        String a5 =request.getParameter("eventFee");
        String a6=request.getParameter("eventVenue");
        String a7=request.getParameter("eventDate");
        
        //Connection to Database
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system";
            String pass = "abhi1234";
            Connection con = DriverManager.getConnection(conURL, user, pass);//Establish Connection
            
            Statement stmt=con.createStatement();
            String Qs="insert into Eventdetails values('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"') ";
            ResultSet rs=stmt.executeQuery(Qs);
                 
            RequestDispatcher rd=request.getRequestDispatcher("admin-addEvents.html");
            rd.include(request, response);
                 
            out.println("<script>");
            out.println("function myFunction() {");
            out.println("    alert('Event Added!');");  
            out.println("}");
            out.println("myFunction();");
            out.println("</script>");
            con.commit();
            con.close();
            }catch(Exception exe){System.out.println("Exception caught"+exe);}
        }
    }



