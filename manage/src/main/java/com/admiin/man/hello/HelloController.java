package com.admiin.man.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admiin.man.service.boardService;
import com.admiin.man.vo.BoardVO;
import com.admiin.man.vo.PagingVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloController {
	
	@Autowired
	private boardService boardService;
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "index";
	}
	
	@RequestMapping("/board/boardInsert")
	public String boardInsert() {
		return "boardInsert";
	}
	
	@RequestMapping("/board/boardList")
	public String boardList(Model model) {
		log.info("board/boardList boardList 컨트롤러");
		List<BoardVO> boardList = null;
		boardList = boardService.selectList();
		model.addAttribute("boardList", boardList);
		log.info("board/boardList boardList 컨트롤러4");
		return "boardList";
	}
	
}
