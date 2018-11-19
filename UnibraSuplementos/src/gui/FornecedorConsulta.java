package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import exercicio.Fornecedor;
import modelo.negocio.FornecedorNegocio;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FornecedorConsulta {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private FornecedorNegocio negocio;
	private DefaultTableModel model;
	List<Fornecedor> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorConsulta window = new FornecedorConsulta();
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
	public FornecedorConsulta() {
		lista = new ArrayList<>();
		negocio = new FornecedorNegocio();
		initialize();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[]{"For_Cod", "Nome_For","Tel"});
		Listar();
	}
	private void Listar() {
		try {
			lista.clear();
			lista = negocio.listarFornecedores();
		 	 while (model.getRowCount() > 0) {
		            model.removeRow(0);
		        }
		 	 for (Fornecedor f : lista) {
	             model.addRow(new Object[]{f.getCodFornecedor(), f.getNomeFor(),f.getTelSac()});

	         }
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Consulta de Categorias", 0);
		}
	
		
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Consulta de Fornecedores");
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Fornecedor f = new Fornecedor();
					f.setNomeFor(textField.getText().trim());
					List<Fornecedor> consulta = new ArrayList<>();
							consulta= negocio.consultarFornecedorNome(f);		
							while(model.getRowCount()>0) {
								model.removeRow(0);
							}
					 for (Fornecedor fornecedor : consulta) {
			             model.addRow(new Object[]{fornecedor.getCodFornecedor(), fornecedor.getNomeFor(),fornecedor.getTelSac()});

			         }
					 textField.setText("");
					 
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Consulta de Fornecedores", 0);
					
				}
			}
		});
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Fornecedor para ser atualizado! ", "Atualização de Fornecedores", 0);
						return;
						
					}else if(table.getSelectedRowCount()>1){
						
						JOptionPane.showMessageDialog(null, "Selecione apenas um Fornecedor para ser atualizado por vez! ", "Atualização de Fornecedores", 0);
						return;
					}else {
						AlterarFornecedor form = new AlterarFornecedor();
						Fornecedor f = new Fornecedor();
						f.setCodFornecedor((Integer)model.getValueAt(table.getSelectedRow(), 0));
					    f=negocio.consultarFornecedor(f);
					    form.lblCd.setText(String.valueOf(f.getCodFornecedor()));
						form.lblTel.setText(f.getTelSac());
						form.lblNmfor.setText(f.getNomeFor());
						form.Open();
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Consulta de Fornecedores", 0);
				}
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(table.getSelectedRowCount()<0) {
						JOptionPane.showMessageDialog(null, "Selecione um Fornecedor para ser excluído! ", "Exclusão de Fornecedores", 0);
						return;
						
					}else if(table.getSelectedRowCount()>1){
						
						JOptionPane.showMessageDialog(null, "Selecione apenas um Fornecedor para ser excluído por vez! ", "Exclusão de Fornecedores", 0);
						return;
					}else {
						
						Fornecedor f = new Fornecedor();
						f.setCodFornecedor(((Integer) model.getValueAt(table.getSelectedRow(), 0))); 
						   int input = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Fornecedor?");
							if(input==0) {
								negocio.removerFornecedor(f);
								JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso! ", "Exclusao de Fornecedores", 1);
							    Listar();
							    textField.setText("");
							}
					}
					
					
				} catch (Exception ez) {
					JOptionPane.showMessageDialog(null, ez.getMessage(), "Exclusão de Fornecedores", 0);
				}
				
			}
		});
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c = arg0.getKeyChar();
				if(!(Character.isAlphabetic(c) )&& !(Character.isWhitespace(c)) ) {
				arg0.consume();
				}
				
				int tamanho = 50;
				if(textField.getText().length()>= tamanho) {
					arg0.consume();
				}
			}
		});
		textField.setColumns(10);
		
		JLabel lblNomeFornecedor = new JLabel("Nome Fornecedor");
		
		table = new JTable();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
					.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(135))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNomeFornecedor)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnConsultar)
					.addGap(46))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(134, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConsultar)
						.addComponent(lblNomeFornecedor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAlterar)
						.addComponent(btnExcluir))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
