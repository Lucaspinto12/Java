package pjAula12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;



public class frmCliente extends JFrame  implements ActionListener{
	JLabel lbNome, lbCNPJ, lbTelefone, lbStatus;
	JTextField txtNome;
	JFormattedTextField txtCNPJ, txtTelefone;
	JComboBox <String> cbxStatus;
	MaskFormatter mascaraCNPJ, mascaraTelefone;
	String status[] = {"Ativo", "Inativo"};
	JButton btCadastrar, btLimpar, btSair, btConsultar;
	JPanel pnCampos, pnBotoes;
	BorderLayout layout;
	GridLayout gridCampos,gridBotoes;
	File arquivo = new File("Cliente.txt");
	
	public frmCliente () {
		setTitle("Cadastro de Cliente");
		setLayout(layout = new BorderLayout());
		setSize(423, 310);
		setLocation(50, 50);//Posicao que ele vai exibir
		
		//Instaciar Objetos
		pnCampos = new JPanel();
		pnBotoes = new JPanel();
		gridCampos = new GridLayout(4,2);
		gridBotoes = new GridLayout(1,4);
		lbNome = new JLabel("Razao social");
		lbCNPJ = new JLabel("Cnpj");
		lbTelefone = new JLabel("Telefone");
		lbStatus = new JLabel("Status");
		
		txtNome = new JTextField(20);
		try {
			mascaraCNPJ = new MaskFormatter (
				"##.###.###/####-##");
			mascaraTelefone = new MaskFormatter (
					"(##) ####-####");
		}catch(ParseException e) {
			System.err.println("Falha na mascara");
		}
		
		txtCNPJ = new JFormattedTextField(mascaraCNPJ);
		txtTelefone = new JFormattedTextField(mascaraTelefone);
		
		cbxStatus = new JComboBox<String>(status);
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setMnemonic('C');//Atalho pra cadastrar
		btCadastrar.setToolTipText("Cadastrar um cliente");//Mostra msg na tela
		btCadastrar.addActionListener(this);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setMnemonic('L');
		btLimpar.setToolTipText("Limpar");//Mensagem
		btLimpar.addActionListener(this);
		
		btSair = new JButton("Sair");
		btSair.setMnemonic('S');
		btSair.setToolTipText("Sair do cadastro");//Mensagem
		btSair.addActionListener(this);
		
		btConsultar = new JButton("Pesquisar");
		btConsultar.setMnemonic('f');
		btConsultar.setToolTipText("Consulta Cadastro");//Mensagem 
		btConsultar.addActionListener(this);
		
		pnCampos.setLayout(gridCampos);
		pnBotoes.setLayout(gridBotoes);
		
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbCNPJ);
		pnCampos.add(txtCNPJ);
		pnCampos.add(lbTelefone);
		pnCampos.add(txtTelefone);
		pnCampos.add(lbStatus);
		pnCampos.add(cbxStatus);
		add(pnCampos, BorderLayout.NORTH);
	
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btLimpar);
		pnBotoes.add(btConsultar);
		pnBotoes.add(btSair);
		add(pnBotoes, BorderLayout.SOUTH);
		
		setResizable(false);
		setVisible (true);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCadastrar) {
			try {
				//Se o arquivo nao existe cria
				if(!arquivo.exists()) {
					OutputStream fO = new FileOutputStream("Clientes.txt");
				}
				PrintWriter out = new PrintWriter(new FileWriter(arquivo, true));
				out.print(txtNome.getText());
				out.print(" | ");
				out.print(txtCNPJ.getText());
				out.print(" | ");
				out.print(txtTelefone.getText());
				out.print(" | ");
				out.println(status [
				                    cbxStatus.getSelectedIndex()]);
				out.close();
				JOptionPane.showMessageDialog(null, "Inclusao Realizada com sucesso",
						"inclusao no arquivo de texto" ,JOptionPane.INFORMATION_MESSAGE);
				setLimpar();
			}catch(IOException erro) {
				JOptionPane.showMessageDialog(null, "Erro na manipulação de texto" + erro,
						"Erro no arquivo texto",  JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == btLimpar) {
			setLimpar();
		}
		if(e.getSource() == btConsultar);{
			frmConsulta consulta = new frmConsulta(arquivo);
			consulta.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE);
		}
		if(e.getSource()== btSair) {
			System.exit(0);
		}
	}
	public void setLimpar() {
		txtNome.setText("");
		txtCNPJ.setText("");
		txtTelefone.setText("");
		cbxStatus.setSelectedIndex(0);
		txtNome.requestFocus();//Muda o focu do campo de digitar para o primeiro
	}
	public static void main(String[] args) {
		frmCliente frm = new frmCliente();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
