package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
import modelo.negocio.CategoriaNegocio;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CategoriaConsulta {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private CategoriaNegocio negocio;
	private DefaultTableModel model;
	private List<Categoria> lista ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoriaConsulta window = new CategoriaConsulta();
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
	public CategoriaConsulta() {
		model = new DefaultTableModel();
		initialize();
		model= (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] {"Cod","Nome"});

		Listar();

	}
	public void Open() {
		frame.setVisible(true);

	}
	private void Listar() {
		try {
			lista.clear();
			lista = negocio.listarCategorias();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}



			for (Categoria categoria : lista) {
				model.addRow(new Object[]{categoria.getCodCategoria(), categoria.getNomeCategoria()});

			}
			table.setModel(model);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Lista de Categorias", 0);
		}



	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Consulta de Categorias");
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					CategoriaNegocio n = new CategoriaNegocio();
					Categoria c = new Categoria();
					c.setNomeCategoria(textField.getText().trim());
					List<Categoria> consulta = new ArrayList<>();
					consulta=n.consultarCategoriaNome(c);
					while(model.getRowCount()>0) {
						model.removeRow(0);
					}
					for (Categoria categoria : consulta) {
						model.addRow(new Object[]{categoria.getCodCategoria(), categoria.getNomeCategoria()});

					}
					textField.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Consulta de Categorias", 0);

				}
			}
		});
		negocio = new CategoriaNegocio();
		lista = new ArrayList<>();
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Categoria c = new Categoria();
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione uma Categoria para ser alterada! ", "Atualização de Categorias", 0);
						return;

					}

					else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas uma Categoria para ser atualizada por vez! ", "Atualização de Categorias", 0);
						return;
					}else {
						AlterarCategoria form = new AlterarCategoria();
						c.setCodCategoria((Integer) model.getValueAt(table.getSelectedRow(), 0));
						c.setNomeCategoria((String)model.getValueAt(table.getSelectedRow(), 1));
						form.lblCod.setText(String.valueOf(c.getCodCategoria()));
						form.lblNmcat.setText(c.getNomeCategoria());
						form.open();


					}
				} catch (Exception ez) {
					JOptionPane.showMessageDialog(null, ez.getMessage(), "Consulta de Categorias",0);
				}
			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione uma Categoria para ser excluída! ", "Exclusão de Categorias", 0);
						return;

					}else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas uma Categoria para ser excluída por vez! ", "Exclusão de Categorias", 0);
						return;
					}else {

						Categoria c = new Categoria();
						c.setCodCategoria((Integer) model.getValueAt(table.getSelectedRow(), 0)); 
						int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover esta Categoria?");
						if(input==0) {
							negocio.removerCategoria(c);
							JOptionPane.showMessageDialog(null, "Categoria removida com sucesso! ", "Exclusao de Categorias", 1);
							Listar();
							textField.setText("");
						}
					}


				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Exclusão de Categorias", 0);
				}
			}
		});

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if(!(Character.isAlphabetic(c)&&!(Character.isWhitespace(c)))) {
					e.consume();
				}
				int tamanho = 50;
				if(textField.getText().length()>tamanho) {
					e.consume();

				}
			}
		});
		textField.setColumns(10);

		JLabel lblNomeCategoria = new JLabel("Nome Categoria");

		table =  new javax.swing.JTable();
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {{null, null, null, null}}, new String[] {"ID","Nome"}));
		//= new JTable(new javax.swing.table.DefaultTableModel(new Object[][] {{null, null, null, null}}, new String[] {"ID","Nome"}));
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNomeCategoria)
						.addGap(18)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addComponent(btnConsultar)
						.addGap(31))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(45)
						.addComponent(btnExcluir)
						.addGap(49)
						.addComponent(btnAlterar)
						.addContainerGap(212, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(35)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(107, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNomeCategoria)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnConsultar))
						.addGap(18)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAlterar)
								.addComponent(btnExcluir))
						.addGap(20))
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}
