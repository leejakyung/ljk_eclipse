package controller.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("controller.action")
public class CommonExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(Exception e) { // �ϳ��ϳ� ����
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e); // "" �ȿ� �̸� �׳� ���Ѱ� 
		mav.setViewName("exception/error.jsp");
		return mav;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) { // ���� ����
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception",e);
		mav.setViewName("exception/error.jsp");
		return mav;
	}
	
}
