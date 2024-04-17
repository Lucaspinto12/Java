package br.unisal.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisal.modelagem.Produto;
import br.unisal.modelagem.Situacao;
import br.unisal.modelagem.UnidadeMedida;

public class frmProduto extends JFrame implements ActionListener{
	JLabel lbCodigo, lbDescricao, lbUnidadeMedida, lbLargura,
		lbComprimento, lbSituacao, lbLocalizacao;
	JTextField txtCodigo, txtDescricao, txtLargura,
	txtComprimento, txtLocalizacao;
	JComboBox cbxUnidadeMedida, cbxSituacao;
	JPanel pnCampos, pnBotoes;
	JButton btnInclui, btnExclui, btnAltera, btnPesquisa;
	List<Produto>bdProduto = new ArrayList<Produto>();

	public frmProduto() {
		super("Cadastrado de Produto");
		setSize(470,225);
		setLayout(new BorderLayout());
		
		//Passo construir os objetos
		lbCodigo = new JLabel("Código");
		lbDescricao = new JLabel("Descricao");
		lbUnidadeMedida = new JLabel("Unidade de Medida");
		lbLargura = new JLabel("Largura");
		lbComprimento = new JLabel("Comprimento");
		lbSituacao = new JLabel("Situação");
		lbLocalizacao = new JLabel("Localização");
		
		
		txtCodigo = new JTextField();
		txtDescricao = new JTextField();
		
		txtLargura = new JTextField();
		txtComprimento = new JTextField();
		cbxSituacao = new JComboBox<Situacao>
		(Situacao.values());
		cbxUnidadeMedida = new JComboBox<String>
		(UnidadeMedida.getUnidades());
		txtLocalizacao = new JTextField();
		
		btnInclui = new JButton("Adicionar");
		btnAltera = new JButton("Alterar");
		btnExclui = new JButton("Excluir");
		btnPesquisa = new JButton("Pesquisar");
		
		pnCampos = new JPanel (new GridLayout(7,2));
		pnBotoes = new JPanel (new GridLayout(1,4));
		
		//Adicionar campos na tela
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		pnCampos.add(lbDescricao);
		pnCampos.add(txtDescricao);
		pnCampos.add(lbUnidadeMedida);
		pnCampos.add(cbxUnidadeMedida);
		pnCampos.add(lbLargura);
		pnCampos.add(txtLargura);
		pnCampos.add(lbComprimento);
		pnCampos.add(txtComprimento);
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
		pnCampos.add(lbLocalizacao);
		pnCampos.add(txtLocalizacao);
		
		add(pnCampos, BorderLayout.CENTER);
		
		pnBotoes.add(btnInclui);
		pnBotoes.add(btnAltera);
		pnBotoes.add(btnExclui);
		pnBotoes.add(btnPesquisa);
		
		add(pnBotoes, BorderLayout.SOUTH);
		
		//incluir os elemontodno listener de acao
		btnInclui.addActionListener(this);
		btnAltera.addActionListener(this);
		btnExclui.addActionListener(this);
		btnPesquisa.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInclui) {
			Produto p = instanciar();
			if(p!=null) {
				bdProduto.add(p);
			}
			bdProduto.add(instanciar());
			
		}
		if(e.getSource()== btnAltera) {
			for(Produto p : bdProduto) {
				if(p.getCodigo() == p.getCodigo()) {
					Produto objeto = instanciar();
					if(objeto !=null) {
						p =objeto;
					}
				}
			}
		}
	System.out.println(bdProduto);
	}
	private Produto instanciar() {
		Produto p = new Produto();
		try {
			p.setCodigo(Integer.parseInt(txtCodigo.getText()));
		}catch(NumberFormatException e ) {
			JOptionPane.showMessageDialog(null,"Codigo produto invalido" , 
					"Validade ", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		p.setDescricao(txtDescricao.getText());
		p.setUn(UnidadeMedida.values()[
		                               cbxUnidadeMedida.getSelectedIndex()]);
		try {
			p.setLargura(Integer.parseInt(txtLargura.getText()));
		}catch(NumberFormatException e ) {
			JOptionPane.showMessageDialog(null,"Largura do produto invalido" , 
					"Validade ", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		try {
			p.setComprimento(Integer.parseInt(txtComprimento.getText()));
		}catch(NumberFormatException e ) {
			JOptionPane.showMessageDialog(null,"Comprimento do produto invalido" , 
					"Validade ", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		p.setSituacao(Situacao.values()[
			cbxSituacao.getSelectedIndex()]);
		p.setLocalizacao(txtLocalizacao.getText());
		return p;
	}
	public static void main(String[] args) {
		frmProduto frm = new frmProduto();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
