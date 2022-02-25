package com.agendamento.tranca.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.agendamento.tranca.enums.Tamanho;
import com.agendamento.tranca.enums.TipoTranca;

@Entity
public class AgendamentoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "local")
	private String local;

	@Column(name = "data")
	private String data;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	@Email
	private String email;

	@Column(name = "horario")
	private String horario;

	@Column(name = "tipoTranca")
	@Enumerated(EnumType.STRING)
	private TipoTranca tipoTranca;

	@Column(name = "tamanho")
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	
	@Column(name = "mes")
	private String mes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public TipoTranca getTipoTranca() {
		return tipoTranca;
	}

	public void setTipoTranca(TipoTranca tipoTranca) {
		this.tipoTranca = tipoTranca;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	@Override
	public String toString() {
		return "Datas Agendadas = " + data;
	}
}
