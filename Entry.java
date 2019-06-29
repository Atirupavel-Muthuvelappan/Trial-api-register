package pack;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class Entry extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");


        HttpSession session=req.getSession(false);
        PrintWriter out=res.getWriter();
        out.print(req.getSession(false).getAttribute("name"));
        if(req.getSession(false).getAttribute("name")==null){
            res.sendRedirect("login.jsp");
        }

            String name = String.valueOf(session.getAttribute("name"));
            String method = req.getParameter("method")+" ";
            String req_head = req.getParameter("req_head")+" ";
            String content = req.getParameter("content")+" ";
            String res_head = req.getParameter("res_head")+" ";
            String body = req.getParameter("body")+" ";
            new Database(name).storeComment(method, req_head, content, res_head, body);
            out.println("your Uid is:" + new Database(name).checkUid());
            out.print("<form name=\"myForm\" action=\"\\welcome\" align=\"center\" method=\"post\">\n" +
                    "    uid: <input type=\"text\" name=\"uid\">\n" +
                    "    name: <input type=\"text\" name=\"name\">\n" +
                    "<input type=\"submit\">" +
                    "</form>");
            out.print("<form name=\"myForm\" action=\"\\signout\" align=\"center\" method=\"post\">\n" +
                    "<input type=\"submit\" value =\"signout\">" +
                    "</form>");

        }
    }