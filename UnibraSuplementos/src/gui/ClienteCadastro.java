package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import exercicio.Cliente;
import modelo.negocio.CategoriaNegocio;
import modelo.negocio.ClienteNegocio;

public class ClienteCadastro {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	MaskFormatter maskCPF;
	MaskFormatter maskDataNasc;
	MaskFormatter maskCEP;
	MaskFormatter maskTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCadastro window = new ClienteCadastro();
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
	public ClienteCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Cadastro de Clientes");

		JLabel lblNewLabel = new JLabel("CPF");

		JLabel lblNewLabel_1 = new JLabel("Email");

		JLabel label = new JLabel("Nome");

		JLabel label_1 = new JLabel("Data Nasc");

		JLabel label_2 = new JLabel("Endereco");

		JLabel label_3 = new JLabel("NumeroEndereco");

		JLabel label_4 = new JLabel("Complemento");

		JLabel label_5 = new JLabel("Bairro");

		JLabel label_6 = new JLabel("CEP");

		JLabel label_7 = new JLabel("Cidade");
		JFormattedTextField formattedTextField = new JFormattedTextField();
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		try {
			maskCPF = new MaskFormatter("###.###.###-##");
			maskDataNasc = new MaskFormatter("##/##/####");
			maskCEP = new MaskFormatter("##.###.-###");
			maskTelefone = new MaskFormatter("(##)#.####-####");
			maskCPF.install(formattedTextField);
			maskDataNasc.install(formattedTextField_1);
			maskCEP.install(formattedTextField_2);
			maskTelefone.install(formattedTextField_3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c = arg0.getKeyChar();
				if(!(c=='@')&&!(c=='.')&&!(Character.isLetter(c))) {
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
			if(Character.isAlphabetic(c)==false && Character.isWhitespace(c)==false) {
				arg0.consume();
			}
			
			int tamanho =50;
			if (textField_1.getText().length()>tamanho) {
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
				if(Character.isAlphabetic(c)==false && Character.isWhitespace(c)==false) {
					arg0.consume();
				}
				
				int tamanho =50;
				if (textField_2.getText().length()>tamanho) {
					arg0.consume();
				}
				
			}
		});
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c = arg0.getKeyChar();
				if(Character.isLetterOrDigit(c)==false && Character.isWhitespace(c)==false) {
					arg0.consume();
				}
				
				int tamanho =20;
				if (textField_3.getText().length()>tamanho) {
					arg0.consume();
				}
			}
		});
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c = arg0.getKeyChar();
				if(!(Character.isLetterOrDigit(c))) {
					arg0.consume();
				}
				
				int tamanho =20;
				if (textField_4.getText().length()>tamanho) {
					arg0.consume();
				}
				
			}
		});
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if((Character.isLetter(c)==false) && (Character.isWhitespace(c)==false)) {
					arg0.consume();
				}
				
				int tamanho =50;
				if (textField_5.getText().length()>tamanho) {
					arg0.consume();
				}
				
			}
		});
		textField_5.setColumns(10);



		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c = arg0.getKeyChar();
				
				if((Character.isLetter(c)==false) && (Character.isWhitespace(c)==false)) {
					arg0.consume();
				}
				int tamanho =50;
				if (textField_6.getText().length()>tamanho) {
					arg0.consume();
				}
			}
		});
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isLetter(c))) {
					arg0.consume();
				}
				
				int tamanho =2;
				if (textField_7.getText().length()>=tamanho) {
					arg0.consume();
				}
				arg0.setKeyChar(Character.toUpperCase(c));
			}
		});
		textField_7.setColumns(10);



		JLabel lblEstado = new JLabel("Estado");

		JLabel lblTelefone = new JLabel("Telefone");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
					Cliente c = new Cliente();
					ClienteNegocio n = new ClienteNegocio();
					c.setCpf(formattedTextField.getText());
					c.setEmail(textField.getText());
					c.setNomeCli(textField_1.getText());
					c.setDataNasc(d.parse(formattedTextField_1.getText()));
					c.setEndereco(textField_2.getText());
					c.setNumeroEndereco(textField_3.getText());
					c.setComplemento(textField_4.getText());
					c.setBairro(textField_5.getText());
					c.setCep(formattedTextField_2.getText());
					c.setCidade(textField_6.getText());
					c.setEstado(textField_7.getText());
					c.setTelefone(formattedTextField_3.getText());
					ClienteNegocio negocio = new ClienteNegocio();
					negocio.cadastrarCliente(c);
					   int input = JOptionPane.showConfirmDialog(null, "Cliente cadastrado com sucesso! Deseja cadastrar mais clientes?");
					if(input==1) {
					
						frame.dispose();
					
					}else {
						formattedTextField.setText("");
						formattedTextField_1.setText("");
						formattedTextField_2.setText("");
						formattedTextField_3.setText("");
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						
						
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Cadastro de Clientes", 0);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label_6)
								.addComponent(label_5)
								.addComponent(label_4)
								.addComponent(label_3)
								.addComponent(label_2)
								.addComponent(label_7)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(lblNewLabel_1)
								.addComponent(lblEstado)
								.addComponent(lblTelefone))
						.addGap(40)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCadastrar)
								.addComponent(formattedTextField_3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(formattedTextField_2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
										.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_1)
										.addComponent(textField_2)
										.addComponent(textField_5)
										.addComponent(textField_6)))
						.addContainerGap(109, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(36)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(1)
										.addComponent(lblNewLabel_1)
										.addGap(18)
										.addComponent(label)
										.addGap(18)
										.addComponent(label_1)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(label_2)
										.addGap(18)
										.addComponent(label_3)
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_4)))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(formattedTextField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_6))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_7))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEstado))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(formattedTextField_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefone))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnCadastrar)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}
