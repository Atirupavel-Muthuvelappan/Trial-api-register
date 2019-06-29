package pack;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, NullPointerException, ServletException {
        response.setContentType("text/html");

PrintWriter out=response.getWriter();
        Cookie cookie[]= request.getCookies();
        out.println("hi "+cookie[0].getValue());
            if(request.getSession(false).getAttribute("name")==null){
            response.sendRedirect("login.jsp");
        }
String id= request.getParameter("uid");
        String name=request.getParameter("name");
        Database db = new Database(name);
        String uid=db.checkUid();
        if(uid.equals(id)){
        if(!id.isEmpty()) {
            String details[] = db.fetchDetails(id);
            request.setAttribute("method",details[1]);
            request.setAttribute("request_header",details[2]);
            request.setAttribute("content-type",details[3]);
            request.setAttribute("response_header",details[4]);
            request.setAttribute("body",details[5]);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }}
        else
            {
            out.println("no api found");
        }
        out.print("<form name=\"myForm\" action=\"\"Signout\"  method=\"post\">\n" +

                "<input type=\"submit\" value =\"signout\">"+
                "</form>");
    }}