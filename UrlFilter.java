package pack;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

public class UrlFilter  implements Filter  {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);

        /*    PrintWriter out=response.getWriter();
        if(request instanceof HttpServletRequest) {
            String url = ((HttpServletRequest)request).getRequestURL().toString().trim();
           if(url.contains("http://localhost:8080/api/")){
String str[]=url.split("http://localhost:8080/api/");
if(str.length<=1){out.print("Give a valid application name or domain");}
else {
    Database db = new Database(str[str.length - 1].trim());
String id=db.checkUid();
out.println(id);
if(!id.isEmpty()) {
    String details[] = db.fetchDetails(id);
    request.setAttribute("method","krjgkl");
    request.setAttribute("request_header",details[2]);
    request.setAttribute("content-type",details[3]);
    request.setAttribute("response_header",details[4]);
    request.setAttribute("body",details[5]);
    Cookie c=new Cookie("hello","hi");


}
else{
out.println("no api found");
}  chain.doFilter(request, response);
out.println("flterer");}}

 */      }


        @Override
        public void destroy () {

        }

    }