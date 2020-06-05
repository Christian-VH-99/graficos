import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Algoritmos extends JFrame implements Runnable {

	private JPanel Panel;
	private JTextField textField;
	private JTextField txtIngreseElAlgoritmo;
	private JTextField cantElementosVector;
	private JComboBox algoritmoBox;
	private JTextField tipoOrden;

	private Vector vector;
	boolean cargar = false;
	boolean ordenar = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Algoritmos frame = new Algoritmos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Algoritmos() {
		inicializar();
		this.setLocationRelativeTo(null);
	}

	private void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		Panel = new JPanel();
		Panel.setBackground(Color.LIGHT_GRAY);
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);

		JLabel tipoAgoritmo = new JLabel("Seleccione Algoritmo");
		tipoAgoritmo.setFont(new Font("Arial", Font.BOLD, 13));
		tipoAgoritmo.setBounds(10, 645, 168, 24);
		Panel.add(tipoAgoritmo);

		JComboBox<String> algoritmoBox = new JComboBox<String>();
		algoritmoBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		algoritmoBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Seleccion", "Burbujeo", "Insercion" }));
		algoritmoBox.setBounds(243, 647, 102, 20);
		Panel.add(algoritmoBox);

		JLabel lblNewLabel = new JLabel("Selecciones orden de entrada");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 680, 205, 14);
		Panel.add(lblNewLabel);

		JButton cargarButton = new JButton("Cargar");
		cargarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargar = true;
				repaint();
			}
		});
		cargarButton.setBounds(417, 636, 116, 45);
		Panel.add(cargarButton);

		JButton ordenarButton = new JButton("Ordenar");
		ordenarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargar = false;
				ordenar = true;
				repaint();
			}
		});
		ordenarButton.setBounds(586, 636, 116, 45);
		Panel.add(ordenarButton);

		JLabel cantidadElementos = new JLabel("Ingrese tama\u00F1o del vector");
		cantidadElementos.setFont(new Font("Arial", Font.BOLD, 13));
		cantidadElementos.setHorizontalAlignment(SwingConstants.LEFT);
		cantidadElementos.setBounds(10, 610, 168, 24);
		Panel.add(cantidadElementos);

		cantElementosVector = new JTextField();
		cantElementosVector.setBounds(243, 613, 86, 20);
		Panel.add(cantElementosVector);
		cantElementosVector.setColumns(10);

		tipoOrden = new JTextField();
		tipoOrden.setBounds(243, 678, 102, 20);
		Panel.add(tipoOrden);
		tipoOrden.setColumns(10);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		super.paint(g);
		int x = 10;
		int y = 35;
		int alto = 600;
		int hueco = 1;
		int ancho;

		if (cargar == true) {
			int elementos = Integer.parseInt(cantElementosVector.getText());
			vector = new Vector(elementos);
			vector.cargarVectorAleatorio();
			String tipoCarga = tipoOrden.getText();
			if (tipoCarga.equals("Ordenado")) {
				vector.cargarVectorOrdenado();
			} else if (tipoCarga.equals("Semi-ordenado")) {
				vector.cargarVectorSemiordenado();
			} else if (tipoCarga.equals("Aleatorio")) {
				vector.cargarVectorAleatorio();
			} else if (tipoCarga.equals("Semi-invertido")) {
				vector.cargarVectorSemiInverso();
			} else if (tipoCarga.equals("Invertido")) {
				vector.cargarVectorInverso();
			}

			ancho = (1024 - (vector.getCantidadElementos() * hueco)) / vector.getCantidadElementos();

			for (int i = 0; i < vector.getCantidadElementos(); i++) {
				g.setColor(Color.BLACK);
				g.fillRect(x,
						y + alto - (int) ((float) alto * (float) vector.getVector()[i] / (float) vector.getMaximo()),
						ancho, (int) ((float) alto * (float) vector.getVector()[i] / (float) vector.getMaximo()));
				x += hueco + ancho;

			}
		}

		if (ordenar == true) {
			System.out.println("pepe");

			ancho = (1024 - (vector.getCantidadElementos() * hueco)) / vector.getCantidadElementos();

			Ordenadora<Integer> ordenadora = new Ordenadora<Integer>();
			Estrategia<Integer> seleccion = new PorShellSort<Integer>();
			ordenadora.setEstrategia(seleccion);
			try {
				vector.setVector(ordenadora.ordenar(vector.getVector(), 0));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < vector.getCantidadElementos(); i++) {
				g.setColor(Color.MAGENTA);
				g.fillRect(x,
						y + alto - (int) ((float) alto * (float) vector.getVector()[i] / (float) vector.getMaximo()),
						ancho, (int) ((float) alto * (float) vector.getVector()[i] / (float) vector.getMaximo()));
				x += hueco + ancho;
			}
		}

	}
}
