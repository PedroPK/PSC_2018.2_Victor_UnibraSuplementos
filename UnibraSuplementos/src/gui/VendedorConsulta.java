package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import exercicio.Vendedor;
import modelo.negocio.VendedorNegocio;

public class VendedorConsulta {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private VendedorNegocio negocio;
	private DefaultTableModel model;
	List<Vendedor> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendedorConsulta window = new VendedorConsulta();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendedorConsulta() {
		initialize();
		negocio=new VendedorNegocio();
		lista = new ArrayList<>();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[]{"CodFun","Nome","Telefone"});
		Listar();
	}

	private void Listar() {
		try {
			lista.clear();
			lista = negocio.listarVendedores();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}
			for (Vendedor v : lista) {
				model.addRow(new Object[]{v.getCodFun(), v.getNomeVendedor(),v.getTelefone()});

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Consulta de Vendedores", 0);
		}



	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Consulta de Vendedores");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isAlphabetic(c) )&& !(Character.isWhitespace(c)) ) {
					arg0.consume();
				}

				int tamanho = 50;
				if(textField.getText().length()>= tamanho) {
					arg0.consume();
				}
			}
		});
		textField.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Vendedor vendedor= new Vendedor();
					vendedor.setNomeVendedor(textField.getText().trim());
					List<Vendedor> consulta = new ArrayList<>();
					consulta= negocio.consultarVendedorNome(vendedor);	
					while(model.getRowCount()>0) {
						model.removeRow(0);
					}
					for (Vendedor v : consulta) {
						model.addRow(new Object[]{v.getCodFun(), v.getNomeVendedor(),v.getTelefone()});

					}
					textField.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Consulta de Vendedores", 0);

				}
			}
		});

		JLabel lblNomeVendedor = new JLabel("Nome Vendedor");

		table = new JTable();

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Vendedor para ser excluído! ", "Exclusão de Vendedores", 0);
						return;

					}else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas um Vendedor para ser excluído por vez! ", "Exclusão de Vendedores", 0);
						return;
					}else {

						Vendedor v = new Vendedor();
						v.setCodFun(((Integer) model.getValueAt(table.getSelectedRow(), 0))); 
						int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Vendedor?");
						if(input==0) {
							negocio.removerVendedor(v);
							JOptionPane.showMessageDialog(null, "Vendedor removido com sucesso! ", "Exclusao de Vendedores", 1);
							Listar();
							textField.setText("");
						}
					}


				} catch (Exception ez) {
					JOptionPane.showMessageDialog(null, ez.getMessage(), "Exclusão de Fornecedores", 0);
				}
			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Vendedor para ser atualizado! ", "Atualização de Vendedores", 0);
						return;

					}

					else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas um Vendedor para ser atualizada por vez! ", "Atualização de Vendedores", 0);
						return;
					}else {

						AlterarVendedor form = new AlterarVendedor();
						Vendedor v = new Vendedor();
						v.setCodFun( (Integer) model.getValueAt(table.getSelectedRow(), 0) );
						v=negocio.consultarVendedor(v);
						form.lblCd.setText(String.valueOf(v.getCodFun()));
						form.lblNmven.setText(v.getNomeVendedor());
						form.lblTel.setText(v.getTelefone());
						form.Open();
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Consulta de Vendedores", 0);
				}

			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNomeVendedor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
										.addGap(34)
										.addComponent(btnConsultar))
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnExcluir)
										.addGap(35)
										.addComponent(btnAlterar)))
						.addContainerGap(46, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNomeVendedor)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExcluir)
								.addComponent(btnAlterar))
						.addContainerGap(48, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}

}
