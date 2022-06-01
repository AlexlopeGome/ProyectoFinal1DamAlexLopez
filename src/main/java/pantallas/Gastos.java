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

public class Gastos extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");

	public Gastos(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton btnNewButton = new BotonRojo("Compra");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(69, 228, 121, 33);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new BotonRojo("Extraescolar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(234, 336, 149, 33);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new BotonRojo("Prestamo");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(417, 228, 117, 33);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new BotonRojo("Otros Gastos");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(245, 161, 149, 33);
		add(btnNewButton_3);
		
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(0, 0, 640, 422);
		add(fondo);
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		

}
}


