package gui;

import java.awt.EventQueue;
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

import exercicio.Categoria;
import exercicio.Cliente;
import modelo.negocio.CategoriaNegocio;
import modelo.negocio.ClienteNegocio;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteConsulta {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	List<Cliente> lista;
	ClienteNegocio negocio ;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteConsulta window = new ClienteConsulta();
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
	public ClienteConsulta() {
		lista = new ArrayList<>();
		negocio = new ClienteNegocio();
		initialize();
		model= (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] {"Cod","Nome","CPF","Email","Telefone"});
		Listar();
	}
	private void Listar() {
		try {
			lista.clear();
			lista = negocio.listarClientes();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}


			for (Cliente c : lista) {
				model.addRow(new Object[]{c.getCodCliente(), c.getNomeCli(),c.getCpf(),c.getEmail() ,c.getTelefone()} );

			}


		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de Clientes", 0);

		}



	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 588, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Consulta de Clientes");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if((Character.isLetter(c)==false)&&(Character.isWhitespace(c)==false)) {
					e.consume();
				}
				int tamanho = 50;
				if(textField.getText().length()>tamanho) {
					e.consume();
				}
			}
		});
		textField.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Cliente cli = new Cliente();
					cli.setNomeCli(textField.getText().trim());
					List<Cliente> consulta = new ArrayList<>();
					consulta=negocio.consultarClienteNome(cli);
					while(model.getRowCount()>0) {
						model.removeRow(0);
					}
					for (Cliente c : consulta) {
						model.addRow(new Object[] {c.getCodCliente(),c.getNomeCli(),c.getCpf(),c.getEmail(),c.getTelefone()});

					}
					textField.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Consulta de Clientes", 0);

				}
			}
		});

		JLabel lblNomeCliente = new JLabel("Nome Cliente");

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Cliente para ser excluído! ", "Exclusão de Clientes", 0);
						return;

					}else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas um Cliente para ser excluído por vez! ", "Exclusão de Clientes", 0);
						return;
					}else {

						Cliente c = new Cliente();
						c.setCodCliente((Integer) model.getValueAt(table.getSelectedRow(), 0)); 
						int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Cliente?");
						if(input==0) {
							negocio.removerCliente(c);
							JOptionPane.showMessageDialog(null, "Cliente removido com sucesso! ", "Exclusao de Cliente", 1);
							Listar();
							textField.setText("");
						}
					}


				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Exclusão de Cliente", 0);
				}
			}
		});

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Cliente para ser alterado! ", "Atualização de Clientes", 0);
						return;

					}else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas um Cliente para ser atualizado por vez! ", "Atualização de Clientes", 0);
						return;
					}else {
						Cliente cli = new Cliente();
						cli.setCodCliente((Integer) model.getValueAt(table.getSelectedRow(), 0)); 
						cli=negocio.consultarCliente(cli);
						AlterarCliente form = new AlterarCliente();
						form.lblCdcli.setText(String.valueOf(cli.getCodCliente()));
						form.label_11.setText(cli.getCpf());
						form.formattedTextField.setText(cli.getCpf());
						form.label_12.setText(cli.getEmail());
						form.label_13.setText(cli.getNomeCli());
						form.label_14.setText(String.valueOf(cli.getDataNasc()));
						form.formattedTextField_1.setText(String.valueOf(cli.getDataNasc()));
						form.label_15.setText(cli.getEndereco());
						form.label_16.setText(cli.getNumeroEndereco());
						form.label_17.setText(cli.getComplemento());
						form.label_18.setText(cli.getBairro());
						form.label_19.setText(cli.getCep());
						form.formattedTextField_2.setText(cli.getCep());
						form.label_20.setText(cli.getCidade());
						form.label_21.setText(cli.getEstado());
						form.label_22.setText(cli.getTelefone());
						form.formattedTextField_3.setText(cli.getTelefone());
						form.Open();

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Consulta de Clientes", 0);
				}

				
			}
		});


		table = new JTable();
		
		JButton btnDetalhes = new JButton("Detalhes");
		btnDetalhes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Escolha um cliente para ser detalhado! ", "Detalhes de Clientes", 0);
						return;

					}else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas um Cliente para ser detalhado por vez! ", "Detalhes de Clientes", 0);
						return;
					}else {

						Cliente c = new Cliente();
						ClienteDetalhes form = new ClienteDetalhes();
						c.setCodCliente((Integer) model.getValueAt(table.getSelectedRow(), 0)); 
						c=negocio.consultarCliente(c);
						form.lblCpfcli.setText(c.getCpf());
						form.lblEmailcli.setText(c.getEmail());
						form.lblNmcli.setText(c.getNomeCli());
						form.lblDatanasccli.setText(String.valueOf(c.getDataNasc()));
						form.lblEndcli.setText(c.getEndereco());
						form.lblNumeroendcli.setText(c.getNumeroEndereco());
						form.lblCompcli.setText(c.getComplemento());
						form.lblBairrocli.setText(c.getBairro());
						form.lblCepcli.setText(c.getCep());
						form.lblCidadecli.setText(c.getCidade());
						form.lblEstadocli.setText(c.getEstado());
						form.lblTelcli.setText(c.getTelefone());
						form.Open();
					}


				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Detalhes do Cliente", 0);
				}
			}
		});



		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNomeCliente)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnConsultar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnExcluir)
							.addGap(40)
							.addComponent(btnAlterar)
							.addGap(50)
							.addComponent(btnDetalhes))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConsultar)
						.addComponent(lblNomeCliente)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExcluir)
						.addComponent(btnAlterar)
						.addComponent(btnDetalhes))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
