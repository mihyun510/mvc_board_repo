package mvc.board;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BoardController extends MultiActionController {
	Logger logger = Logger.getLogger(BoardController.class);
	public BoardLogic boardLogic = null;

	//setter 객체 주입법 필요한 시점에 객체를 주입받을 수 있다.
	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	//ModelAndView: 스프링에서 제공하는 클래스 이므로 임포트해서 사용하기
	//이 클래스를 스프링으로 부터 객체주입을 받기 위해서 xml에 등록하자.
	public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) { //req, res을 전달받지 않았지만 이용이 가능하다. (스프링 이용)
		logger.info("ModelAndView boradList 호출성공");
		List<Map<String, Object>> bList = boardLogic.boardList();
		ModelAndView mav = new ModelAndView();//여기서는 ModelAndView는 스프링에서 전해주는 타입
		// ==>/WEB-INF/jsp/board/boardList.jsp
		// ==>/WEB-INF/jsp/boardList.jsp.jsp
		mav.setViewName("board/boardList"); //이렇게 값을 주는 이유는 servlet.xml에 이렇게 정의를 해놨음 폴더/페이지 이름 xml에는 jsp까지는 만들어놓음.
		mav.addObject("bList", bList); // 이게 포워드임?
		return mav;
	}
	public void boardList2(HttpServletRequest req, HttpServletResponse res) { 
		logger.info("ModelAndView boradList2 호출성공"); //webContent아래로 간다.
		try {
			res.sendRedirect("board/boardList.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
