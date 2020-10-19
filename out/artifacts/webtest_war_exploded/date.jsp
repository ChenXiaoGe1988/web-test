<%@ page import="java.time.LocalDateTime" %>
<html>
<body>
<h2>
    <%
        out.write(LocalDateTime.now().toString());
    %>
</h2>
</body>
</html>