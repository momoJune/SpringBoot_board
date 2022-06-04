package com.admiin.man.service;

import java.util.List;


import com.admiin.man.vo.BoardVO;
import com.admiin.man.vo.PagingVO;


public interface boardService {
	// 게시글 리스트 가져오기
	List<BoardVO> selectList();
	// 게시글 등록하기
	void insertBoard(BoardVO boardVO);
	// 게시글 수정
	void updateBoard(BoardVO boardVO);
	// 게시글 삭제
	void deleteBoard(int idxBoard);
	// 게시글 하나 가져오기
	BoardVO selectBoard(int idxBoard);
}
