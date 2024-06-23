package main.java.tpi;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class VentanaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1003980624250494064L;
	private JPanel contentPane;
	private JLabel jLabelTituloPrincipal;
	private JButton jButtonEjecutar;
	private JScrollPane jScrollPane;
	private JTextArea jTextArea;
    private JButton jButtonLimpiar;
	private SimuladorControlador simuladorControlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(50, 50, 1024, 768);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		this.setTitle("UTN FRRE - Simulación 2024 - Trabajo Practico Integrador");
		
		this.jLabelTituloPrincipal = new JLabel("Simulador de call center bancario");
		this.jLabelTituloPrincipal.setFont(new Font("SansSerif", Font.PLAIN, 20));
		this.jLabelTituloPrincipal.setBounds(213, 0, 606, 33);
		this.contentPane.add(jLabelTituloPrincipal);
		
		this.jButtonEjecutar = new JButton("Ejecutar");
		this.jButtonEjecutar.setToolTipText("Ejecutar el simulador");
		this.jButtonEjecutar.setFont(new Font("SansSerif", Font.PLAIN, 13));
		this.jButtonEjecutar.setBounds(24, 109, 96, 23);
		this.jButtonEjecutar.addActionListener(this);
		this.contentPane.add(jButtonEjecutar);
		
		this.jTextArea = new JTextArea();
		this.jTextArea.setEditable(false);
		
		this.jScrollPane = new JScrollPane(jTextArea);
		this.jScrollPane.setBounds(29, 237, 975, 488);
		this.contentPane.add(jScrollPane);
		
		this.jButtonLimpiar = new JButton("Limpiar");
		this.jButtonLimpiar.setToolTipText("Limpiar el Area de Texto");
		this.jButtonLimpiar.setFont(new Font("SansSerif", Font.PLAIN, 13));
		this.jButtonLimpiar.setBounds(178, 173, 85, 23);
		this.jButtonLimpiar.addActionListener(this);
		this.contentPane.add(jButtonLimpiar);
		

	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() == jButtonEjecutar) {
			
			this.jTextArea.setText("");
			
			
			this.simuladorControlador = new SimuladorControlador();
			this.simuladorControlador.ejecutar();
			
			this.jTextArea.setText(simuladorControlador.getLogueoInicial().getTexto());				
			ArrayList<Logueo> logueos = (ArrayList<Logueo>) this.simuladorControlador.getLogueos();
			
			if (this.simuladorControlador.getLogueos() != null) {
				for (Logueo logueo : logueos) {
					this.jTextArea.setText(this.jTextArea.getText().concat(logueo.getTexto()));
				}
								
			}
			
			this.jTextArea.setText(this.jTextArea.getText().concat(simuladorControlador.getLogueoFinal().getTexto()));	
		}
		
		if(evento.getSource() == jButtonLimpiar) {
			this.jTextArea.setText("");	
		}
		
	}

}
