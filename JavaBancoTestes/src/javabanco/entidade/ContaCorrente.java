package javabanco.entidade;

import java.util.ArrayList;
import java.util.Date;



public class ContaCorrente {
	private int _numero;
	private String _titular;
	private float _saldo = 0;
	private ArrayList<Operacoes> _operacoes = new ArrayList<Operacoes>();
	
	
	
	public ContaCorrente(int numero, String titular) {
		_numero = numero;
		_titular = titular;
	}
	public float saldo(){
		return _saldo;
	}
	
	public float credito( float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo += valor;
		Operacoes op = new Operacoes(valor, "CREDITO", new Date());
		_operacoes.add(op);
		return _saldo;
	}
	
	public float debito(float valor) {
		if (valor <= 0) throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		_saldo -= valor;
		Operacoes op = new Operacoes(valor, "DEBITO", new Date());
		_operacoes.add(op);
		return _saldo;
	}
	
	public ArrayList<Operacoes> extrato() {
		return _operacoes;
	}
	
	public int getNumero() {
		return _numero;
	}
	
	public String getTitular(){
		if (_titular == "joao da Silva") throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		if (_titular == "vánessa da Silva") throw new IllegalArgumentException("O valor da operacao deve ser maior que zero");
		return _titular;
	}
	
	public float transferencia (float valor , ContaCorrente ccDestino){
		this.debito(valor);
		ccDestino.credito(valor);
		return _saldo;
	}
}
