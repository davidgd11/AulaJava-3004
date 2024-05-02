package br.com.fiap;

import java.time.LocalDate;

public class Gerente extends Funcionario{
	private float bonus;
	
	public Gerente() {}

	public Gerente(String nome, LocalDate dataNascimento, float valorHoraTrabalho, float bonus) {
		super(nome, dataNascimento, valorHoraTrabalho);
		this.bonus = bonus;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	public float calculaSalario() {
		float salario = ((super.getValorHoraTrabalho() * 40) * 4) * (1 + bonus / 100);
		return salario;
	}
}

