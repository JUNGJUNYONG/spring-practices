package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		System.out.println("index get");
		model.addAttribute("list",list);
		return "index";
	}

	@RequestMapping(value="",method = RequestMethod.POST)
	public String index(GuestbookVo vo,Model model) {
		System.out.println("index post");
		guestbookRepository.insert(vo);
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute(list);
		return "index";
	}
	
	@RequestMapping(value="/delete/{no}",method=RequestMethod.GET)
	public String delete(@PathVariable("no")Long no,Model model) {
		model.addAttribute("no", no);
		System.out.println("delete get");
		return "deleteform";
	}
	
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public String delete(GuestbookVo vo,Model model) {
		System.out.println("delete post");
		guestbookRepository.delete(vo);
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute(list);
		return "redirect:/";
	}
	

}
