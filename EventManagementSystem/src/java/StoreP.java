
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Jitesh
 */
public class StoreP extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //fetching data from usersignup.html from user
        String up = request.getParameter("Pusername");
        String pp = request.getParameter("Ppassword");
        String cp = request.getParameter("Cpassword");
        String name = request.getParameter("Pname");
        
        String a1=up,a2=pp,a3=cp,a4=name;
        
        if(a2.equals(a3)){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                String user = "system";
                String pass = "abhi1234";
                Connection con = DriverManager.getConnection(conURL, user, pass);
                Statement stmt = con.createStatement();
                //SQL statment
                String Qs="insert into indexdetails values('"+a1+"','"+a2+"','"+a4+"') ";
                ResultSet rs=stmt.executeQuery(Qs);
                
                RequestDispatcher rd=request.getRequestDispatcher("index.html");
                rd.forward(request, response);
                con.close();
                
            }
            catch(Exception exe){
                System.out.println(exe);
            }
        }
        else
        {
            out.println("<script>");
            out.println("function myFunction() {");
            out.println("    alert('Confirm same password');");
            out.println("}");
            out.println("myFunction();");
            out.println("</script>");
            RequestDispatcher rd=request.getRequestDispatcher("usersignup.html");
            rd.include(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
