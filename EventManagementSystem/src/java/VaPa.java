import java.io.IOException;  
import java.io.PrintWriter;  
import jakarta.servlet.RequestDispatcher;  
import jakarta.servlet.ServletException;  
import jakarta.servlet.http.HttpServlet;  
import jakarta.servlet.http.HttpServletRequest;  
import jakarta.servlet.http.HttpServletResponse;  
  
  
public class VaPa extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    
    //Fetching data  from HTML form
    String n=request.getParameter("Pausername").trim();  
    String p=request.getParameter("Papassword").trim();  
          
    if(LoginDao.validate(n, p)){  
        RequestDispatcher rd=request.getRequestDispatcher("event-page.html");  
        rd.forward(request,response);  
    }  
    else{  
        out.println("<script>");
        out.println("function myFunction() {");
        out.println("    alert('Sorry Username or Password Incorrect');");
        out.println("}");
        out.println("myFunction();");
        out.println("</script>");
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
    out.close();  
  }  
}  