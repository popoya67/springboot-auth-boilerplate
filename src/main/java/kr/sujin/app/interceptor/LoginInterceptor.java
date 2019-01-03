package kr.sujin.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.sujin.app.annotaion.LoginRequired;
import kr.sujin.app.exception.AuthenticationException;

@Configuration
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			if (hm.hasMethodAnnotation(LoginRequired.class) && request.getSession().getAttribute("USER") == null) {
				throw new AuthenticationException(request.getRequestURI());
			}
		}
		return super.preHandle(request, response, handler);
	}
}
