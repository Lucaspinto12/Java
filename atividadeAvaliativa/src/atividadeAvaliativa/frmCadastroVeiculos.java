package atividadeAvaliativa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class frmCadastroVeiculos extends JFrame {
	JButton btCadastrar, btLimpar, btAlterar, btExcluir,btPesquisar,btSair;
	JTextField txtPlaca, txtModelo, txtAnoFabricacao, txtValor, txtDataCompra;
	JLabel lbPlaca, lbFabricante, lbModelo, lbAnoFabricacao, lbValor, lbDataCompra;
	JComboBox selectFabricante;
	JPanel pnCampos, pnBotoes, pnGrid;

	public frmCadastroVeiculos() {
		super("Controle de veiculos -  Cadastro de Frota");
		setSize(800, 150);
		setLayout(new BorderLayout());

		btCadastrar = new JButton("Cadastrar");
		btAlterar = new JButton("Alterar");
		btExcluir = new JButton("Excluir");
		btPesquisar = new JButton("Pesquisar");
		btLimpar = new JButton("Limpar");
		btSair = new JButton("Sair");

		String marca[] = { "Mitsubishi", "Ford", "Honda", "Chevrolet", "Mercedes" };

		txtPlaca = new JTextField(17);
		txtModelo = new JTextField(17);
		selectFabricante = new JComboBox(marca);
		txtAnoFabricacao = new JTextField(17);
		txtValor = new JTextField(17);
		txtDataCompra = new JTextField(17);

		lbPlaca = new JLabel("Placa");
		lbFabricante = new JLabel("Fabricante");
		lbModelo = new JLabel("Modelo");
		lbAnoFabricacao = new JLabel("Ano de Fabricação");
		lbValor = new JLabel("Valor");
		lbDataCompra = new JLabel("Data da Compra");
		
		pnCampos = new JPanel(new GridLayout(3,3));
		pnBotoes = new JPanel(new FlowLayout());
		
		pnCampos.add(lbPlaca);
		pnCampos.add(txtPlaca);
		pnCampos.add(lbFabricante);
		pnCampos.add(selectFabricante);
		pnCampos.add(lbModelo);
		pnCampos.add(txtModelo);
		pnCampos.add(lbAnoFabricacao);
		pnCampos.add(txtAnoFabricacao);
		pnCampos.add(lbValor);
		pnCampos.add(txtValor);
		pnCampos.add(lbDataCompra);
		pnCampos.add(txtDataCompra);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btAlterar);
		pnBotoes.add(btExcluir);
		pnBotoes.add(btPesquisar);
		pnBotoes.add(btLimpar);
		pnBotoes.add(btSair);

		add(pnCampos,  BorderLayout.EAST);
		add(pnBotoes,  BorderLayout.SOUTH);
		
		setVisible(true);
	}
	

	public static void main(String[] args) {
		frmCadastroVeiculos form = new frmCadastroVeiculos();
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
