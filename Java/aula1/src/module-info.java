package aula1;


*//
* @lucas ferrera
* @data 06/02/2024
* Classe de modelagem conceito de Produto
* /
public class Produto {
	//Atributos
	int codigo;
	String descricao;
	float quantidade;
	
	//metodos
	void incluir(int id, String nome, float valor) {
		codigo = id;
		descricao = nome;
		quantidade = valor;
		//atividades de inclusao
	}
	
	void excluir() {
		//****
	}
	public static void main(String[] args) {
		System.out.println("Caio viado pra porra");
	}
}