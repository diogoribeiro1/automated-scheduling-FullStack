package com.agendamento.tranca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.agendamento.tranca.models.AgendamentoModel;
import com.agendamento.tranca.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	@Autowired
	AgendamentoRepository repository;
	
	@Autowired
	JavaMailSender emailSender;
	
	public AgendamentoModel createAgendamento(AgendamentoModel agendamento)  {
		sendMessage(agendamento);
		return saveAgendamento(agendamento);
	}
	
	public AgendamentoModel saveAgendamento(AgendamentoModel agendamento) {
		return repository.save(agendamento);
	}
	
	public void deleteByIdAgendamento(Long codigo)  {
		 repository.deleteById(codigo);			
	}
	
	public List<AgendamentoModel> findAllAgendamento(){
		return repository.findAll();
	}
	
	public List<AgendamentoModel> findByNomeContainingIgnoreCase(String nome) {
		return repository.findByNomeContainingIgnoreCase(nome);
	}
	
	public AgendamentoModel findByCodigo(Long codigo) {
		return repository.findByCodigo(codigo);
	}
	
	public AgendamentoModel findByData(AgendamentoModel agendamento) {
		return repository.findByData(agendamento.getData());
	}

	private void sendMessage(AgendamentoModel agendamento) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("diogoribeiro698@gmail.com");
        message.setTo(agendamento.getEmail());
        message.setSubject("Agendamento Confirmado");
        message.setText(agendamento.toString());
        emailSender.send(message);
	}
}
