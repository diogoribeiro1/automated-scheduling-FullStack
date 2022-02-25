package com.agendamento.tranca.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.agendamento.tranca.models.AgendamentoModel;
import com.agendamento.tranca.services.AgendamentoService;

@Controller
public class AgendamentoController {

	@Autowired
	private AgendamentoService service;

	@GetMapping("/agendar")
	public ModelAndView indexForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/form");
		mv.addObject("agendamento", new AgendamentoModel());
		return mv;
	}

	@PostMapping("/agendar")
	public String createAgendamento(@Valid AgendamentoModel agendamento, BindingResult br, RedirectAttributes attributes) {
		String [] textoSeparado = agendamento.getData().split("-");
		agendamento.setMes(textoSeparado[1]);
		
		if (service.buscarpelaData(agendamento) != null) {
			attributes.addFlashAttribute("msg", "Data já cadastrada! "+ agendamento.getData());
			return "redirect:/agendar";
		} else {
			service.createAgendamento(agendamento);
			return "redirect:/agendar";
		}
	}
	
	@GetMapping("/agendamentos")
	public ModelAndView listaAgendamentos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home/Agendamentos");
		Iterable<AgendamentoModel> agendamento = service.listaAgendamento();
		mv.addObject("agendamento", agendamento);
		return mv;
	}
	
	@GetMapping("/deletarAgendamento/{codigo}")
	public String deletarAgendamento(@PathVariable("codigo")Long codigo) {
		service.deleteAgendamento(codigo);	
		return "redirect:/agendamentos";
	}
	
	@GetMapping("/confirmarAgendamento/{codigo}")
	public String confirmarAgendamento(@PathVariable("codigo")Long codigo) {
		service.confirmaAgendamento(codigo);
		return "redirect:/agendamentos";
	}
	
	@PostMapping("/agendamentoss")
	public ModelAndView pesquisarAgendamento(@RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView();
		List<AgendamentoModel> listaAgendamento;
		if(nome == null || nome.trim().isEmpty()) {
			listaAgendamento = service.listaAgendamento();
		}else {
			listaAgendamento = service.findByNomeContainingIgnoreCase(nome);
		}
		mv.addObject("ListaDeAgendamento", listaAgendamento);
		mv.setViewName("home/pesquisa");
		return mv;
	}	
	
}
