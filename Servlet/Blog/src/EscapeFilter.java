import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class EscapeFilter implements Filter{

    public void init(FilterConfig fConfig) throws ServletException{}

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException,ServletException{
        HttpServletRequest requestWrapper = new EscapeWrapper((HttpServletRequest)request);
        chain.doFilter(requestWrapper,response);
    }

    public void destroy() {}
}
