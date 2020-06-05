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
//	private JComboBox ordenVectorBox;
	private JComboBox algoritmoBox;

	boolean bandera = false;
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
		setBounds(100, 100, 1000, 518);
		Panel = new JPanel();
		Panel.setBackground(Color.LIGHT_GRAY);
		Panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel);
		Panel.setLayout(null);
		
		JLabel tipoAgoritmo = new JLabel("Seleccione Algoritmo");
		tipoAgoritmo.setFont(new Font("Arial", Font.BOLD, 13));
		tipoAgoritmo.setBounds(10, 392, 168, 24);
		Panel.add(tipoAgoritmo);
		
		JComboBox<String> algoritmoBox = new JComboBox<String>();
		algoritmoBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		algoritmoBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccion", "Burbujeo", "Insercion"}));
		algoritmoBox.setBounds(243, 394, 102, 20);
		Panel.add(algoritmoBox);
		
		JLabel lblNewLabel = new JLabel("Selecciones orden de entrada");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 427, 205, 14);
		Panel.add(lblNewLabel);
		
		JComboBox ordenVectorBox = new JComboBox();
		ordenVectorBox.setModel(new DefaultComboBoxModel(new String[] {"Ordenado", "Semi-ordenado", "Aleatorio", "Semi-inverso", "Inverso"}));
//		ordenVectorBox.setBounds(243, 425, 124, 20);
//		ordenVectorBox.addItem("Ordenado");
//		ordenVectorBox.addItem("Semi-ordenado");
//		ordenVectorBox.addItem("Aleatorio");
//		ordenVectorBox.addItem("Semi-invertido");
//		ordenVectorBox.addItem("Invertido");
		Panel.add(ordenVectorBox);
		ordenVectorBox.addActionListener(ordenVectorBox);
		
		JButton cargarButton = new JButton("Cargar");
		cargarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bandera = true;
				repaint();
			}
		});
		cargarButton.setBounds(417, 383, 116, 45);
		Panel.add(cargarButton);
		
		JButton ordenarButton = new JButton("Ordenar");
		ordenarButton.setBounds(586, 383, 116, 45);
		Panel.add(ordenarButton);
		
		JLabel cantidadElementos = new JLabel("Ingrese tama\u00F1o del vector");
		cantidadElementos.setFont(new Font("Arial", Font.BOLD, 13));
		cantidadElementos.setHorizontalAlignment(SwingConstants.LEFT);
		cantidadElementos.setBounds(10, 357, 168, 24);
		Panel.add(cantidadElementos);
		
		cantElementosVector = new JTextField();
		cantElementosVector.setBounds(243, 360, 86, 20);
		Panel.add(cantElementosVector);
		cantElementosVector.setColumns(10);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		if(bandera == true) {
			int elementos = Integer.parseInt(cantElementosVector.getText());
			Vector vector = new Vector(elementos);
			vector.cargarVectorAleatorio();
			String pepe = (String)algoritmoBox.getName();
			System.out.println(pepe);
//			if(ordenVectorBox.getSelectedItem() != null) {
//				String tipoCarga = (String) ordenVectorBox.getSelectedItem();
//				System.out.println(tipoCarga);				
//			}
//			if(tipoCarga.equals("Ordenado")) {
//				vector.cargarVectorOrdenado();
//			}else if(tipoCarga.equals("Semi-ordenado")) {
//				vector.cargarVectorSemiordenado();
//			}else if(tipoCarga.equals("Aleatorio")) {
//				vector.cargarVectorAleatorio();
//			}else if(tipoCarga.equals("Semi-invertido")) {
//				vector.cargarVectorSemiInverso();
//			}else if(tipoCarga.equals("Invertido")) {
//				vector.cargarVectorInverso();	
//			}
//			int j = 0;
//			int xInicial = 5;
//			int yInicial = 0;
//			int yAltura = 370;
//			int ancho = 30;
//			int hueco = 10;
//			int mayot = vector.getCantidadElementos();
//			for(int i=0; i < vector.getCantidadElementos(); i++) {
//				g.setColor(Color.BLACK);
//				g.fillRect(xInicial,yInicial + yAltura - 10,ancho,i);
//				xInicial +=hueco;
//			}
		}
	}
}
