package pjAula4;

public class TesteOperacao {
	public void calcular(OperacaoMatematica op, double a, double b) {
		System.out.println(op.calcular(a, b));

		if (op instanceof Soma) {
			System.out.println("Escolha uma Soma");
		} else if (op instanceof Subtracao) {
			System.out.println("Escolheu uma subtracao");
		}
	}

	public static void main(String[] args) {
		TesteOperacao teste = new TesteOperacao();

		teste.calcular(new Soma(), 123, 456);
		teste.calcular(new Subtracao(), 123, 456);
		Multiplicacao multi = new Multiplicacao();
		teste.calcular(( multi), 3, 2);
	}
}
