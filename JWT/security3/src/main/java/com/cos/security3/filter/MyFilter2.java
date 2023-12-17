//package com.cos.security3.filter;
//
//import jakarta.servlet.*;
//
//import java.io.IOException;
//
//public class MyFilter2 implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        System.out.print("필터2");
//        chain.doFilter(request, response); // 끝나지 말고 계속 진행이 되려면 chain에 다시 넘겨줘야 한다.
//    }
//}
