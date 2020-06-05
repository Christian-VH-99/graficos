


public class PorSeleccion<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(T[] arreglo, int tiempo) throws InterruptedException {
		
		T menor;
		int i, j, posicionDelMenor;
		
		for (i = 0; i < arreglo.length - 1; i++) {
			Thread.sleep(tiempo);
			menor = arreglo[i];
			posicionDelMenor = i;
			for (j = i + 1; j < arreglo.length; j++) {
				super.comparaciones++;
				if (arreglo[j].compareTo(menor) < 0) {
					menor = arreglo[j];
					posicionDelMenor = j;
				}
			}
			if (posicionDelMenor != i) {
				intercambiar(arreglo, i, posicionDelMenor);
			}
		}
		return arreglo;
	}

}
