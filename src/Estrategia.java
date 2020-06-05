

public abstract class Estrategia<T extends Comparable<T>>{
	private int intercambios=0;
	protected int comparaciones=0;
	
	public abstract T[] ordenar(T[] arreglo, int tiempo) throws InterruptedException;

	protected void intercambiar(T[] arreglo, int i, int j) {
		T temporal = arreglo[i];
		arreglo[i] = arreglo[j];
		arreglo[j] = temporal;
		this.intercambios++;
	}

	public int getIntercambios() {
		return intercambios;
	}

	public int getComparaciones() {
		return comparaciones;
	}

}
