package com.admiin.man.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admiin.man.service.boardService;
import com.admiin.man.vo.BoardVO;
import com.admiin.man.vo.PagingVO;
import com.fasterxml.jackson.core.JsonProcessingException;

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
	
	@PostMapping("/board/boardView")
	public String boardView(@RequestParam(value = "boardIdx", required = false) int boardIdx) throws JsonProcessingException  {
		boardService.selectBoard(boardIdx);
		return "boardView";
	}
	
	@GetMapping("/board/boardInsert")
	public String boardInsert() {
		return "boardInsert";
	}
	
	@PostMapping("/board/boardInsert")
	public String boardInsertOk(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		return "redirect:/board/boardList";
	}
	
	
	@GetMapping("/board/boardDelete")
	public String boardDelete(@RequestParam(value = "boardIdx", required = false) int boardIdx) {
		boardService.deleteBoard(boardIdx);
		return "redirect:/boardList";
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
