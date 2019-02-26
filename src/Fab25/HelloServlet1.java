package Fab25;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@javax.servlet.annotation.WebServlet(name = "HelloServlet1")
public class HelloServlet1 extends javax.servlet.http.HttpServlet {
    //초기화 파라미터
    String appName = null;
    String dbUser = null;
    String dbPass = null;

    String servletName = null;
    String description = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        //init : 서블릿 초기화 - 서블릿이 첫번째 요청을 받을 때
        super.init(config);//삭제하지 맙시다.

        System.out.println("[LifeCycle] init");

        //컨텍스트 초기화 파라미터
        ServletContext context = getServletContext();
        appName = context.getInitParameter("appName");
        dbUser = context.getInitParameter("dbUser");
        dbPass = context.getInitParameter("dbPass");

        System.out.println("Application Name : " + appName);
        System.out.println("DBUSER : " + dbUser);
        System.out.println("DBPASS : " + dbPass);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //service : 요청 메서드와 상관없이 요청을 처리
        System.out.println("[LifeCycle] service");

        //서블릿 초기화 파라미터 읽어오기
        ServletConfig config = getServletConfig();
        servletName = config.getInitParameter("servletName");
        description = config.getInitParameter("description");

        System.out.println("ServletName : " + servletName);
        System.out.println("Description : " + description);

        //특정 메서드에 관련된 작업을 수행하고자 할 때
        //분기 처리
        System.out.println("METHOD : " + req.getMethod());
        if (req.getMethod().equals("GET")) {
            doGet(req, resp);
        } else if (req.getMethod().equals("POST")) {
            doPost(req, resp);
        }
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //요청 정보의 인코딩 변환
        request.setCharacterEncoding("UTF-8");
        System.out.println("[LifeCycle] doPost");

        //POST 요청 처리
//        String lastName = request.getParameter("Last_name");
//        String firstName = request.getParameter("First_name");

        //출력
//        response.setCharacterEncoding("UTF-8"); //필터 출력을 위해 잠시 주석처리
//        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println("<h1>폼 데이터 처리</h1>");
//        writer.println("last_name : " + lastName);
//        writer.println("first_name : " + firstName);

        //request 객체 조금 더 알아보기
        writer.println("<ul>");
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            String paramValue = request.getParameter(paramName);

            writer.printf("<li>%s : %s</li>", paramName, paramValue);
        }

        writer.println("</ul>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //GET 요청 처리
        System.out.println("[LifeCycle] doGet");
        String name = request.getParameter("name");
        if (name == null) {
//            name = "Anonymous";
            throw new ServletException("누구?"); // 오류를 던져줌
        }
        //응답 출력
//        response.setCharacterEncoding("UTF-8"); //필터 출력을 위해 잠시 주석처리
//        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello Servlet</h1>");
        writer.printf("<p>Welcome, %s</p>", name);
    }

    @Override
    public void destroy() {
        System.out.println("[LifeCycle] destroy");
        super.destroy();
    }
}
