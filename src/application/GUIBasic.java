package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class GUIBasic {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Seller seller = new Seller();
	private SellerDao sellerDao = DaoFactory.createSellerDao();
	private Department department = new Department();
	private DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
	
	public void cadastrarVendedor() throws ParseException {
		seller.setName(JOptionPane.showInputDialog("Digite o nome:"));
		seller.setEmail(JOptionPane.showInputDialog("Digite o email:"));
		seller.setBirthDate(sdf.parse(JOptionPane.showInputDialog(
				"Digite a data de nascimento (DD/MM/YYYY):")));
		seller.setBaseSalary(Double.parseDouble((JOptionPane.showInputDialog(
				"Digite o salário:"))));
		while (true) {
			int id=Integer.parseInt(JOptionPane.showInputDialog("Digite o código do departamento:"));
			department=departmentDao.findById(id);
			if (department==null) {
				JOptionPane.showMessageDialog(null, "Departamento não existe.");
			} else {
				seller.setDepartment(department);
				sellerDao.insert(seller);
				JOptionPane.showMessageDialog(null, "Vendedor cadastrado.");
				break;
			}
		}
	}
	
	public void atualizarVendedor() throws ParseException {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do vendedor:"));
		seller = sellerDao.findById(id);
		if (seller==null) {
			JOptionPane.showMessageDialog(null, "Vendedor não encontrado.");
			return;
		}
		while (true) {
			int menu3 = Integer.parseInt(JOptionPane.showInputDialog(
					"Qual campo deseja alterar?\n"
					+ "1 - Nome\n"
					+ "2 - Email\n"
					+ "3 - Data de Nascimento\n"
					+ "4 - Salário Base\n"
					+ "5 - Departamento\n"
					+ "6 - Cancelar"));
			if (menu3==1) {
				seller.setName(JOptionPane.showInputDialog("Digite o nome:"));
			} else if (menu3==2) {
				seller.setEmail(JOptionPane.showInputDialog("Digite o email:"));
			} else if (menu3==3) {
				seller.setBirthDate(sdf.parse(JOptionPane.showInputDialog(
						"Digite a data de nascimento (DD/MM/YYYY):")));
			} else if (menu3==4) {
				seller.setBaseSalary(Double.parseDouble((JOptionPane.showInputDialog(
						"Digite o salário:"))));
			} else if (menu3==5) {
				while (true) {
					int idDep=Integer.parseInt(JOptionPane.showInputDialog("Digite o código do departamento:"));
					department=departmentDao.findById(idDep);
					if (department==null) {
						JOptionPane.showMessageDialog(null, "Departamento não existe.");
					} else {
						seller.setDepartment(department);
						break;
					}
				}
			} else if (menu3==6) {
				JOptionPane.showMessageDialog(null, "Operação cancelada.");
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				continue;
			}
			sellerDao.update(seller);
			JOptionPane.showMessageDialog(null, "Vendedor atualizado.");
			return;
		}
	}
	
	public void listarVendedores() {
		StringBuilder sbAllS = new StringBuilder();
		List<Seller> listSellers = sellerDao.findAll();
		sbAllS.append("Vendedores registrados:\n");
		for (Seller s : listSellers) {
			sbAllS.append(s+"\n");
		}
		JOptionPane.showMessageDialog(null, sbAllS.toString());
	}
	
	public void buscarVendedorPorId() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do vendedor:"));
		seller = sellerDao.findById(id);
		if (seller==null) {
			JOptionPane.showMessageDialog(null, "Vendedor não encontrado.");
			return;
		}
		JOptionPane.showMessageDialog(null, "Vendedor solicitado:\n"+seller);
	}
	
	public void buscarVendedorPorDepartamento() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(
							"Digite o código do departamento:"));
		department = departmentDao.findById(id);
		if (department==null) {
			JOptionPane.showMessageDialog(null, "Departamento não encontrado.");
			return;
		}
		
		List<Seller> listSellers = sellerDao.findByDepartment(department);
		if (listSellers==null) {
			JOptionPane.showMessageDialog(null, "Departamento sem vendedores vinculados.");
			return;
		}
		
		StringBuilder sbDep = new StringBuilder();
		sbDep.append("Vendedores do departamento "+department.getId()+":\n");
		for (Seller s : listSellers) {
			sbDep.append(s+"\n");
		}
		JOptionPane.showMessageDialog(null, sbDep.toString());
	}
	
	public void excluirVendedor() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do vendedor:"));
		if (sellerDao.findById(id)==null) {
			JOptionPane.showMessageDialog(null, "Vendedor não encontrado.");
			return;
		}
		
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
		if (resposta==JOptionPane.YES_OPTION) {
			sellerDao.deleteById(id);
			JOptionPane.showMessageDialog(null, "Vendedor excluído.");
		} else {
			JOptionPane.showMessageDialog(null, "Operação cancelada.");
		}
	}
	
	public void cadastrarDepartamento() {
		department.setName(JOptionPane.showInputDialog("Digite o nome:"));
		departmentDao.insert(department);
	}
	
	public void atualizarDepartamento() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do departamento:"));
		department = departmentDao.findById(id);
		if (department==null) {
			JOptionPane.showMessageDialog(null, "Departamento não encontrado.");
			return;
		}
		department.setName(JOptionPane.showInputDialog("Digite o nome:"));
		departmentDao.update(department);
		JOptionPane.showMessageDialog(null, "Departamento atualizado.");
	}
	
	public void listarDepartamentos() {
		StringBuilder sbAllD = new StringBuilder();
		List<Department> listDepartment = departmentDao.findAll();
		sbAllD.append("Departamentos registrados:\n");
		for (Department d : listDepartment) {
			sbAllD.append(d+"\n");
		}
		JOptionPane.showMessageDialog(null, sbAllD.toString());
	}
	
	public void buscarDepartamento() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do departamento:"));
		department = departmentDao.findById(id);
		if (department==null) {
			JOptionPane.showMessageDialog(null, "Departamento não encontrado.");
			return;
		}
		JOptionPane.showMessageDialog(null, "Departamento solicitado:\n"+department);
	}
	
	public void excluirDepartamento() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do departamento:"));
		if (departmentDao.findById(id)==null) {
			JOptionPane.showMessageDialog(null, "Departamento não encontrado.");
			return;
		}
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?");
		if (resposta==JOptionPane.YES_OPTION) {
			department.setId(id);
			List<Seller> sellers = sellerDao.findByDepartment(department);
			if (sellers!=null) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir.\nHá vendedores vinculados.");
				return;
			}
			departmentDao.deleteById(id);
			JOptionPane.showMessageDialog(null, "Departamento excluído.");
		} else {
			JOptionPane.showMessageDialog(null, "Operação cancelada.");
		}
	}

}
