import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet222 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * req.getAttribute()和req.getParameter()的区别
         * 1.用途上
         *  req.getAttribute() : 一般用于获取request域对象的数据(在跳转之前把数据使用setAttribute来放到request对象上)
         *  req.getParameter()， 一般用于获取客户端提交的参数
         * 2.存储数据上
         *  req.getAttribute()可以获取Objcet对象
         *  req.getParameter()只能获取字符串(这也是为什么它一般用于获取客户端提交的参数)
         */
        //获取到存进request对象的值
        String username = (String) req.getAttribute("username");
        //浏览器输出
        resp.getWriter().write("i am : " + username); // i am : CodeChen
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
