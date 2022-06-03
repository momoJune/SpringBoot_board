package com.admiin.man.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.admiin.man.dao.BoardDAO;
import com.admiin.man.vo.BoardVO;

@Transactional
@Service("boardService")
public class boardServiceImpl implements boardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectList() {
		List<BoardVO> boardVOList = null;
		boardVOList =  boardDAO.selectList();
		return boardVOList;
	}

	@Override
	public void insertBoard(BoardVO boardVO) {
		
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(int idxBoard) {
		boardDAO.deleteBoard(idxBoard);
	}

	@Override
	public BoardVO selectBoard(int idxBoard) {
		BoardVO boardVO = new BoardVO();
		if(idxBoard != 0) {
			boardVO = boardDAO.selectBoard(idxBoard);
		}
		return boardVO;
	}
	

}
