package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import elementosVisuales.BotonAzul;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Esta pantalla nos indica que queros hacer con sus correspondientes botones
 * 
 * @author AlexLopez
 *
 */
public class QueHacer extends JPanel {

	private Ventana ventana;
	private final JLabel label = new JLabel("");

	public QueHacer(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JLabel lblNewLabel = new JLabel("¿Que Hacemos?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(236, 21, 213, 50);
		add(lblNewLabel);

		JButton botonIngresos = new BotonVerde("Ingresos");
		botonIngresos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("ingresos");
			}
		});
		botonIngresos.setFont(new Font("Dialog", Font.PLAIN, 20));
		botonIngresos.setBounds(275, 317, 114, 37);
		add(botonIngresos);

		JButton BotonEditar = new BotonAzul("editarPerfil");
		BotonEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("editar");
			}
		});
		BotonEditar.setFont(new Font("Dialog", Font.PLAIN, 20));
		BotonEditar.setBounds(422, 317, 138, 37);
		add(BotonEditar);

		JButton BotonGastos = new BotonRojo("Gastos");
		BotonGastos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ventana.cambiarPantalla("gastos");
			}

		});
		BotonGastos.setFont(new Font("Dialog", Font.PLAIN, 20));
		BotonGastos.setBounds(115, 317, 114, 37);
		add(BotonGastos);

		JButton BotonAtras = new JButton("Atras");
		BotonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("Principal");
			}
		});
		BotonAtras.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BotonAtras.setBackground(Color.YELLOW);
		BotonAtras.setForeground(Color.BLACK);
		BotonAtras.setBounds(74, 119, 104, 37);
		add(BotonAtras);

		JButton botonSalir = new BotonRojo("Salir");
		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(ABORT);
			}
		});
		botonSalir.setBackground(new Color(255, 0, 0));
		botonSalir.setFont(new Font("Dialog", Font.PLAIN, 23));
		botonSalir.setText("Salir");
		botonSalir.setForeground(Color.BLACK);
		botonSalir.setToolTipText("Salir");
		botonSalir.setBounds(548, 30, 85, 29);
		add(botonSalir);

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(new ImageIcon("./fondos/Ventana_UsusarioAPI.jpg"));
		Fondo.setBounds(-23, 11, 891, 499);
		add(Fondo);

	}
}
