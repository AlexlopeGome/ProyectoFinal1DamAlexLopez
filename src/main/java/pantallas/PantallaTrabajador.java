package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import clases.Trabajador;
import elementosVisuales.BotonAzul;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import exepciones.NombreInvalidoExceptions;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.TipoActividadDesenpeniada;

/**
 * Patalla pa crear un nuevo trabajador
 * 
 * @author AlexLopez
 *
 */
public class PantallaTrabajador extends JPanel {
	private Ventana ventana;

	private JTextField campoNombre;

	private JTextField campoTelefono;

	public PantallaTrabajador(Ventana v) {
		setLayout(null);
		this.ventana = v;

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelNombre.setForeground(new Color(0, 0, 0));
		labelNombre.setBackground(Color.WHITE);
		labelNombre.setToolTipText("");
		labelNombre.setBounds(104, 156, 232, 33);
		add(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setBackground(Color.WHITE);
		campoNombre.setBounds(452, 160, 105, 33);
		add(campoNombre);
		campoNombre.setColumns(10);

		JLabel Telefono = new JLabel("Telefono:");
		Telefono.setToolTipText("");
		Telefono.setForeground(new Color(0, 0, 0));
		Telefono.setFont(new Font("Tahoma", Font.BOLD, 23));
		Telefono.setBackground(Color.WHITE);
		Telefono.setBounds(104, 193, 232, 33);
		add(Telefono);

		campoTelefono = new JTextField();
		campoTelefono.setBounds(452, 197, 105, 33);
		add(campoTelefono);
		campoTelefono.setColumns(10);

		JLabel labelTipoActividadDesenpeniada = new JLabel("Tipo Actividad Desenpe\u00F1ada ");
		labelTipoActividadDesenpeniada.setToolTipText("");
		labelTipoActividadDesenpeniada.setForeground(new Color(0, 0, 0));
		labelTipoActividadDesenpeniada.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelTipoActividadDesenpeniada.setBackground(Color.WHITE);
		labelTipoActividadDesenpeniada.setBounds(42, 236, 333, 33);
		add(labelTipoActividadDesenpeniada);

		JButton botonCancelar = new BotonRojo("Cancelar");
		botonCancelar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				ventana.cambiarPantalla("Principal");
			}
		});
		botonCancelar.setBackground(new Color(255, 0, 0));
		botonCancelar.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonCancelar.setForeground(Color.BLACK);
		botonCancelar.setToolTipText("Cancelar");
		botonCancelar.setBounds(399, 397, 224, 37);
		add(botonCancelar);

		JLabel labelTrabajador = new JLabel("Trabajador");
		labelTrabajador.setFont(new Font("Tahoma", Font.BOLD, 29));
		labelTrabajador.setBounds(295, 27, 167, 31);
		add(labelTrabajador);
		;

		final JComboBox comboBoxTipoTrabajador = new JComboBox();
		comboBoxTipoTrabajador.setModel(new DefaultComboBoxModel(TipoActividadDesenpeniada.values()));
		comboBoxTipoTrabajador.setToolTipText(
				"PROFESOR,\r\nPROFESORA,\r\nASISTENTA,\r\nASISTENTE,\r\nCOCINERO\r\nCOCINERA\r\nLIMPIADORA\r\nLIPIADOR\r\nJARDINERO\r\nJARDINERA\r\nENTRENADOR\r\nENTRENADORA");
		comboBoxTipoTrabajador.setBounds(423, 241, 148, 28);
		add(comboBoxTipoTrabajador);

		JButton ListaTrabajadores = new BotonAzul("ListaTrabajadores");
		ListaTrabajadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.cambiarPantalla("listaTrabajadores");

			}
		});
		ListaTrabajadores.setBounds(89, 331, 148, 28);
		add(ListaTrabajadores);

		JLabel Fondo = new JLabel("");
		Fondo.addMouseListener(new MouseAdapter() {

		});
		Fondo.setBounds(-23, 11, 891, 499);
		;
		Fondo.setIcon(new ImageIcon("./fondos/Ventana_UsusarioAPI.jpg"));
		add(Fondo);

		BotonVerde botonAceptar = new BotonVerde("Aceptar");

		botonAceptar.setToolTipText("Aceptar");
		botonAceptar.setForeground(Color.BLACK);
		botonAceptar.setFont(new Font("Dialog", Font.PLAIN, 26));
		botonAceptar.setBounds(32, 399, 224, 37);
		add(botonAceptar);

		botonAceptar.addMouseListener(new MouseAdapter() {

			/**
			 * con este boton se registra el servicio
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * recogemos los datos introducidos
				 */

				try {
					String nombre = campoNombre.getText();
					int telefono = Integer.parseInt(campoTelefono.getText());
					TipoActividadDesenpeniada tipoTrabajador = (TipoActividadDesenpeniada) comboBoxTipoTrabajador
							.getSelectedItem();

					try {
						/**
						 * creamos un nuevo trabajador y le pasamos los parmetros recurados si todo esta
						 * correcto se introduria en base de datos si no salaran las exepciones
						 * corepondientes
						 */

						new Trabajador(nombre, telefono, tipoTrabajador);
					} catch (NombreInvalidoExceptions e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(ventana, "Registro ok", "Resgitro completado",
							JOptionPane.PLAIN_MESSAGE);
				} catch (SQLException e1) {
					System.out.println(e1);
					e1.printStackTrace();
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}
}
