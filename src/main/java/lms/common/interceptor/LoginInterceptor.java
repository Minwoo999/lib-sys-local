package lms.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lms.model.MemberVO.LoginResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        LoginResponse loginResponse = (LoginResponse) session.getAttribute("loginUser");

        if (loginResponse == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");

            return false;
        }

        return true;

    }
}
