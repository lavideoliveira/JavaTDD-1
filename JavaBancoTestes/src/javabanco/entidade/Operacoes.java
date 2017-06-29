package javabanco.entidade;

import java.util.Date;

public class Operacoes {
	
	private float valor;
	private String tipoOperacao;
	private Date dataHora;
	
	public Date getDataHora() {
		return dataHora;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public Operacoes(float valor, String tipoOperacao, Date dataHora) {
		this.valor = valor; 
		this.tipoOperacao = tipoOperacao;
		this.dataHora = dataHora;
	}
	

	public float getValor(){
		return valor;
	}
	
 
	
	public String toString() {
		
		return "[valor: " + this.getValor() + "," + this.getTipoOperacao() + "," + this.getDataHora() + "]";
		
	}
	
}
