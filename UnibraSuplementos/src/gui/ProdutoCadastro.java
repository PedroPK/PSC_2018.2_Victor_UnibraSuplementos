package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import modelo.negocio.CategoriaNegocio;
import modelo.negocio.ProdutoNegocio;
import exercicio.Categoria;
import exercicio.Produto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProdutoCadastro {

	JComboBox<String> comboBox ;
	private JFrame frmCadastroDeProdutos;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoCadastro window = new ProdutoCadastro();
					window.frmCadastroDeProdutos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProdutoCadastro() {
		initialize();
		
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeProdutos = new JFrame();
		frmCadastroDeProdutos.setTitle("Cadastro de Produtos");
		frmCadastroDeProdutos.setBounds(100, 100, 476, 300);
		frmCadastroDeProdutos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Nome Produto");
		comboBox = new JComboBox<String>();
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c = arg0.getKeyChar();
				
				if(!(Character.isAlphabetic(c))&&!(Character.isWhitespace(c))) {
					arg0.consume();
					
				}
			}
		});
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CategoriaNegocio negocioCategoria = new CategoriaNegocio();
					ProdutoNegocio negocio = new ProdutoNegocio();
					
					Produto produto = new Produto();
					Categoria categoria = new Categoria();
					produto.setNomeprod(textField.getText());
					produto.setPrecoMedio(Double.parseDouble(textField_1.getText()));
					produto.setQtdEstoque(Integer.parseInt(textField_2.getText()));
					categoria.setNomeCategoria(comboBox.getSelectedItem().toString());
				    Categoria consulta =  new Categoria();
					consulta=negocioCategoria.consultarCategoria(categoria);
					produto.setCategoria(consulta);
					negocio.cadastrarProduto(produto);
					
					int input = JOptionPane.showConfirmDialog(null, "Produto cadastrado com sucesso! Deseja cadastrar mais produtos?");
					if(input==1) {
					
						frmCadastroDeProdutos.dispose();
					
					}else {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						
						
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro de produtos", 0);
				}
				
			}
		});
		
		
		try {
			CategoriaNegocio negocio = new CategoriaNegocio();
			List<Categoria> lista = new ArrayList<>();
			lista = negocio.listarCategorias();
			for (Categoria categoria : lista) {
				comboBox.addItem(categoria.getNomeCategoria());
							}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao carregar combobox. Tente novamente ", "Erro", 0);
		}
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c))) {
					arg0.consume();
					}
				int tamanho = 7;
				if(textField_1.getText().length()>= tamanho) {
					arg0.consume();
					
				}
				
			}
		});
		textField_1.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		
		JLabel lblCategoria = new JLabel("Categoria");
		
		JLabel lblQtdestoque = new JLabel("Qtd_Estoque");
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				
				if(!(Character.isDigit(c))) {
					arg0.consume();
					}
				int tamanho = 6;
				if(textField_2.getText().length()>=tamanho) {
					arg0.consume();
				}
			}
		});
		textField_2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeProdutos.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblQtdestoque)
						.addComponent(lblPreo)
						.addComponent(lblNewLabel)
						.addComponent(lblCategoria))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnNewButton)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(164, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPreo))
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQtdestoque)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategoria))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		frmCadastroDeProdutos.getContentPane().setLayout(groupLayout);
	}
}
