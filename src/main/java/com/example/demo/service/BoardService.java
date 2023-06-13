package com.example.demo.service;

import com.example.demo.model.Board;

public interface BoardService {

	public String insertBoard(Board board) throws Exception;

    public Board getBoardDetail(String id) throws Exception;
    
    public String updateBoard(Board board) throws Exception;

    public String deleteBoard(String id) throws Exception;

}
