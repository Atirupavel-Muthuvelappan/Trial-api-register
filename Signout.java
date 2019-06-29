package pack;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class Signout  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   HttpSession session= req.getSession(false);
   Cookie c1=new Cookie("sid" ,"null");
   resp.addCookie(c1);
   session.setAttribute("name",null);
   session.invalidate();

       if( req.getSession(false)==null){

        req.getRequestDispatcher("login.jsp").include(req, resp);
            }
    }
}
