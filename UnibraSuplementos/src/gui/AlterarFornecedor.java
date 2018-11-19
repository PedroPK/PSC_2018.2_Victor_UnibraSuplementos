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

public class AlterarFornecedor {

	private JFrame frame;
	private JTextField textField;
	public JLabel lblNmfor;
	public JLabel lblTel;
	public MaskFormatter mask ;
	public JLabel lblCd;
	public JFormattedTextField formattedTextField;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarFornecedor window = new AlterarFornecedor();
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
	public AlterarFornecedor() {
		initialize();
	}
	public void Open() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Atualização de Fornecedores");

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Fornecedor f = new Fornecedor();
					FornecedorNegocio n = new FornecedorNegocio();
					f.setCodFornecedor(Integer.parseInt(lblCd.getText()));
					f=n.consultarFornecedor(f);
					if((textField.getText().trim().isEmpty())==false) {
						f.setNomeFor(textField.getText());
					}

					if(formattedTextField.getText().charAt(14)!=' ') {
						f.setTelSac(formattedTextField.getText());
					}
					n.atualizarFornecedor(f);
					   int input = JOptionPane.showConfirmDialog(null, "Fornecedor atualizado com sucesso! Deseja atualizar mais Fornecedores?");
						if(input==1) {
						
							frame.dispose();
						
						}else {
							textField.setText("");
							formattedTextField.setText("");
							lblNmfor.setText(f.getNomeFor());
							lblTel.setText(f.getTelSac());
							
						}


				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Atualização de Fornecedores", 0);
				}
			}
		});

		JLabel lblNome = new JLabel("Nome");

		JLabel lblTelefone = new JLabel("Telefone");

		lblNmfor = new JLabel("Nm_For");

		lblTel = new JLabel("Tel");

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isLetter(c)&&!(Character.isWhitespace(c)))) {
					arg0.consume();
				}

				int tamanho = 50;
				if(textField.getText().trim().length() >=tamanho) {
					arg0.consume();
				}
			}
		});
		textField.setColumns(10);
		 formattedTextField = new JFormattedTextField();
		try {
			 mask = new MaskFormatter("(##)#.####-####");
			 mask.install(formattedTextField);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Atualização de Fornecedores", 0);
		}
		
		JLabel lblCod = new JLabel("Cod");
		
		 lblCd = new JLabel("Cd");
		
	
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTelefone)
							.addGap(18)
							.addComponent(lblTel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblCod))
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCd, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNmfor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtualizar)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCod)
						.addComponent(lblCd))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(lblNmfor)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(lblTel)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnAtualizar)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
