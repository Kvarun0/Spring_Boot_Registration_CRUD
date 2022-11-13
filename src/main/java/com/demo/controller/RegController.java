package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.RegisterVo;
import com.demo.service.RegisterService;

@Controller
public class RegController {

	@Autowired 
	private RegisterService registerService;
	
	@GetMapping(value="/")
	public ModelAndView loadRegister(){
		return new ModelAndView("registration", "RegisterVo", new RegisterVo());
	}
	@PostMapping(value = "insert")
	public ModelAndView insert(@ModelAttribute RegisterVo registerVo) {
		this.registerService.insert(registerVo);
		return new ModelAndView("redirect:/");
	}
	@GetMapping(value="search")
	public ModelAndView search(){
		List<RegisterVo> registerList=this.registerService.search();
		return new ModelAndView("search","registerList",registerList);
	}
	@GetMapping(value="delete")
	public ModelAndView delete(@ModelAttribute RegisterVo registerVo,@RequestParam int id){
		List<RegisterVo> registerList=this.registerService.findByid(id);
		registerVo =registerList.get(0);
		registerVo.setStatus(false);
		this.registerService.insert(registerVo);
		return new ModelAndView("redirect:/search");
	}
	@GetMapping(value="edit")
	public ModelAndView edit(@ModelAttribute RegisterVo registerVo,@RequestParam int id){
		List<RegisterVo> registerList=this.registerService.findByid(id);
		registerVo =registerList.get(0);
		return new ModelAndView("registration","RegisterVo",registerVo);
	}
	
}
