/*
 * Exemplo de sobrecarga de metodos
 * @author Lucas Pinto
 * @data 05/05/2024
 * */
public class Calculadora {
	public long soma(long a, long b) {
		return a + b;
	}

	public long soma(int a, int b) {
		return a + b;
	}

	public long soma(int a, int b, int c) {
		return a + b + c;
	}

	public long soma(String a, String b) {
		return Long.parseLong(a) + Long.parseLong(b);
	}

	public long soma(String a, int b) {
		return Long.parseLong(a) + b;
	}

	public long soma(int a, String b) {
		return a + Long.parseLong(b);
	}

	public long soma(Integer... valores) {
		long resultado = 0;
		for (Integer i : valores) {
			resultado += i;
		}
		return resultado;
	}

	public long soma(String... valores) {
		long resultado = 0;
		for (String i : valores) {
			resultado += Long.parseLong(i);
		}
		return resultado;
	}

}
