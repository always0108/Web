import org.apache.commons.lang3.StringEscapeUtils;
import javax.servlet.http.HttpServletRequestWrapper;

public class EscapeWrapper extends HttpServletRequestWrapper{
    public EscapeWrapper(HttpServletRequestWrapper request){
        super(request);
    }

    @Override
    public String getParameter(String name){
        String value = getRequest().getParameter(name);
        return StringEscapeUtils.escapeHtml4(value);
    }

}
