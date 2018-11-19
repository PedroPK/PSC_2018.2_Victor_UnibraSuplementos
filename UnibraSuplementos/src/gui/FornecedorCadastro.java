package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import exercicio.Fornecedor;
import modelo.negocio.FornecedorNegocio;

public class FornecedorCadastro {

	private JFrame frmCadastroDeFornecedores;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorCadastro window = new FornecedorCadastro();
					window.frmCadastroDeFornecedores.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FornecedorCadastro() {
		
			initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeFornecedores = new JFrame();
		frmCadastroDeFornecedores.setTitle("Cadastro de Fornecedores");
		frmCadastroDeFornecedores.setBounds(100, 100, 450, 300);
		frmCadastroDeFornecedores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNomeFornecedor = new JLabel("Nome Fornecedor");
		
		textField1 = new JTextField();
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isAlphabetic(c))&& !(Character.isWhitespace(c))) {
					arg0.consume();
					}
				int tamanho = 50;
				if(textField1.getText().trim().length()>tamanho) {
					arg0.consume();
					}
			}
		});
		textField1.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setText("(81)9.9988-7722");
		try {
			MaskFormatter mask = new MaskFormatter("(##)#.####-####");
			mask.install(formattedTextField);
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao instalar máscara. Tente novamente", "ERRO", 0);
		}
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FornecedorNegocio n = new FornecedorNegocio();
					Fornecedor fornecedor = new Fornecedor();
					fornecedor.setNomeFor(textField1.getText());
					fornecedor.setTelSac(formattedTextField.getText());
					n.cadastrarFornecedor(fornecedor);
					 int input = JOptionPane.showConfirmDialog(null, "Fornecedor cadastrado com sucesso! Deseja cadastrar mais Fornecedores?");
						if(input==1) {
						
							frmCadastroDeFornecedores.dispose();
						
						}else {
							textField1.setText("");
							formattedTextField.setText("");
							
						}
						
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 0);
				}
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeFornecedores.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCadastrar)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomeFornecedor)
								.addComponent(lblTelefone))
							.addGap(41)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(formattedTextField)
								.addComponent(textField1))))
					.addContainerGap(189, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeFornecedor)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(btnCadastrar)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		frmCadastroDeFornecedores.getContentPane().setLayout(groupLayout);
	}
}
