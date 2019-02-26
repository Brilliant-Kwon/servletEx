package Fab26.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[Filter] init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("[Filter] doFilter");

        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = servletResponse.getWriter();
        writer.println("<h4>필터 적용 전</h4>");
        // 필터 체인에 다음 필터 적용
        filterChain.doFilter(servletRequest, servletResponse);
        // 필터 체인 적용 후 작업
        writer.println("<h4>필터 적용 후</h4>");


    }

    @Override
    public void destroy() {
        System.out.println("[Filter] destroy");
    }
}
