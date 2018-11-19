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

public class AlterarVendedor {

	private JFrame frame;
	private JTextField textField;
	public JLabel lblTel;
	public JLabel lblNmven;
	public MaskFormatter maskTel;
	public JFormattedTextField formattedTextField;
	public JLabel lblCd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarVendedor window = new AlterarVendedor();
					window.maskTel = new MaskFormatter("(##)#.####-####");
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
	public AlterarVendedor() {
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
		frame.setTitle("Atualização de Vendedores");

		JLabel lblNome = new JLabel("Nome");

		JLabel lblTelefone = new JLabel("Telefone");

		lblNmven = new JLabel("Nm_Ven");

		lblTel = new JLabel("Tel");

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


		formattedTextField = new JFormattedTextField();

		try {
			maskTel = new MaskFormatter("(##)#.####-####");
			maskTel.install(formattedTextField);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Atualização de Vendedores", 0);
		}

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Vendedor v = new Vendedor();
					VendedorNegocio n = new VendedorNegocio();
					v.setCodFun(Integer.parseInt(lblCd.getText()));
					v=n.consultarVendedor(v);
					if((textField.getText().trim().isEmpty())==false) {
						v.setNomeVendedor(textField.getText());
					}

					if(formattedTextField.getText().charAt(14)!=' ') {
						v.setTelefone(formattedTextField.getText());
					}
					n.atualizarVendedor(v);
					   int input = JOptionPane.showConfirmDialog(null, "Vendedor atualizado com sucesso! Deseja atualizar mais Vendedores?");
						if(input==1) {
						
							frame.dispose();
						
						}else {
							textField.setText("");
							formattedTextField.setText("");
							lblNmven.setText(v.getNomeVendedor());
							lblTel.setText(v.getTelefone());
							
						}


				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Atualização de Vendedores", 0);
				}
			}
		});

		JLabel lblCod = new JLabel("Cod");

		lblCd = new JLabel("Cd");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(29)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblTelefone)
								.addComponent(lblCod))
						.addGap(41)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblTel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNmven, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(btnAtualizar)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
												.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblCd, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(22, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(34)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCod)
								.addComponent(lblCd))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(lblNmven)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(lblTel)
								.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(btnAtualizar)
						.addContainerGap(96, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}
}
