


public class Ordenadora<T extends Comparable<T>> {

	private Estrategia<T> estrategia = new PorShellSort<>();
	
	
	public T[] ordenar(T[] arreglo, int tiempo) throws InterruptedException {
		return this.estrategia.ordenar(arreglo,tiempo);
	}
	
	public void setEstrategia(Estrategia<T> estrategia) {
		this.estrategia = estrategia;
	}

	
	
}
