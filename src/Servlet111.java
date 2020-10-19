import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

public class Servlet111 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到ServletContext对象
        //ServletContext servletContext = this.getServletContext();
        //调用ServletContext方法获取到读取文件的流
        //InputStream inputStream = servletContext.getResourceAsStream("bg.png");
        //resp.getWriter().write("Servlet111 success");

        //获取OutputStream
        //ServletOutputStream servletOutputStream = resp.getOutputStream();
        //向浏览器输出数据
        //servletOutputStream.print("HelloWorld"); //输出中文字符串会出现500异常
        //resp.getOutputStream().write("bbb".getBytes()); //bbb
        //resp.getOutputStream().write("陈科秉".getBytes()); // 正常显示
        //resp.getOutputStream().write("陈科秉".getBytes("UTF-8")); //乱码

        //设置头信息，告诉浏览器我回送的数据编码是utf-8的
        //resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        //resp.getOutputStream().write("陈科秉".getBytes("UTF-8")); //正常显示

        //获取OutputStream
        //ServletOutputStream servletOutputStream = resp.getOutputStream();
        //使用meta标签模拟http消息头，告诉浏览器回送数据的编码和格式
        //servletOutputStream.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
        //servletOutputStream.write("使用meta标签模拟http消息头测试成功".getBytes());

        //设置成UTF-8编码格式
        //resp.setCharacterEncoding("UTF-8");
        //告诉浏览器用UTF-8输出显示数据 --> 最简便的方法
        //resp.setContentType("text/html;charset=UTF-8");
        //resp.getWriter().write("Bug无处不在");

        /**
         * 实现图片文件下载
         */
        //1.获取资源路径
        //String path = this.getServletContext().getRealPath("/download/bg.png");
        //2.读取对象
        //FileInputStream fileInputStream = new FileInputStream(path);
        //3.获取到文件名 , 路径在电脑上保存是\\形式的
        //String fileName = path.substring(path.lastIndexOf("\\") + 1);
        //4.设置消息头，告诉浏览器，我要下载这个图片
        //resp.setHeader("Content-Disposition","attachment;filename=" + fileName);
        //4.1设置消息头，告诉浏览器，我要下载这个图片 并且解决中文图片名乱码问题
        //resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        //5.把读取到的资源写给浏览器
//        int len = 0;
//        byte[] bytes = new byte[1024];
//        //获取OutputStream
//        ServletOutputStream servletOutputStream = resp.getOutputStream();
//
//        while ((len = fileInputStream.read(bytes))>0) {
//            servletOutputStream.write(bytes, 0 ,len);
//        }
//        //关闭资源
//        servletOutputStream.close();
//        fileInputStream.close();

        /**
         * 实时自动刷新 以规定的时间让页面自动刷新，更新资源
         */
        //每3秒自动刷新网页一次
//        resp.setHeader("Refresh","3");
//        //加入时间值补充效果
//        resp.getWriter().write("time is : " + System.currentTimeMillis());

        //实现登录成功，3秒后自动跳转
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.getWriter().write("3秒后跳转页面......");
//        //3秒后跳转到index.jsp页面中去
//        resp.setHeader("Refresh","3;url='/ychen/index.jsp");

        /**
         * 实现数据压缩
         */
