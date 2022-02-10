package com.agendamento.tranca.enums;

public enum TipoTranca {
	
	BOXBRAIDS("Box Braids"),
	TWIST("Twist"),
	NAGO("Nagô"),
	BOXEADORA("Boxeadora"),
	ENTRELACE("Entrelace"),
	STITCHBRAIDS("Entrelace"),
	FULANIBRAIDS("Fulani Braids");
	
	private String tipoTranca;

	private TipoTranca(String tipoTranca) {
		this.setTipoTranca(tipoTranca);
	}

	public String getTipoTranca() {
		return tipoTranca;
	}

	public void setTipoTranca(String tipoTranca) {
		this.tipoTranca = tipoTranca;
	}
}
