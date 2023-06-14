package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bar;
import com.example.demo.service.BarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class BarController {

	@Autowired
	private BarService barService;
	
	@GetMapping("/getBarDetail")
    public Bar getBarDetail(@RequestParam String id) throws Exception {
           return barService.getBarDetail(id);
    }
}
