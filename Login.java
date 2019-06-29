package pack;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
       try{ if(req.getSession(false).isNew() | (req.getSession(false).getAttribute("name")!=null)){
            out.println("you are already signed in");
            req.getRequestDispatcher("login.jsp").forward(req,res);
        }}catch (NullPointerException e){
           System.out.println("null pointer exception occured" +e);
       }
        if (name.equals("") || password.equals("")) {
                out.println("<h4>You did not enter username or password<h4>");
                req.getRequestDispatcher("login.jsp").forward(req, res);
            } else {
                String arr[] = new Database(name, password).check();
                String n = arr[0];
                String p = arr[1];
                if(name.equals(n) ) {
                    if (!password.equals(p)) {
                        out.println("your password is incorrect");
                    } else {

                        HttpSession session = req.getSession(true);
                        session.setAttribute("name", n);
                        session.setAttribute("password", p);

                        Cookie c1 = new Cookie("sid", session.getId());
                        res.addCookie(c1);
                        out.println(" your session is " +session.getId());
                        req.getRequestDispatcher("entry.jsp").include(req, res);
                    }
                }
                else {out.println("<h4>Your name was not found<h4>");
                req.getRequestDispatcher("signup.jsp").forward(req,res);
                }
                }
            }
        }





