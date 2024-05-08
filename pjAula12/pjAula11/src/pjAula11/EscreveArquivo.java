package pjAula11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscreveArquivo {
	public static void main(String[] args) {
		String texto = "O que temos que ter sempre \n em mente é que a consulta aos diversos militantes aponta para a melhoria das direções preferenciais no sentido do progresso.";

		String nome_arq = "memoria.txt";
		File tstArquivo = new File(nome_arq) ;
		if(!tstArquivo.exists()) {
			try {
				tstArquivo.createNewFile();
			}catch (IOException e ) {
				e.printStackTrace();
			}
		}
		try {
			FileWriter arquivoSaida = new FileWriter(nome_arq);
			BufferedWriter buffer = new BufferedWriter(arquivoSaida);
			buffer.write(texto);
			buffer.close();
		}catch(IOException e) {
			System.out.println("Erro ao abrir arquivo");
		}
		//Estrutura para leitura
		try {
			FileReader arquivoLeitura = new FileReader(nome_arq);
			BufferedReader buffer = new BufferedReader(arquivoLeitura);
			String saida = buffer.readLine();
			while(saida != null ) {
				System.out.println(saida);
				saida = buffer.readLine();
			}
			buffer.close();
		}catch(IOException e ) {
			System.out.println("Erro ao Ler arquivo");
		}finally{
			
		}
	}
}