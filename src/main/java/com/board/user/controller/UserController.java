package com.board.user.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.user.domain.UserVo;
import com.board.user.mapper.UserMapper;

@Controller
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
@RequestMapping("/List")
public ModelAndView list() {
	List<UserVo> userList = userMapper.getUserList();
	ModelAndView mv = new ModelAndView();
	mv.addObject( "userList", userList );
	mv.setViewName("users/list");
	return mv;
}

@RequestMapping("/WriteForm")
public ModelAndView writeForm() {
	ModelAndView mv     = new ModelAndView();
	LocalDateTime today = LocalDateTime.now(); 
	String now = today.format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss:SSSS"));
	DayOfWeek wkday = today.getDayOfWeek();
	now  += " " + wkday;
	mv.addObject("now", now);
	mv.setViewName("users/write");
	return mv;
}

@RequestMapping("/Write")
public ModelAndView write( UserVo userVo ) {
	userMapper.insertUser( userVo );
	ModelAndView mv = new ModelAndView();
	mv.setViewName("redirect:/users/list");
	return mv;
}
}

