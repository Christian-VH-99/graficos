


public class PorShellSort<T extends Comparable<T>> extends Estrategia<T>{

	public T[] ordenar(T[] arreglo,int tiempo) {
		int n = arreglo.length;

		for (int espacio = n / 2; espacio > 0; espacio /= 2) {
			for (int i = espacio; i < n; i += 1) {
				try {
					Thread.sleep(tiempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				T temporal = arreglo[i];
				int j;
				for (j = i; j >= espacio && arreglo[j - espacio].compareTo(temporal) > 0; j -= espacio) {
					super.comparaciones++;
					arreglo[j] = arreglo[j - espacio];
				}
					
				arreglo[j] = temporal;
			}
		}
		return arreglo;
	}


}
