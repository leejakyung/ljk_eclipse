package controller.action;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/*
mvc네임스페이스덕에 @ControllerAdvice,@ExceptionHandler가 준비됨
@ControllerAdvice범위 비즈니스메서드수행중 예외발생시 @ExceptionHandler매핑호출됨
*/
// 예외 처리 클래스 - 어노테이션으로 적용하기
@ControllerAdvice("controller.action") // ("예외가 발생되는 비즈니스 메서드가 있는 클래스명")
public class CommonExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handlerNullPointerException(Exception e) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("excep/error.jsp");
		return mav;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception e) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("excep/error.jsp");
		return mav;

	}
}
