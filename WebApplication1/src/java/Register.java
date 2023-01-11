import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import p1.Enc_box ;

@WebServlet(urlPatterns = {"/Register"})

public class Register extends HttpServlet {
  	 
   
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
        	throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    

    	try
    	{   	 
        	p1.Enc_box eb = new Enc_box();
       	 
        	String user,pass,name;

 
        	user=request.getParameter("user");
        	pass=request.getParameter("pass");
        	name = request.getParameter("name");
                  	 
   
      	 
        	Class.forName("org.apache.derby.jdbc.ClientDriver");
        	Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/sample",
                	"app",
                	"app");
        	PreparedStatement ps = c.prepareStatement("insert into USERS values(?,?,?)");

  	 
        	if (request.getParameter("mono")!=null)
        	{
                ps.setString(1,Enc_box.encrypt(user));
        	ps.setString(2,Enc_box.encrypt(name));
        	ps.setString(3,Enc_box.encrypt(pass));
           	int i = ps.executeUpdate();
        	 
           	}
                if (request.getParameter("ver")!=null)
        	{
                ps.setString(1,Enc_box.encrypt_v(user,"shaktiman"));
        	ps.setString(2,Enc_box.encrypt_v(name,"shaktiman"));
        	ps.setString(3,Enc_box.encrypt_v(pass,"shaktiman"));
           	int i = ps.executeUpdate();
        	 
           	}

    	}
    	catch(Exception e){
        	out.print(e);
    	}
	}

 
 
}
