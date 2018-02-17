import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig(location = "/home/limeng/git/Web/Servlet/uploadServlet/download")
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Part part = request.getPart("photo");
        String filename = getFilename(part);
        part.write(filename);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>结果</title>");
        out.print("</head>");

        out.print("<body>");
        out.print("<h1>上传成功！！！</h1>");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }

    private String getFilename(Part part){
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"")+10,
                header.lastIndexOf("\""));
        return filename;
    }
}