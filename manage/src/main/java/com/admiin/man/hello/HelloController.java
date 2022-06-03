package com.admiin.man.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.admiin.man.service.boardService;
import com.admiin.man.vo.BoardVO;
import com.admiin.man.vo.PagingVO;

@Controller
public class HelloController {
	
	@Autowired
	private boardService boardService;
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "index";
	}
	
	@RequestMapping("/board/boardList")
	public String boardList(Model model) {
		
		List<BoardVO> boardList = null;
		boardList = boardService.selectList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
}
