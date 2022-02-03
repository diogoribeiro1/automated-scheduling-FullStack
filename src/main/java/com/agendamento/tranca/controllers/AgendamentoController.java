package com.agendamento.tranca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agendamento.tranca.models.AgendamentoModel;
import com.agendamento.tranca.services.AgendamentoService;

@Controller
public class AgendamentoController {

	@Autowired
	private AgendamentoService service;
	
	@GetMapping("/agendar")
	public ModelAndView index() {	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/form");
		mv.addObject("agendamento", new AgendamentoModel());
		return mv;
	}
	
	@PostMapping("/agendar")
	public String createAgendamento(AgendamentoModel agendamento) {
		service.createAgendamento(agendamento);
		return "redirect:/agendar";
	}
}
