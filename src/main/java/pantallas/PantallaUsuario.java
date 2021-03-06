package pantallas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import clases.Usuario;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import exepciones.ApellidoInvalidoException;
import exepciones.ContraseniaVaciaException;
import exepciones.CorreoInvalidoException;
import exepciones.NombreInvalidoExceptions;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Esta pantalla la usamos para crear un nuebo usuario
 * 
 * @author AlexLopez
 *
 */
public class PantallaUsuario extends JPanel {
	private Ventana ventana;

	private JTextField campoNombre;
	private JTextField campoNick;
	private JTextField campohijos;
	private JTextField campoDireccion;
	private JTextField campoFechaNacimiento;
	private JTextField campoCorreo;
	private JPasswordField compoContrasenia;
	private JTextField campoHijos;
	private JTextField campoApellidos;

	public PantallaUsuario(Ventana v) {
		setLayout(null);
		this.ventana = v;

		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelNombre.setForeground(new Color(0, 0, 0));
		labelNombre.setBackground(Color.WHITE);
		labelNombre.setToolTipText("");
		labelNombre.setBounds(111, 82, 232, 33);
		add(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setBackground(Color.WHITE);
		campoNombre.setBounds(460, 82, 105, 33);
		add(campoNombre);
		campoNombre.setColumns(10);

		JLabel labelApellidos = new JLabel("Apellidos:");
		labelApellidos.setToolTipText("");
		labelApellidos.setForeground(new Color(0, 0, 0));
		labelApellidos.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelApellidos.setBackground(Color.WHITE);
		labelApellidos.setBounds(111, 119, 232, 33);
		add(labelApellidos);

		campoApellidos = new JTextField();
		campoApellidos.setBounds(460, 126, 105, 33);
		add(campoApellidos);
		campoApellidos.setColumns(10);

		JLabel labelCorreo;
		labelCorreo = new JLabel("Correo:");
		labelCorreo.setToolTipText("");
		labelCorreo.setForeground(new Color(0, 0, 0));
		labelCorreo.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelCorreo.setBackground(Color.WHITE);
		labelCorreo.setBounds(111, 163, 232, 33);
		add(labelCorreo);

		campoCorreo = new JTextField();
		campoCorreo.setBackground(Color.WHITE);
		campoCorreo.setBounds(460, 163, 105, 33);
		add(campoCorreo);
		campoCorreo.setColumns(10);

		JLabel labelFechaNacimento = new JLabel("Fecha Nacimento:");
		labelFechaNacimento.setToolTipText("");
		labelFechaNacimento.setForeground(new Color(0, 0, 0));
		labelFechaNacimento.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelFechaNacimento.setBackground(Color.WHITE);
		labelFechaNacimento.setBounds(111, 203, 232, 33);
		add(labelFechaNacimento);

		campoFechaNacimiento = new JTextField();
		campoFechaNacimiento.setBackground(Color.WHITE);
		campoFechaNacimiento.setBounds(460, 203, 105, 33);
		add(campoFechaNacimiento);
		campoFechaNacimiento.setColumns(10);

		JLabel labelDireccion = new JLabel("Direccion:");
		labelDireccion.setToolTipText("");
		labelDireccion.setForeground(new Color(0, 0, 0));
		labelDireccion.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelDireccion.setBackground(Color.WHITE);
		labelDireccion.setBounds(111, 247, 232, 33);
		add(labelDireccion);

		campoDireccion = new JTextField();
		campoDireccion.setBackground(Color.WHITE);
		campoDireccion.setBounds(460, 240, 105, 33);
		add(campoDireccion);
		campoDireccion.setColumns(10);

		JLabel labelHijos = new JLabel("Hijos:");
		labelHijos.setToolTipText("");
		labelHijos.setForeground(new Color(0, 0, 0));
		labelHijos.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelHijos.setBackground(Color.WHITE);
		labelHijos.setBounds(111, 279, 232, 33);
		add(labelHijos);

		campoHijos = new JTextField();
		campoHijos.setColumns(10);
		campoHijos.setBackground(Color.WHITE);
		campoHijos.setBounds(460, 279, 105, 33);
		add(campoHijos);

		JLabel labelNick = new JLabel("Nick:");
		labelNick.setToolTipText("");
		labelNick.setForeground(new Color(0, 0, 0));
		labelNick.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelNick.setBackground(Color.WHITE);
		labelNick.setBounds(111, 315, 232, 33);
		add(labelNick);

		campoNick = new JTextField();
		campoNick.setBackground(Color.WHITE);
		campoNick.setBounds(460, 315, 105, 33);
		add(campoNick);
		campoNick.setColumns(10);

		JLabel labelContrasenia = new JLabel("Contrase\u00F1a");
		labelContrasenia.setToolTipText("");
		labelContrasenia.setForeground(new Color(0, 0, 0));
		labelContrasenia.setFont(new Font("Tahoma", Font.BOLD, 23));
		labelContrasenia.setBackground(Color.WHITE);
		labelContrasenia.setBounds(111, 355, 232, 33);
		add(labelContrasenia);

		compoContrasenia = new JPasswordField();
		compoContrasenia.setBackground(Color.WHITE);
		compoContrasenia.setBounds(460, 355, 105, 31);
		add(compoContrasenia);

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

		JLabel labelRegistro = new JLabel("Registro");
		labelRegistro.setFont(new Font("Tahoma", Font.BOLD, 29));
		labelRegistro.setBounds(295, 27, 134, 31);
		add(labelRegistro);

		JLabel Fondo = new JLabel("");
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

		/**
		 * con este boton se registra el Usuario
		 */

		botonAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Recogemops los valores
				 */
				try {

					String nombre = campoNombre.getText();
					String apellidos = campoApellidos.getText();
					String correo = campoCorreo.getText();
					String contrasenia = new String(compoContrasenia.getPassword());
					String direccion = campoDireccion.getText();
					String fechaEnTexto = campoFechaNacimiento.getText();
					String[] fechaNaciPartida = fechaEnTexto.split("/");
					LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(fechaNaciPartida[2]),
							Integer.parseInt(fechaNaciPartida[1]), Integer.parseInt(fechaNaciPartida[0]));
					String numeroHijos = campoHijos.getText();
					String nick = campoNick.getText();

					try {
						/**
						 * creamos un nuevo Usuario y le pasamos los parmetros recurados si todo esta
						 * correcto se introduria en base de datos si no salaran las exepciones
						 * corepondientes
						 */

						new Usuario(nombre, apellidos, correo, contrasenia, fechaNacimiento, numeroHijos, direccion,
								nick);
						JOptionPane.showMessageDialog(ventana, "Registro ok", "Resgitro completado",
								JOptionPane.PLAIN_MESSAGE);
						ventana.cambiarPantalla("login");

					} catch (NombreInvalidoExceptions | ApellidoInvalidoException e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						JOptionPane.showMessageDialog(ventana, "Registro Fallido", "Resgitro no completado",
								JOptionPane.PLAIN_MESSAGE);
						e1.printStackTrace();
						System.err.println(e1);
					}

				} catch (ContraseniaVaciaException | CorreoInvalidoException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					System.err.println(e1);
					// TODO METER EL ERROR DEL SPLIT DE LA CONTRASE?A
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(ventana, "Formato erroneo, debe ser dd/mm/yyyy", "error",
							JOptionPane.ERROR_MESSAGE);
					System.err.println(e1);
				}

			}

		});

	}
}
