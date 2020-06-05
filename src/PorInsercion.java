


public class PorInsercion<T extends Comparable<T>> extends Estrategia<T>{

	public T[] ordenar(T[] arreglo,int tiempo) {

		for (int i = 1; i < arreglo.length; i++) {
			try {
				Thread.sleep(tiempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			T valorActual = arreglo[i];
			int j = i - 1;
			super.comparaciones++;
			while (j >= 0 && arreglo[j].compareTo(valorActual) > 0) {
				super.comparaciones++;
				arreglo[j + 1] = arreglo[j];
				j = j - 1;
			}
			arreglo[j + 1] = valorActual;
		}

		return arreglo;
	}

}
