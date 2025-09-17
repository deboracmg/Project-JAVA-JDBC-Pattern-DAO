package application;

import java.text.ParseException;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) throws ParseException {
		boolean valid = true;
		GUIBasic gui = new GUIBasic();
		
		while (valid) {
			int menu1 = Integer.parseInt(JOptionPane.showInputDialog(
					"Selecione uma opção abaixo:\n"
					+ "1 - Vendedores\n"
					+ "2 - Departamentos\n"
					+ "3 - Sair\n"));
			switch (menu1) {
			case 1:
				while (true) {
					int menu2 = Integer.parseInt(JOptionPane.showInputDialog(
							"Menu Vendedores:\n"
							+ "1 - Novo cadastro\n"
							+ "2 - Atualizar vendedor\n"
							+ "3 - Listar todos\n"
							+ "4 - Buscar por código\n"
							+ "5 - Buscar por departamento\n"
							+ "6 - Excluir vendedor\n"
							+ "7 - Voltar"));
					if (menu2==1) {
						gui.cadastrarVendedor();
					} else if (menu2==2) {
						gui.atualizarVendedor();
					} else if (menu2==3) {
						gui.listarVendedores();
					} else if (menu2==4) {
						gui.buscarVendedorPorId();
					} else if (menu2==5) {
						gui.buscarVendedorPorDepartamento();
					} else if (menu2==6) {
						gui.excluirVendedor();
					} else if (menu2==7) {
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Opção inválida.");
					}
				}
				break;
			case 2:
				while (true) {
					int menu2 = Integer.parseInt(JOptionPane.showInputDialog(
							"Menu Departamentos:\n"
							+ "1 - Novo cadastro\n"
							+ "2 - Atualizar departamento\n"
							+ "3 - Listar todos\n"
							+ "4 - Buscar por código\n"
							+ "5 - Excluir departamento\n"
							+ "6 - Voltar"));
					if (menu2==1) {
						gui.cadastrarDepartamento();
					} else if (menu2==2) {
						gui.atualizarDepartamento();
					} else if (menu2==3) {
						gui.listarDepartamentos();
					} else if (menu2==4) {
						gui.buscarDepartamento();
					} else if (menu2==5) {
						gui.excluirDepartamento();
					} else if (menu2==6) {
						break;
					} else {
						JOptionPane.showMessageDialog(null, "Opção inválida.");
					}
				}
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Finalizando sistema.");
				valid = false;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				break;
			}
		}
	}
}
