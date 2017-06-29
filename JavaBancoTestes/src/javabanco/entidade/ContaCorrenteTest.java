package javabanco.entidade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

public class ContaCorrenteTest {

	@Test
	public void testSaldo() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		assertEquals(0, cc.saldo(), 0);
	}

	@Test
	public void testCredito() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		cc.credito(100);
		assertEquals(100, cc.saldo(), 0);
	}

	@Test
	public void testDebito() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		cc.debito(100);
		assertEquals(-100, cc.saldo(), 0);
	}

	@Test
	public void testExtrato() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		cc.credito(100);
		cc.debito(100);
		ArrayList<Operacoes> listaOperacao = cc.extrato();
		assertEquals(2, listaOperacao.size());
		Operacoes op = listaOperacao.get(0);
		assertEquals(100, op.getValor(), 0);
		assertEquals("CREDITO", op.getTipoOperacao());
		assertEquals(100, listaOperacao.get(1).getValor(),  0);
		assertEquals("DEBITO", listaOperacao.get(1).getTipoOperacao());
	}
	
	@Test
	public void testSaldoPequenosFloats() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		cc.credito(0.1f);
		cc.credito(0.2f);
		assertEquals(0.3f, cc.saldo(), 0.0f);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreditoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		
		cc.credito(-10);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDebitoValorNegativo() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		
		cc.debito(-10);		
	}
	
	@Test
	public void testConstrutor(){
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		assertNotNull(cc);
	}
	
	@Test 
	public void testGetTitular(){
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		assertEquals("joão da Silva", cc.getTitular());
	}
	
	@Test 
	public void testGetNumero(){
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		assertEquals(1234, cc.getNumero());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTransferenciaValorNegativo() {
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		ContaCorrente ccDestino = new ContaCorrente (5678, "rogério da Silva");
		
		cc.transferencia(-10, ccDestino);	
	}
	
	@Test
	public void testTrensferencia(){
		//prepara
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		ContaCorrente ccDestino = new ContaCorrente (5678, "rogério da Silva");
		//transfere
		cc.transferencia(10, ccDestino);
		assertEquals(-10, cc.saldo(), 0);
		assertEquals(10, ccDestino.saldo(), 0);
		
	}
	
	
}
