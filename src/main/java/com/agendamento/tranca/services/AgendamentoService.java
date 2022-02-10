package com.agendamento.tranca.services;

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
	
	public AgendamentoModel createAgendamento(AgendamentoModel agendamento) {
		enviarMensagem(agendamento);
		return repository.save(agendamento);
	}

	private void enviarMensagem(AgendamentoModel agendamento) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("diogoribeiro698@gmail.com");
        message.setTo(agendamento.getEmail());
        message.setSubject("Agendamento Confirmado");
        message.setText(agendamento.toString());
        emailSender.send(message);
	}
}
