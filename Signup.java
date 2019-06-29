package pack;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Signup extends HttpServlet {


    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        PrintWriter out=res.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name.equals("") || password.equals("") ){
            out.println("<h4>You did not enter username or password<h4>"); }

        HttpSession session =req.getSession();
        session.setAttribute("name",name);
        session.setAttribute("password",password);
        Cookie c1=new Cookie("sid" ,session.getId());
        res.addCookie(c1);
        out.println(" your session id "+session.getId());
        new Database(name,password).addUser();
     req.getRequestDispatcher("entry.jsp").forward(req,res);


    }
}