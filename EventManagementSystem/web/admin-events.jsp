
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Event Details</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/remixicon@3.5.0/fonts/remixicon.css" rel="stylesheet">
        <link rel="stylesheet" href="event-style.css">
    </head>
    <body>
        <div id="nav">
            <a href="index.html">Event Details</a>
            <div id="right-tab">
                <a href="admin-addEvents.html" id="reg-event"><button>Create Event</button></a>
                <a href="index.html"><button><i class="ri-logout-box-r-line"></i></button></a>
            </div>
        </div>
        <div id="main">
            <div id="user-signup">
                <div id="heading">
                    <h1>Event Details</h1>
                </div>
                <div id="eventslist">
                    <table border="1" width="50%" height="50%">
                        <tr>
                            <th>Event No.</th>
                            <th>Event Name</th>
                            <th>Coordinator</th>
                            <th>Contact</th>
                            <th>Fees</th>
                            <th>Venue</th>
                            <th>Date</th>
                        </tr>
                        <%       
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            String conURL = "jdbc:oracle:thin:@localhost:1521:xe";
                            String user = "system";
                            String pass = "abhi1234";
                            java.sql.Connection con = java.sql.DriverManager.getConnection(conURL, user, pass);
                            System.out.println("after connection");
                            response.setContentType("text/html");
                            java.sql.Statement stmt1 = con.createStatement();  
                            java.sql.ResultSet rp = stmt1.executeQuery("select * from Eventdetails"); 
                            while (rp.next()) {  
                                String n = rp.getString("EventNo");  
                                String nm = rp.getString("EventName");  
                                String co = rp.getString("coName");
                                String cono  = rp.getString("coNum");
                                String f = rp.getString("eventFee");
                                String v = rp.getString("eventVenue");
                                String d = rp.getString("eventDate");
                        %>
                        <tr>
                            <td><%= n %></td>
                            <td><%= nm %></td>
                            <td><%= co %></td>
                            <td><%= cono %></td>
                            <td><%= f %></td>
                            <td><%= v %></td>
                            <td><%= d %></td>
                        </tr>
                        <%
                            }  
                            con.close(); 
                        } 
                        catch(Exception exe){
                            System.out.println("Exception caught" + exe);
                        }
                        %>
                    </table>
                </div>
                
            </div>
        </div>
    </body>
</html>
