package pantallas;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

import elementosVisuales.BotonAzul;
import elementosVisuales.BotonVerde;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPrincipal extends JPanel {
	
	private Ventana ventanaPrincipal;
	private final JLabel label = new JLabel("");
	private JTextField txtNumber;

	public PantallaPrincipal(Ventana v) {
		setToolTipText("");
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(Color.WHITE);
		setLayout(null);
		
		
	 JButton btnbotonVerde = new BotonVerde("Vamos....");
	 btnbotonVerde.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 	}
	 });
		btnbotonVerde.addMouseListener(new MouseAdapter() {
			
			
		});
		add(btnbotonVerde);
		label.setBounds(544, 17, 0, 0);
		add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		JLabel lblIniciarSesion = new JLabel("Bienvenido");
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setBounds(260, 17, 215, 37);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblIniciarSesion);
		
		JButton btnbtnbotonVerde = new BotonVerde("Salir");
		btnbtnbotonVerde.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnbtnbotonVerde.setText("Salir");
		btnbtnbotonVerde.setForeground(Color.BLACK);
		btnbtnbotonVerde.setToolTipText("Salir");
		btnbtnbotonVerde.setBounds(260, 284, 224, 37);
		add(btnbtnbotonVerde);
		
		BotonVerde btnbtnbotonVerde_1 = new BotonVerde("Iniciar Sesion");
		btnbtnbotonVerde_1.setToolTipText("Iniciar Sesion");
		btnbtnbotonVerde_1.setText("Iniciar Sesion");
		btnbtnbotonVerde_1.setForeground(Color.BLACK);
		btnbtnbotonVerde_1.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnbtnbotonVerde_1.setBounds(260, 214, 224, 37);
		add(btnbtnbotonVerde_1);
		
		BotonVerde btnbtnbotonVerde_2 = new BotonVerde("Registro");
		btnbtnbotonVerde_2.setToolTipText("Registro");
		btnbtnbotonVerde_2.setText("Registro");
		btnbtnbotonVerde_2.setForeground(Color.BLACK);
		btnbtnbotonVerde_2.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnbtnbotonVerde_2.setBounds(260, 152, 224, 37);
		add(btnbtnbotonVerde_2);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\General_VentanasApi.jpg"));
		lblNewLabel.setBounds(-15, -62, 846, 493);
		add(lblNewLabel);
		
		
		
	
		
		
		
		


}
}


