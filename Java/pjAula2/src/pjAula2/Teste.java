package pjAula2;

import java.util.Scanner;

/*
 * Classe de Modelagem conceitual de automovel
 * @author Lucas Pinto
 * @data 20/02/2024
 * */
public class Teste {
	public static void main(String[] args) {
		/*
		 * int i;
		 
		Automoveis carro = new Automoveis();
		carro.ano = 2005;
		carro.cor = "Azul";
		for(i=51; i <=171; i++) {
			System.out.println(i);
		}
		System.out.println(carro.valor);
		Cliente voce = new Cliente();
		voce.setNome("Igor");
		System.out.println(voce.getNome());
	*/
		Cliente [] agenda = new Cliente[5];
		for(int i = 0;i<5;i++) {
			Scanner digito = new Scanner(System.in);
			Cliente elemento = new Cliente();
			
			System.out.println("Informe o nome");
			elemento.setNome(digito.next());
			System.out.println("Informe o telefone");
			elemento.setTelefone(digito.nextFloat());
			System.out.println("Informe o email");
			elemento.setEmail(digito.next());
		
			agenda[i] = elemento;
			digito.close();
		}
		for(int i=0;i<5;i++) {
			System.out.println("Nome " + agenda[i].getNome() +
					"Telefone " + agenda[i].getTelefone());
		}
}
}