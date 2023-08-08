//package com.tinqin.rest.config;
//
//import java.io.IOException;
//
//import jakarta.servlet.*;
//import org.springframework.stereotype.Component;
//@Component
//public class RequestLoggingFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        // Initialization code, if needed
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        // Log the request details here
//        System.out.println("Request received: " + request.getRemoteAddr() + " " +  " " + request.getRemoteHost() + " " + request.getRemotePort());
//
//        // Continue the filter chain
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // Cleanup code, if needed
//    }
//}
