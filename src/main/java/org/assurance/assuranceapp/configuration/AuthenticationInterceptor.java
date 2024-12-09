//package org.assurance.assuranceapp.configuration;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//public class AuthenticationInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object user = request.getSession().getAttribute("loggedInUser");
//        if (user == null) {
//            response.sendRedirect(request.getContextPath() + "/utilisateur/login");
//            return false;
//        }
//        return true;
//    }
//
//
//}
