package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import util.java.Util;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPrincipal window = new GuiPrincipal();
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
	public GuiPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				Util.getEntityManagerFactory();
			}
			@Override
			public void windowClosing(WindowEvent e) {	
				Util.closeEntityManageFactory();
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnCadastrarCategoria = new JButton("Cadastrar Categoria");
		btnCadastrarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoriaCadastro form = new CategoriaCadastro();
				form.open();
				
			}
		});
		
		JButton btnConsultarCategoria = new JButton("Consultar Categoria");
		btnConsultarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoriaConsulta form = new CategoriaConsulta();
				form.Open();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrarCategoria)
						.addComponent(btnConsultarCategoria))
					.addContainerGap(293, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(btnCadastrarCategoria)
					.addGap(18)
					.addComponent(btnConsultarCategoria)
					.addContainerGap(155, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
