import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        //ServletContext servletContext = this.getServletContext();
        //通过关键字获取存储在域对象中的值
        //String value = (String) servletContext.getAttribute("MyName");
        //System.out.println(value);

        ServletContext servletContext = this.getServletContext();
        //通过名称获取值
        String value = servletContext.getInitParameter("name");
        System.out.println(value);
        resp.getWriter().write("Demo3 success");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