//        resp.setContentType("text/html;charset=UTF-8");
//        String ss = "fsdfhsdfhuisdhfusdhfuids" +
//                "fsdfdsfsdfsdfdsfdafdsfhsdjfhsdjkfhkjds" +
//                "fdsfjdslkfjsldkfjsdlkfjsdkfsdjkff" +
//                "fsjdfjdsklfjdsklfjkldsfjlksdjflksdjflkds" +
//                "dsjfklsdjflsdjfkldsfkjsdkfjsldkfjsdlfk" +
//                "fdsjlkfjdslkfjsdlkfjlkasjflk";
//        //resp.getWriter().write("原来的长度是：" + ss.getBytes().length + "</br>");
//        //输出给浏览器
//        //resp.getWriter().write(ss);
//
//        //使用GZIP类对数据进行压缩
//        //创建GZIPOutputStream对象，给予它ByteArrayOutputStream
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
//        ///GZIP对数据压缩，GZIP写入的数据是保存在byteArrayOutputStream上的
//        gzipOutputStream.write(ss.getBytes());
//        //把缓冲清了 并关闭流
//        gzipOutputStream.close();
//        //取出压缩的数据
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        //告诉浏览器这是gzip压缩的数据
//        resp.setHeader("Content-Encoding","gzip");
//        //读取压缩后的长度
//        //将压缩的数据写给浏览器
//        resp.getOutputStream().write(bytes);
//        System.out.println("压缩后的长度为：" + bytes.length);

        /**
         * 生成随机图片
         * 随机生成验证码
         */
//        //在内存中生成一张图片,宽为80,高为20，类型是RGB
//        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
//        //获取到这张图片
//        Graphics graphics = bufferedImage.getGraphics();
//        //往图片设置颜色和字体
//        //graphics.setFont(new Font(null,Font.BOLD,20));
//        graphics.setColor(Color.WHITE);
//        //graphics.fillRect(0, 0, 80, 20);
//        //往图片上写数据 横坐标是0 纵坐标是20
//        graphics.drawString("9933",0,20);
//        //要往浏览器写一张图片，那要告诉浏览器回送的类型是一张图片
//        resp.setHeader("ContentType","jpeg");
//        //java提供了图片流给我们使用，这是一个工具类
//         //把图片传进去，类型是jpg，写给浏览器
//        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());


        //重定向到index.jsp页面
        //resp.sendRedirect("/ychen/index.jsp");
        //设置状态码为302
        //resp.setStatus(302);
        //HttpServletResponse把常用的状态码封装成静态常量了，所以我们可以使用SC_MOVED_TEMPORARILY代表着302
        //resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        //跳转的地址是data.jsp页面
        //resp.setHeader("Location","/ychen/index.jsp");

        /**
         * 防盗链
         */
//        //获取到网页是哪里来的
//        String referer = req.getHeader("Referer");
//        //如果不是从我的首页或者从地址栏直接访问的
//        if(referer == null || !referer.contains("localhost:8080/Ychen/index.jsp")) {
//            //回到首页去
//            resp.sendRedirect("/ychen/index.jsp");
//            return;
//        }
//        //能执行下面的语句，说明是从我的首页点击进来的，那没问题，照常显示
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.getWriter().write("你看个der！！！");


//        /**
//         * 表单提交数据
//         *
//         */
//        //设置request字符编码的格式
//        req.setCharacterEncoding("UTF-8");
//        //通过html的属性 获取到值
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String gender = req.getParameter("gender");
//
//        //复选框和下拉框有多个值，获取到多个值
//        String[] hobbies = req.getParameterValues("hobbies");
//        String[] address = req.getParameterValues("address");
//
//        //获取到文本域的值
//        String description = req.getParameter("textarea");
//        //得到隐藏域的值
//        String hiddenValue = req.getParameter("aaa");
//        System.out.println("用户名：" + username);
//        System.out.println("密码：" + password);
//        System.out.println("性别：" + gender);
//        System.out.println("爱好：" + Arrays.toString(hobbies));
//        System.out.println("来自于：" + Arrays.toString(address));
//        System.out.println("详细说明：" + description);
//        System.out.println("隐藏域的值：" + hiddenValue);
//        /**OutInput
//         * 用户名：ychen
//         * 密码：123456
//         * 性别：on
//         * 爱好：[柳活]
//         * 来自于：[长沙]
//         * 表单测试说明
//         * my name is ychen
//         */

        /**
         * 超链接方式提交数据
         */
//        String username = req.getParameter("username");
//        System.out.println(username); //xxx
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
