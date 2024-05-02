package br.com.fiap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import br.com.fiap.Funcionario;
import br.com.fiap.Garcom;
import br.com.fiap.Gerente;

public class UsaConta {

	public static void main(String[] args) {
		String aux, nome, escolha = "sim";
		float valorHora;
		LocalDate dataNasc;
		int opcao;
		while (escolha.equalsIgnoreCase("sim")) {
			try {
				nome = JOptionPane.showInputDialog("Digite seu nome");
				DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				aux = JOptionPane.showInputDialog("Digite a data de nascimento");
				dataNasc = LocalDate.parse(aux, dft);
				aux = JOptionPane.showInputDialog("Qual o valor da hora de trabalho?");
				valorHora = Float.parseFloat(aux);
				aux = JOptionPane.showInputDialog("Escolha o funcionario:\n(1) Normal"
						+ "\n(2) Garcom \n(3) Gerente");
				opcao = Integer.parseInt(aux);
				switch (opcao) {
				case 1:
					Funcionario func = new Funcionario(nome, dataNasc, valorHora);					
					String dataFunc = func.getDataNascimento().format(dft);
					JOptionPane.showMessageDialog(null, "Nome: " + func.getNome()
							+ "\nData de Nascimento: " + dataFunc
							+ "\nIdade: " + func.calculaIdade() + " anos"
							+ "\nSalario: R$ " + func.calculaSalario());
					break;
				case 2:					
					aux = JOptionPane.showInputDialog("Digite valor da gorjeta");
					float gorjeta = Float.parseFloat(aux);
					Garcom gar = new Garcom(nome, dataNasc, valorHora, gorjeta);
					String dataGarcom = gar.getDataNascimento().format(dft);
					JOptionPane.showMessageDialog(null, "Nome: " + gar.getNome()
					+ "\nData de Nascimento: " + dataGarcom
					+ "\nIdade: " + gar.calculaIdade() + " anos"
					+ "\nSalario: R$ " + gar.calculaSalario());
					break;
				case 3:
					aux = JOptionPane.showInputDialog("Digite valor do bonus");
					float bonus = Float.parseFloat(aux);
					Gerente ger = new Gerente(nome, dataNasc, valorHora, bonus);
					String dataGerente = ger.getDataNascimento().format(dft);
					JOptionPane.showMessageDialog(null, "Nome: " + ger.getNome()
					+ "\nData de Nascimento: " + dataGerente
					+ "\nIdade: " + ger.calculaIdade() + " anos"
					+ "\nSalario: R$ " + ger.calculaSalario());
					break;
				default:
					throw new Exception("Escolha incorreta!");
				}
				escolha = JOptionPane.showInputDialog("Deseja continuar?");				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Fim de programa");
	}
}
