package com.example.demo.controller.liked;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.db.liked.LikedDBManager;
import com.example.demo.service.liked.LikedService;


import lombok.Setter;


@Controller
@Setter
public class LikedController {

	@Autowired
	private LikedService likedService;
	
	
	
	/*
	 * @GetMapping("/Liked/likeList/{member_id}") public String
	 * findByIdandPlan(Model model, @PathVariable String member_id) {
	 * model.addAttribute("likedListPlan", likedService.findByIdandPlan(member_id));
	 * model.addAttribute("likedListTrip", likedService.findByIdandTrip(member_id));
	 * System.out.println(likedService.findByIdandTrip(member_id));
	 * 
	 * return "/Liked/likeList"; }
	 */
	
	@GetMapping("/liked/likeList/{member_id}")
	public ModelAndView list(@PathVariable String member_id) {
		ModelAndView mav = new ModelAndView("/liked/likeList");
		mav.addObject("likedListPlan", likedService.findByIdandPlan(member_id));
		mav.addObject("likedListTrip", likedService.findByIdandTrip(member_id));
		return mav;
	}
	
	
	
	
	
	@GetMapping("/liked/deleteLiked/{like_no}")
	@ResponseBody
	public int deleteLiked(@PathVariable String like_no) {
		int no = Integer.parseInt(like_no);
		System.out.println(like_no);
		int re = likedService.deleteLiked(no);
		
		return re;
	}
	
}
