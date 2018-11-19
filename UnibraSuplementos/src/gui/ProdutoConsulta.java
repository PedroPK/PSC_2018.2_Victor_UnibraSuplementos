package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import exercicio.Produto;
import exercicio.Vendedor;
import modelo.negocio.CategoriaNegocio;
import modelo.negocio.ProdutoNegocio;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProdutoConsulta {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private List<Produto> lista;
	private ProdutoNegocio negocio;
	private DefaultTableModel model ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoConsulta window = new ProdutoConsulta();
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
	public ProdutoConsulta() {
		lista = new ArrayList<>();
		negocio = new ProdutoNegocio();
		initialize();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] {"Cod_Prod","Nome","Preço","Categoria","Estoque"});
		Listar();
	} 

	private void Listar() {
		try {
			lista.clear();
			lista = negocio.listarProdutos();
			while (model.getRowCount() > 0) {
				model.removeRow(0);
			}


			for (Produto p : lista) {
				model.addRow(new Object[]{p.getCodProd(), p.getNomeprod(),p.getPrecoMedio(),p.getCategoria().getNomeCategoria(),p.getQtdEstoque()});

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Consulta de Produtos", 0);

		}



	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Consulta de Produtos");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if(!(Character.isWhitespace(c))&&!(Character.isLetter(c) )) {
					arg0.consume();

				}

				int tamanho = 50;
				if (textField.getText().length()>tamanho) {
					arg0.consume();
				}
			}
		});
		textField.setColumns(10);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Produto produto= new Produto();
					produto.setNomeprod(textField.getText().trim());
					List<Produto> consulta = new ArrayList<>();
					consulta= negocio.consultarProdutoNome(produto);
					while(model.getRowCount()>0) {
						model.removeRow(0);
					}
					for (Produto p : consulta) {
						model.addRow(new Object[]{p.getCodProd(), p.getNomeprod(),p.getPrecoMedio(),p.getCategoria().getNomeCategoria(),p.getQtdEstoque()});

					}
					textField.setText("");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Consulta de Produtos", 0);

				}
			}
		});

		JLabel lblNomeProduto = new JLabel("Nome Produto");

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Produto para ser excluído! ", "Atualização de Produtos", 0);
						return;

					}else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas um Produto para ser atualizado por vez! ", "Atualização de Produtos", 0);
						return;
					}else {
						AlterarProduto form = new AlterarProduto();
						Produto p = new Produto();
						p.setCodProd(((Integer) model.getValueAt(table.getSelectedRow(), 0))); 
						p = negocio.consultarProduto(p);
						
						form.lblCd.setText(String.valueOf(p.getCodProd()));
						form.lblNm.setText(p.getNomeprod());
						form.lblR.setText(String.valueOf(p.getPrecoMedio()));
						form.lblQtd.setText(String.valueOf(p.getQtdEstoque()));
						form.lblNmcat.setText(p.getCategoria().getNomeCategoria());

						CategoriaNegocio negocioCat = new CategoriaNegocio();
						List<Categoria> listaCat = new ArrayList<>();
						listaCat = negocioCat.listarCategorias();
						for (Categoria categoria : listaCat) {
							form.comboBox.addItem(categoria.getNomeCategoria());
						}
						form.comboBox.setSelectedItem(form.lblNmcat.getText());
						form.Open();
					}


				}

				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Consulta de Produtos", 0);
				}

			}
		});

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Produto para ser excluído! ", "Exclusão de Produtos", 0);
						return;

					}else if(table.getSelectedRowCount()>1){

						JOptionPane.showMessageDialog(null, "Selecione apenas um Produto para ser excluído por vez! ", "Exclusão de Produtos", 0);
						return;
					}else {

						Produto p = new Produto();
						p.setCodProd(((Integer) model.getValueAt(table.getSelectedRow(), 0))); 
						int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Produto?");
						if(input==0) {
							negocio.removerProduto(p);
							JOptionPane.showMessageDialog(null, "Produto removido com sucesso! ", "Exclusao de Produtos", 1);
							Listar();
							textField.setText("");

						}
					}


				} catch (Exception ez) {
					JOptionPane.showMessageDialog(null, ez.getMessage(), "Exclusão de Produtos", 0);
				}
			}
		});

		table = new JTable();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNomeProduto)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
										.addGap(31)
										.addComponent(btnConsultar))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
								.addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(56, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(38)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnConsultar)
								.addComponent(lblNomeProduto)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAlterar)
								.addComponent(btnExcluir))
						.addContainerGap(34, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}

}
