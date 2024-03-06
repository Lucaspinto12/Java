package pjAula3;

import javax.sound.midi.SysexMessage;

public class Livraria {
	public static void main(String[] args) {
		Obra livro = new Obra();
		
		livro.setCodigo(123);
		livro.setTitulo("Percy");
		Autor autor = new Autor();
		autor.setCodigo(365);
		autor.setNome("Rick");
		autor.setSituacao(true);
		livro.setAutor(autor);
		
		livro.setPreco(174.2f);
		livro.setSituacao(false);
		
		System.out.println(livro);
		
		Obra outraObra = new Obra(879, "Harry",autor, 110, false);
		System.out.println(outraObra);
	}
}
