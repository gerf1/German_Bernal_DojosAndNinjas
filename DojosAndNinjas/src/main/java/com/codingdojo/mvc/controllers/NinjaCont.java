package com.codingdojo.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.mvc.models.Ninja;
import com.codingdojo.mvc.services.DojoNinjaServ;



@Controller
public class NinjaCont {
	private final DojoNinjaServ dojoNinjaServ;
	
	public NinjaCont(DojoNinjaServ dojoNinjaServ) {
		this.dojoNinjaServ = dojoNinjaServ;
	}

	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninjaObject") Ninja Ninja, Model model) {
		model.addAttribute("dojos", dojoNinjaServ.getAllDojos());
		return "/views/newninja.jsp";
	}
	
	@PostMapping("/addninja")
	public String addNinja(@Valid @ModelAttribute("ninjaObject") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/views/newninja.jsp";
		}
		else {
			dojoNinjaServ.addNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId() ;
		}
	}
}