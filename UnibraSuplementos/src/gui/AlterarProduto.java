package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import exercicio.Categoria;
import exercicio.Produto;
import modelo.negocio.CategoriaNegocio;
import modelo.negocio.ProdutoNegocio;

public class AlterarProduto {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JLabel lblCd ;
	public	JLabel lblNm ;
	public JLabel lblR  ;
	public	JLabel lblQtd  ;
	public JLabel lblNmcat;
	public JComboBox comboBox;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarProduto window = new AlterarProduto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AlterarProduto() {
		initialize();
	}
	public void Open() {
		frame.setVisible(true);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Atualização de Produtos");

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CategoriaNegocio nCategoria = new CategoriaNegocio();
					ProdutoNegocio n = new ProdutoNegocio();
					Categoria c = new Categoria();
					Produto p = new Produto();
					p.setCategoria(new Categoria());
					p.setCodProd(Integer.parseInt(lblCd.getText()));
					p = n.consultarProduto(p);
					if((textField.getText().trim().isEmpty())==false) {
						p.setNomeprod(textField.getText());
					}
					if((textField_1.getText().trim().isEmpty())==false) {
						p.setPrecoMedio(Double.parseDouble(textField_1.getText()));
					}
					if((textField_2.getText().trim().isEmpty())==false  ) {
						p.setQtdEstoque(Integer.parseInt(textField_2.getText()));
					}
					c.setNomeCategoria(comboBox.getSelectedItem().toString());
					c=nCategoria.consultarCategoria(c);
					p.setCategoria(c);
					n.atualizarProduto(p);
					int input = JOptionPane.showConfirmDialog(null, "Produto atualizado com sucesso! Deseja fazer mais atualizações para este Produto?");
					if(input==1) {

						frame.dispose();

					}else {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						lblNm.setText(p.getNomeprod());
						lblR.setText(String.valueOf(p.getPrecoMedio()));
						lblQtd.setText(String.valueOf(p.getQtdEstoque()));
						lblNmcat.setText(p.getCategoria().getNomeCategoria());

					}



				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Atualização de Produtos", 0);
				}
			}
		});



		lblCd = new JLabel("CD");
		lblNm = new JLabel("Nm");
		lblR = new JLabel("R$");
		lblQtd = new JLabel("QTD");

		JLabel lblQtdestoque = new JLabel("Qtd_Estoque");
		JLabel lblPreo = new JLabel("Preço");
		JLabel lblNome = new JLabel("Nome");
		JLabel lblCodprod = new JLabel("Cod_Prod");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if(Character.isAlphabetic(c)==false && Character.isWhitespace(c)==false) {
					arg0.consume();
				}

				int tamanho =50;
				if (textField.getText().length()>tamanho) {
					arg0.consume();
				}
			}
		});
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if(!(c=='.')&&!(Character.isDigit(c))) {
					arg0.consume();
				}

				int tamanho =10;
				if (textField.getText().length()>tamanho) {
					arg0.consume();
				}
			}
		});
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c))) {
					arg0.consume();
				}

				int tamanho =10;
				if (textField.getText().length()>tamanho) {
					arg0.consume();
				}
			}
		});
		textField_2.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria");

		lblNmcat = new JLabel("Nm_Cat");

		comboBox = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCategoria)
								.addComponent(lblQtdestoque)
								.addComponent(lblPreo)
								.addComponent(lblNome)
								.addComponent(lblCodprod))
						.addGap(40)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblQtd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblR, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblCd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNm, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
								.addComponent(lblNmcat))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnAtualizar)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
										.addComponent(textField_2)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(25, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(40)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodprod)
								.addComponent(lblCd))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(lblNm)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblPreo)
												.addComponent(lblR))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblQtdestoque)
												.addComponent(lblQtd)))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCategoria)
										.addComponent(lblNmcat))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(btnAtualizar)
						.addContainerGap(21, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}
