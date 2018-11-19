package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ClienteDetalhes {

	private JFrame frame;
	public JLabel lblCpfcli;
	public JLabel lblEmailcli;
	public JLabel lblNmcli;
	public JLabel lblDatanasccli;
	public JLabel lblEndcli;
	public JLabel lblNumeroendcli;
	public JLabel lblCompcli;
	public JLabel lblBairrocli;
	public JLabel lblCepcli;
	public JLabel lblCidadecli;
	public JLabel lblEstadocli;
	public JLabel lblTelcli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteDetalhes window = new ClienteDetalhes();
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
	public ClienteDetalhes() {
		initialize();
	}
public void Open () {
	frame.setVisible(true);
	
}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 345, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DETALHES DO CLIENTE");

		JLabel lblCpf = new JLabel("CPF");

		JLabel lblEmail = new JLabel("Email");

		JLabel lblNome = new JLabel("Nome");

		JLabel lblDataNasc = new JLabel("Data Nasc");

		JLabel lblEndereco = new JLabel("Endereco");

		JLabel lblN = new JLabel("N\u00B0");

		JLabel lblComplemento = new JLabel("Complemento");

		JLabel lblBairro = new JLabel("Bairro");

		JLabel lblCep = new JLabel("CEP");

		JLabel lblCidade = new JLabel("Cidade");

		JLabel lblEstado = new JLabel("Estado");

		JLabel lblTelefone = new JLabel("Telefone");

		lblCpfcli = new JLabel("cpf_cli");

		lblEmailcli = new JLabel("Email_cli");

		lblNmcli = new JLabel("Nm_cli");

		lblDatanasccli = new JLabel("DataNasc_cli");

		lblEndcli = new JLabel("End_cli");

		lblNumeroendcli = new JLabel("numeroEnd_cli");

		lblCompcli = new JLabel("comp_cli");

		lblBairrocli = new JLabel("bairro_cli");

		lblCepcli = new JLabel("cep_cli");

		lblCidadecli = new JLabel("cidade_cli");

		lblEstadocli = new JLabel("estado_cli");

		lblTelcli = new JLabel("tel_cli");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(29)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCpf)
								.addComponent(lblEmail)
								.addComponent(lblNome)
								.addComponent(lblDataNasc)
								.addComponent(lblEndereco)
								.addComponent(lblN)
								.addComponent(lblComplemento)
								.addComponent(lblBairro)
								.addComponent(lblCep)
								.addComponent(lblCidade)
								.addComponent(lblEstado)
								.addComponent(lblTelefone))
						.addGap(34)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTelcli)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblEstadocli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblCidadecli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblCompcli)
										.addComponent(lblNumeroendcli)
										.addComponent(lblEndcli)
										.addComponent(lblDatanasccli, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNmcli, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
										.addComponent(lblEmailcli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblCpfcli, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBairrocli, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
										.addComponent(lblCepcli, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap(350, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(44)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCpf)
								.addComponent(lblCpfcli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(lblEmailcli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNome)
								.addComponent(lblNmcli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDataNasc)
								.addComponent(lblDatanasccli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEndereco)
								.addComponent(lblEndcli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblN)
								.addComponent(lblNumeroendcli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblComplemento)
								.addComponent(lblCompcli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBairro)
								.addComponent(lblBairrocli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCep)
								.addComponent(lblCepcli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCidade)
								.addComponent(lblCidadecli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado)
								.addComponent(lblEstadocli))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(lblTelcli))
						.addContainerGap(78, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
	}

}
