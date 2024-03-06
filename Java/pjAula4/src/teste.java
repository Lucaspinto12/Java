public class teste {
	public static void main(String[] args) {
		Calculadora calcular = new Calculadora();
		long v1 = 45;
		long v2 = 65;

		int a = 123;
		int b = 231;
		System.out.println(calcular.soma(v1, v2));
		System.out.println(calcular.soma(a, b));

		System.out.println(calcular.soma("5", "1"));
		System.out.println(calcular.soma(5, 8, 3));
		System.out.println(calcular.soma(5, 32 - 5, -32));
		System.out.println(calcular.soma("5", "32", "-5", "-32"));
	}
}
