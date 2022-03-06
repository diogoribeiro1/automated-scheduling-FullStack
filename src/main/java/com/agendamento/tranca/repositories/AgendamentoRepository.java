package com.agendamento.tranca.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agendamento.tranca.models.AgendamentoModel;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

	AgendamentoModel findByCodigo(Long codigo);
	
	@Query("select i from AgendamentoModel i where i.data = :data")
	public AgendamentoModel findByData(String data);
		
	public List<AgendamentoModel> findByNomeContainingIgnoreCase(String nome);
}
