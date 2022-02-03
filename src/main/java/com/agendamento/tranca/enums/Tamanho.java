package com.agendamento.tranca.enums;

public enum Tamanho {
	
	CHANNEL("Channel"),
	BUSTO("Busto"),
	CINTURA("Cintura"),
	QUADRIL("Quadril"),
	OUTROS("Outros");
	
	private String tamanho;

	private Tamanho(String tamanho) {
		this.setTamanho(tamanho);
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
}
