package com.agendamento.tranca.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agendamento.tranca.models.AgendamentoModel;
import com.agendamento.tranca.services.AgendamentoService;

@Controller
public class AgendamentoController {

	@Autowired
	private AgendamentoService service;

	@GetMapping("/agendar")
	public String indexForm(Model model) {
		model.addAttribute("agendamento", new AgendamentoModel());
		return "home/form";
	}

	@PostMapping("/agendar")
	public String createAgendamento(@Valid AgendamentoModel agendamento, BindingResult br, RedirectAttributes attributes) {
		String [] textoSeparado = agendamento.getData().split("-");
		agendamento.setMes(textoSeparado[1]);
		
		if (service.findByData(agendamento) != null) {
			attributes.addFlashAttribute("msg", "Data já cadastrada! "+ agendamento.getData());
			return "redirect:/agendar";
		} else {
			service.createAgendamento(agendamento);
			return "redirect:/";
		}
	}
	
	@GetMapping("/listagendamentos")
	public ModelAndView listaAgendamentos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/lista_agendamentos");
		Iterable<AgendamentoModel> agendamento = service.findAllAgendamento();
		mv.addObject("agendamento", agendamento);
		return mv;
	}
	
	@GetMapping("/delete/{codigo}")
	public String deleteAgendamento(@PathVariable("codigo")Long codigo) {
		service.deleteByIdAgendamento(codigo);	
		return "redirect:/listagendamentos";
	}
	
	@GetMapping("/{codigo}")
	public String updateAgendamento(@PathVariable("codigo")Long codigo, Model model) {
		AgendamentoModel agendamento = service.findByCodigo(codigo);
		model.addAttribute("agendamento", agendamento);
		return "home/update_agendamento";
	}
	
	@PostMapping("/update")
	public String updateAgendamento(AgendamentoModel agendamento) {
			service.saveAgendamento(agendamento);
			return "redirect:/listagendamentos";
		}
	}
	
	

