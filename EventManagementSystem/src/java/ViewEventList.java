import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class ViewEventList extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
      
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "system";
            String pass = "abhi1234";
            Connection con = DriverManager.getConnection(conURL, user, pass);
            
            response.setContentType("text/html");
            Statement stmt1 = con.createStatement();  
            ResultSet rp = stmt1.executeQuery("select * from Eventdetails"); 
                 
            
            out.println("<script>");
            out.println("document.addEventListener('DOMContentLoaded', function (){");
            out.println("var eventslist = document.getElementById('eventslist');");
            out.println("eventslist.innerHTML = '<table border=1 width=50% height=50%>';");  
            out.println("eventslist.innerHTML += '<tr><th>EventNumber</th><th>EventName</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>';");  
            while (rp.next()) 
            {  
                String n = rp.getString("EventNo");  
                String nm = rp.getString("EventName");  
                String co = rp.getString("coName");
                String cono  = rp.getString("coNum");
                String f = rp.getString("eventFee");
                String v = rp.getString("eventVenue");
                String d = rp.getString("eventDate");
                out.println("eventslist.innerHTML += '<tr><td>" + n + "</td><td>" + nm + "</td><td>" + co + "</td><td>" + cono + "</td><td>" + f + "</td><td>" + v + "</td><td>" + d + "</td></tr>';");
            }  
            con.commit();
            con.close(); 
            out.println("eventslist.innerHTML += '</table>';"); 
            out.println("});");
            out.print("</script>");
        } catch(Exception exe){System.out.println("Exception caught"+exe);}
    }
}
