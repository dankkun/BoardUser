package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus")
public class MenuController {
   
   @Autowired
   private  MenuMapper  menuMapper;
   
   // 메뉴 목록 조회  /Menus/List
   @RequestMapping("/List")   
   public   String   list( Model model ) {
      // 조회한결과를 ArrayList 로 돌려준디
      List<MenuVo> menuList = menuMapper.getMenuList();
      // 조회 결과를 넘겨준다 ( Model )
      model.addAttribute( "menuList", menuList );
      
      return "menus/list";
   }
   
   
   // 메뉴 입력받는 화면  /Menus/WriteForm
   //@RequestMapping("/Menus/WriteForm")
   @RequestMapping("/WriteForm")   // /Menus/WriteForm
   public   String   writeForm() {
      return "menus/write";  // /WEB-INF/views/ + menus/write + .jsp
   }
   
   @RequestMapping("/Write") 
   @ResponseBody
   public String write( MenuVo menuVo, Model model ) {
	
	   menuMapper.insertMenu( menuVo );
	   
	   String html = "<script>";
	   html += "alert('추가되었습니다');";
	   html += "location.href='/Menus/List';";
	   html += "</script>";
	   return html;
   }
   
   

   @RequestMapping("/WriteForm2")
   public String writeForm2() {
	   return "menus/write2";
   }
   
   @RequestMapping("/Write2")
   @ResponseBody
   public String write2( MenuVo menuVo ) {
	   menuMapper.insertMenuByName( menuVo );
	   
	   String html = "<script>";
	      html += "alert('추가되었습니다');";
	      html += "location.href='/Menus/List';";
	      html += "</script>";
	      return html;
   }
   
   
 
   // 삭제완료 알림창 기능 추가
   @RequestMapping("/Delete")
   @ResponseBody
   public String delete( MenuVo menuVo, Model model ) {
      
      // 삭제
      menuMapper.deleteMenu( menuVo );
      
      String html = "<script>";
      html += "alert('삭제되었습니다');";
      html += "location.href='/Menus/List';";
      html += "</script>";
      return html;
   }
   
   @RequestMapping("/UpdateForm")
   public String updateForm( MenuVo menuVo, Model model ) {
	   System.out.println("menuVo:" + menuVo);
	   String menu_id = menuVo.getMenu_id();	
	   MenuVo menu = menuMapper.getMenu( menu_id );
      
	   model.addAttribute("menu", menu);
	   
	   return "menus/update";    
   }
      
      @RequestMapping("/Update")
      public String update( MenuVo menuVo) {
    	  
    	  menuMapper.updateMenu(menuVo);
    	  return "redirect:/Menus/List";   
      }
}
