package com.agendamento.tranca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.tranca.models.AgendamentoModel;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long> {

}
