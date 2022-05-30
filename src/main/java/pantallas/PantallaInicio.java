package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import elementosVisuales.BotonVerde;

public class PantallaInicio extends JPanel {
	
	private Ventana ventanaPrincipal;
	private final JLabel label = new JLabel("");
	private JTextField txtNumber;

	public PantallaInicio(Ventana v) {
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
		JLabel lblIniciarSesion = new JLabel("Home Manager");
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setBounds(235, 17, 243, 37);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblIniciarSesion);
		
		JButton btnbtnbotonVerde = new BotonVerde("Vamoss....");
		btnbtnbotonVerde.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnbtnbotonVerde.setText("Lets GO....");
		btnbtnbotonVerde.setForeground(Color.BLACK);
		btnbtnbotonVerde.setToolTipText("Vamos....");
		btnbtnbotonVerde.setBounds(235, 229, 224, 37);
		add(btnbtnbotonVerde);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\inicioApi.jpg"));
		lblNewLabel.setBounds(-13, -17, 846, 493);
		add(lblNewLabel);
		
		
		
		


}


}


