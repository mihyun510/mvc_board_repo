package mvc.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	public List<Map<String, Object>> boardList(){
		logger.info("boardList호출 성공");
		List<Map<String, Object>> bList = new ArrayList<Map<String,Object>>();
		return bList;
	}
}
