package pack;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Api  extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws NullPointerException, IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String url = request.getRequestURL().toString().trim();
        if (url.contains("https://servlets1.appspot.com/api/")) {
            String str[] = url.split("https://servlets1.appspot.com/api/");
            if (str.length <= 1) {
                out.print("Give a valid application name or domain");
            } else {
                Database db = new Database(str[str.length - 1].trim());
                String id = db.checkUid();

                if (!id.isEmpty()) {
                    try {
                        out.println("hello");
                        String details[] = db.fetchDetails(id);
                        out.println("your id is :"+id+"<br>");
                        out.println("method:"+details[1]+"<br>");
                        out.println("request-header:"+details[2]+"<br>");
                        out.println("content-type:"+details[3]+"<br>");
                        out.println("res_header"+details[4]+"<br>");
                        out.println("body"+details[5]+"<br>");
                      /*  request.setAttribute("method", details[1]);
                        request.setAttribute("request_header", details[2]);
                        request.setAttribute("content-type", details[3]);
                        request.setAttribute("response_header", details[4]);
                        request.setAttribute("body", details[5]);
                        request.getRequestDispatcher("entry.jsp").forward(request, response);
                    */} catch (NullPointerException e) {
                        System.out.print("null pointer exception" + e);
                    }
                } else {
                    out.println("no api found");
                }
            }
        }
    }}
