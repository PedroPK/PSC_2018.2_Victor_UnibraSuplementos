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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;

import exercicio.Vendedor;
import modelo.negocio.VendedorNegocio;

public class VendedorCadastro {

	private JFrame frmCadastroDeVendedores;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendedorCadastro window = new VendedorCadastro();
					window.frmCadastroDeVendedores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VendedorCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeVendedores = new JFrame();
		frmCadastroDeVendedores.setTitle("Cadastro de Vendedores");
		frmCadastroDeVendedores.setBounds(100, 100, 450, 300);
		frmCadastroDeVendedores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Vendedor v = new Vendedor();
					v.setNomeVendedor(textField.getText().trim());
					v.setTelefone(formattedTextField.getText());
					VendedorNegocio negocio = new VendedorNegocio();
					negocio.cadastrarVendedor(v);
					   int input = JOptionPane.showConfirmDialog(null, "Vendedor cadastrado com sucesso! Deseja cadastrar mais vendedores?");
					if(input==1) {
					
						frmCadastroDeVendedores.dispose();
					
					}else {
						textField.setText("");
						formattedTextField.setText("");
						
					}
					
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Cadastro de Vendedores", 1);
					e2.printStackTrace();
				}	
			}
		});
		
		JLabel lblNomeVendedor = new JLabel("Nome Vendedor");
		
		
		formattedTextField.setText("(81)9.9299-8811");
		
		try {
			MaskFormatter mask = new MaskFormatter("(##)#.####-####");
			mask.install(formattedTextField);
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Falha ao instalar máscara. Tente novamente", "ERRO", 0);
		}
		
		JLabel lblTelefone = new JLabel("Telefone");
		GroupLayout groupLayout = new GroupLayout(frmCadastroDeVendedores.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelefone)
						.addComponent(lblNomeVendedor))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrar)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeVendedor))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		frmCadastroDeVendedores.getContentPane().setLayout(groupLayout);
	}

}
