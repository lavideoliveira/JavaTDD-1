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
		ArrayList<Float> op = cc.extrato();
		assertEquals(2, op.size());
		assertEquals(100, op.get(0), 0);
		assertEquals(-100, op.get(1), 0);
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
	
	@Test
	public void testTrensferencia(){
		ContaCorrente cc = new ContaCorrente(1234, "joão da Silva");
		ContaCorrente ccDestino = new ContaCorrente (5678, "rogério da Silva");
		cc.debito(10);
		ccDestino.credito(10);
		assertEquals(-10, cc.saldo(), 0);
		assertEquals(10, ccDestino.saldo(), 0);
		
	}
	
	
}
