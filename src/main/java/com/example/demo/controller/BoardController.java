package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/insertBoard")
    public String insertBoard(@RequestParam String writter, String title, String content, String user_count, String bar_name, String bar_addr) throws Exception {
		Board board = new Board();
		board.setWritter(writter);
		board.setTitle(title);
		board.setContent(content);
		board.setUser_count(user_count);
		board.setBar_name(bar_name);
		board.setBar_addr(bar_addr);
           return boardService.insertBoard(board);
    }

    @GetMapping("/getBoardDetail")
    public Board getBoardDetail(@RequestParam String id) throws Exception {
           return boardService.getBoardDetail(id);
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@RequestParam String id, String writter, String title, String content, String user_count, String bar_name, String bar_addr) throws Exception {
    	Board board = new Board();
		board.setWritter(writter);
		board.setTitle(title);
		board.setContent(content);
		board.setUser_count(user_count);
		board.setBar_name(bar_name);
		board.setBar_addr(bar_addr);
           return boardService.updateBoard(id, board);
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam String id) throws Exception {
           return boardService.deleteBoard(id);
    }
}
