package controller.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import model.board.BoardService;
import model.board.BoardVO;

// 어노테이션을 사용함으로써 인터페이스 상속을 제거하는 의의
// 1. 완벽한 POJO 클래스가 된다!
// 2. 추상 메소드의 강제성에서 벗어남 (오버라이딩 X) -> 함수의 input, output, 함수명 변경을 자유롭게 변경할 수 있다!

//높은 응집도를 위한 컨트롤러 통합
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("sm")
	public Map<String, String> searchMap() {
		Map<String, String> sm = new HashMap<String, String>();
		sm.put("제목", "title");
		sm.put("내용", "content");
		sm.put("작성자", "id");
		return sm;
	}
	
	@RequestMapping("/searchBoard.do")
	public String searchBoard(BoardVO vo, Model model) throws Exception {		
		List<BoardVO> datas =  boardService.getBoardList(vo);
		model.addAttribute("datas", datas);
		return "main.jsp";
	}
	
	@RequestMapping("/main.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		List<BoardVO> datas = boardService.getBoardList(vo); // 게시글 전체 조회
		model.addAttribute("datas", datas); // 정보 저장 - setAttribute의 역할
		return "main.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		BoardVO data = boardService.getBoard(vo);		
		model.addAttribute("data", data);
		return "readBoard.jsp";
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(HttpServletRequest request, BoardVO vo) throws Exception {		
		boardService.insertBoard(vo);
		return "redirect:main.do";
	}

}
