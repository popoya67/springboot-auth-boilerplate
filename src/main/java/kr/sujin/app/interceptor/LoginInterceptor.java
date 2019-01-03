package kr.sujin.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.sujin.app.annotaion.AdminOnly;
import kr.sujin.app.annotaion.LoginRequired;
import kr.sujin.app.dto.User;
import kr.sujin.app.exception.AuthenticationException;
import kr.sujin.app.exception.AuthorizationException;

@Configuration
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			User sessionUser = (User) request.getSession().getAttribute("USER");
			if (hm.hasMethodAnnotation(LoginRequired.class) && sessionUser == null) {
				throw new AuthenticationException(request.getRequestURI());
			}
			if(hm.hasMethodAnnotation(AdminOnly.class) && sessionUser.getAuthority() != "ADMIN") {
				throw new AuthorizationException();
			}
		}
		return super.preHandle(request, response, handler);
	}
}
