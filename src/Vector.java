
public class Vector {
	private Integer[] vector;
	private int cantidadElementos;
	private int maximo;

	public Vector(int cantidadElementos) {
		this.vector = new Integer[cantidadElementos];
		this.cantidadElementos = cantidadElementos;
	}
	public void cargarVectorOrdenado() {
		for (int i = 0; i < this.cantidadElementos; i++) {
			vector[i] = i + 1;
		}
		this.maximo=this.cantidadElementos;
	}

	public void cargarVectorSemiordenado() {
		for (int i = 0; i < this.cantidadElementos; i++) {
			if (i % 3 == 0) {
				vector[i] = (int) (Math.random() * (cantidadElementos + 10));
			} else {
				vector[i] = i + 1;
			}
			if(this.vector[i]>this.maximo) {
                this.maximo=this.vector[i];
            }
		}
		
	}

	public void cargarVectorAleatorio() {
		for (int i = 0; i < this.cantidadElementos; i++) {
			vector[i] = (int) (Math.random() * (cantidadElementos + 10));
			if(this.vector[i]>this.maximo) {
                this.maximo=this.vector[i];
            }
		}
	}

	public void cargarVectorSemiInverso() {
		for (int i = 1; i <= this.cantidadElementos; i++) {
			if (i % 3 == 0) {
				vector[this.cantidadElementos - i] = (int) (Math.random() * (cantidadElementos + 10));
			} else {
				this.vector[this.cantidadElementos - i] = i;
			}
			if(this.vector[i]>this.maximo) {
                this.maximo=this.vector[i];
            }
		}
	}

	public void cargarVectorInverso() {
		for (int i = 1; i <= this.cantidadElementos; i++) {
			this.vector[this.cantidadElementos - i] = i;
		}
		this.maximo = this.cantidadElementos;
	}

	public Integer[] getVector() {
		return vector;
	}

	public void setVector(Integer[] vector) {
		this.vector = vector;
	}

	public int getMaximo() {
		return maximo;
	}
	public int getCantidadElementos() {
		return cantidadElementos;
	}
	
//	public static void main(String[] args) {
//		Vector vec = new Vector(10);
//		vec.cargarVectorSemiInverso();
//		for (Integer i : vec.getVector()) {
//			System.out.print(i+" ");
//		}
//	}
}
