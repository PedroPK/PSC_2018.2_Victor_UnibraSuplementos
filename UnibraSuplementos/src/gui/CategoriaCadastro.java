package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import exercicio.Categoria;
import modelo.negocio.CategoriaNegocio;

public class CategoriaCadastro {

	private JFrame frmCadastroDeCategorias;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoriaCadastro window = new CategoriaCadastro();
					window.frmCadastroDeCategorias.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CategoriaCadastro() {

		initialize();
	}
	
	

	public void open() {
	frmCadastroDeCategorias.setVisible(true);
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeCategorias = new JFrame();
		frmCadastroDeCategorias.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
			
			
			}
		});
		frmCadastroDeCategorias.setTitle("Cadastro de Categorias");
		frmCadastroDeCategorias.setBounds(100, 100, 422, 177);
		frmCadastroDeCategorias.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Categoria c = new Categoria();
					c.setNomeCategoria(textField_1.getText().trim());
					CategoriaNegocio negocio = new CategoriaNegocio();
					negocio.cadastrarCategoria(c);
					int input = JOptionPane.showConfirmDialog(null, "Categoria cadastrada com sucesso! Deseja cadastrar mais categorias?");
					if(input==1) {

						frmCadastroDeCategorias.dispose();

					}else {
						textField_1.setText("");

					}
					
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Cadastro de categorias", 1);
					e2.printStackTrace();
				}	
					
			
				
				
			}
		});
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isAlphabetic(c) )&& !(Character.isWhitespace(c)) ) {
				arg0.consume();
				}
				
				int tamanho = 50;
				if(textField_1.getText().length()>= tamanho) {
					arg0.consume();
				}
			}
		});
		textField_1.setColumns(10);
		
		JLabel lblDigiteONome = new JLabel("Digite o nome da categoria a ser cadastrada");
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeCategorias.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDigiteONome)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnCadastrar)
							.addContainerGap(112, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblDigiteONome)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrar)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		frmCadastroDeCategorias.getContentPane().setLayout(groupLayout);
	}
}
