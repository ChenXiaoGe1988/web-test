import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * webtest:war exploded
 */
public class Demo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletConfig对象
        ServletConfig servletConfig = this.getServletConfig();
        //根据配置的名字获取值
        String value = servletConfig.getInitParameter("name");
        System.out.println(value);
        resp.getWriter().write("Demo1 success");
        //resp.getWriter().write(value);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init()方法已被调用！");
    }
}
