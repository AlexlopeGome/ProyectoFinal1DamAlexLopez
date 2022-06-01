package pantallas;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.EmptyBorder;

import clases.Usuario;
import elementosVisuales.BotonAzul;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import exepciones.ContraseniaIncorrectaException;
import exepciones.UsuarioNoExisteException;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class QueHacer extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");

	public QueHacer(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u00BFQue Haceos?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(236, 21, 201, 51);
		add(lblNewLabel);
		
		
		JButton botonGastos = new BotonRojo("Gastos");
		botonGastos.setFont(new Font("Dialog", Font.PLAIN, 20));
		botonGastos.setBounds(139, 245, 107, 37);
		add(botonGastos);
		
		JButton botonIngresos = new BotonVerde("Ingresos");
		botonIngresos.setFont(new Font("Dialog", Font.PLAIN, 20));
		botonIngresos.setBounds(282, 245, 114, 37);
		add(botonIngresos);
		
		JButton BotonEditar = new BotonAzul("editarPerfil");
		BotonEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("editar");
			}
		});
		BotonEditar.setFont(new Font("Dialog", Font.PLAIN, 20));
		BotonEditar.setBounds(441, 245, 138, 37);
		add(BotonEditar);
		
		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\Ventana_UsusarioAPI.jpg"));
		Fondo.setBounds(0, 0, 658, 439);
		add(Fondo);
		
	
		
		
		


		
	
		
	

		

}
}


