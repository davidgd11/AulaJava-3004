package br.com.fiap;

import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

public class Funcionario {
	
	private String nome;
	private LocalDate dataNascimento;
	private float valorHoraTrabalho;
	
	public Funcionario() {}
	
	public Funcionario(String nome, LocalDate dataNascimento, float valorHoraTrabalho) {
		this.nome = nome;
		setDataNascimento(dataNascimento);
		this.valorHoraTrabalho = valorHoraTrabalho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		LocalDate inicio = LocalDate.parse("1899-12-31");
		LocalDate fim = LocalDate.now().plusDays(1);
		try {
			if (dataNascimento.isAfter(inicio) && dataNascimento.isBefore(fim)) {
				this.dataNascimento = dataNascimento;
			} else {
				throw new Exception("Data fora da faixa permitida");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(0); 
		}
		
	}

	public float getValorHoraTrabalho() {
		return valorHoraTrabalho;
	}

	public void setValorHoraTrabalho(float valorHoraTrabalho) {
		this.valorHoraTrabalho = valorHoraTrabalho;
	}
	
	public float calculaSalario() {
		float salario = ((valorHoraTrabalho * 40) * 4);
		return salario;
	}
	
	public int calculaIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period idade = Period.between(dataNascimento, dataAtual);
		return idade.getYears();
	}

}
