package com.lhuc.filter;


import com.lhuc.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="/loginFilter", urlPatterns =("/*"))
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("进入了登陆验证filter...");
        //获取session参数值 --用户名和密码
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String userName = (String)httpRequest.getSession().getAttribute("userName");
        String password = (String)httpRequest.getSession().getAttribute("password");
        if(StringUtils.isNotNull(userName)&&StringUtils.isNotNull(password)){
            //如果不为空，就证明我们在这个回话过程中登陆过，不需要再次验证用户名和密码
            System.out.println("通过session验证...");
            //把请求和响应传给过滤链中的下一个调用者或servlet
            chain.doFilter(httpRequest, httpResponse);
        }else{//如果为空，则表示此会话没有登陆过系统，重新跳转到登陆页面，提示用户的登陆
            System.out.println("session验证没通过.转入登陆页面..");
            chain.doFilter(httpRequest, httpResponse);
//            httpResponse.sendRedirect("/studyJsp/login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
