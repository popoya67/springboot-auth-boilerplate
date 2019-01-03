package kr.sujin.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import kr.sujin.app.exception.AuthenticationException;
import kr.sujin.app.exception.InvalidAccountException;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler({ AuthenticationException.class, InvalidAccountException.class })
	public ModelAndView authException(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login/login");
		mv.addObject(e.getClass() == InvalidAccountException.class ? "errorMsg" : "orgRequestUrl", e.getMessage());
		return mv;
	}

}
