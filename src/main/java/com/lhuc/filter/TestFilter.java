package com.lhuc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 类描述：过滤器测试类1
 * 类名称：com.lhuc.filter.TestFilter
 * 创建人：slc
 * 创建时间：2022年4月12日 上午00:35:36
 *
 * @version V1.0
 */
@WebFilter(filterName = "/testFilter", urlPatterns = ("/*"))
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TestFilter1 init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TestFilter1 doFilter()");
        //在一个拦截器中调用doFilter是交给下一个拦截器执行
        chain.doFilter(request, response);
        System.out.println("TestFilter1 doFilter() 结束..");
    }

    @Override
    public void destroy() {

    }
}
