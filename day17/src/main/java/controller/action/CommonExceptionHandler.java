package controller.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("controller.action")
public class CommonExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e) { // 하나하나 매핑
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e); // "" 안에 이름 그냥 정한것 
		mav.setViewName("exception/error.jsp");
		return mav;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) { // 전부 매핑
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("exception/error.jsp");
		return mav;
	}
	
}
