import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class ValidateAd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
       PrintWriter out = response.getWriter();
       String un = request.getParameter("Ausername"); //fetch admin username
       String pw = request.getParameter("Apassword"); //fetch admin password
       response.setContentType("text/html");
       
       // SET ADMIN DETAILS
       String ad1 = "decifur";
       String adpwd1 = "0707";
       
       String ad2 = "admin";
       String adpwd2 = "admin";
       
       //Checking Entries
       
       if(pw.equals(adpwd1) && un.equals(ad1)){
           RequestDispatcher rd = request.getRequestDispatcher("admin-events.jsp");
           rd.forward(request, response);
       }
       else if(pw.equals(adpwd2) && un.equals(ad2)){
           RequestDispatcher rd = request.getRequestDispatcher("admin-events.jsp");
           rd.forward(request, response);
       }
       else{
           out.println("<script>");
           out.println("function myFunction() {");
           out.println("    alert('Enter Valid Username & Password');");
           out.println("}");
           out.println("myFunction();");
           out.println("</script>");
           RequestDispatcher rd = request.getRequestDispatcher("adminlogin.html");
           rd.include(request, response);
       }
       out.close();
    }
}
