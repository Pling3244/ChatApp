package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Board;

public interface BoardService {
	
	public List<Board> getAllBoard() throws Exception;

	public String insertBoard(Board board) throws Exception;

    public Board getBoardDetail(String id) throws Exception;
    
    public String updateBoard(String id, Board board) throws Exception;

    public String deleteBoard(String id) throws Exception;

}
