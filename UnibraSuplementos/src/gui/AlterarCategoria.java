package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exercicio.Categoria;
import modelo.negocio.CategoriaNegocio;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AlterarCategoria {

	private JFrame frame;
	private JTextField textField;
	public JLabel lblNmcat;
	public JLabel lblCod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarCategoria window = new AlterarCategoria();
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
	public AlterarCategoria() {
		initialize();
	}

	public void open() {
		frame.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 207);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Atualização de Categorias");
		
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblNomeCategoria = new JLabel("Nome Categoria");
		JButton btnAtualizar = new JButton("Atualizar");
		lblCod = new JLabel("Cod");
		
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					CategoriaNegocio n = new CategoriaNegocio();
					Categoria c = new Categoria();
					c.setCodCategoria(Integer.parseInt(lblCod.getText()));
					c.setNomeCategoria(lblNomeCategoria.getText());
					if(textField.getText().trim()!="") {
						c.setNomeCategoria(textField.getText());
					}
					n.atualizarCategoria(c);
					 int input = JOptionPane.showConfirmDialog(null, "Categoria atualizada com sucesso! Deseja fazer mais atualizações para esta Categoria?");
						if(input==1) {
						
							frame.dispose();
						
						}else {
							textField.setText("");
							lblNmcat.setText(c.getNomeCategoria());
							
							
						}
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Atualização de Categorias", 0);
				}
			}
		});
		
	
		
		lblNmcat = new JLabel("Nm_Cat");
		
		JLabel lblNewLabel = new JLabel("Cod_Cat");
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAtualizar)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCod, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(lblNomeCategoria)
							.addGap(42)
							.addComponent(lblNmcat, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(69)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNmcat)
						.addComponent(lblNomeCategoria)
						.addComponent(lblCod)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAtualizar)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
