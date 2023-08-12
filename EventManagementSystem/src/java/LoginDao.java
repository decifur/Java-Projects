import java.sql.*;  
  
public class LoginDao {  
public static boolean validate(String USER_NAME,String PASS_WORD){  
boolean status=false;  
try{  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhi1234");
    PreparedStatement ps=con.prepareStatement("select * from indexdetails where USER_NAME=\'"+USER_NAME+"\' and PASS_WORD=\'"+PASS_WORD+"\'");   
    ResultSet rs=ps.executeQuery();  
    status=rs.next();
    con.close();
    }catch(Exception e){
        System.out.println(e);
    }  
    return status;  
  }  
}  
