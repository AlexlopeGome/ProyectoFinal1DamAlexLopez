package dialogoEmergentes;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import clases.Usuario;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import exepciones.ContraseniaVaciaException;
import exepciones.CorreoInvalidoException;
import exepciones.NombreInvalidoExceptions;

import pantallas.Ventana;

public class EmergenteEditarUsuario extends JDialog {

	private Ventana madre;
	private Usuario usuarioAEditar;
	private JTextField campoNombre;
	private JTextField campoCorreo;
	private JPasswordField campoContraseña;
	private JTextField campoApellidos;
	private JTextField campoNumeroHijos;
	private JTextField campoNick;
	private JTextField campoDireccion;

	public EmergenteEditarUsuario(Ventana v, Usuario u) {
		madre = v;
		usuarioAEditar = u;
		this.setSize(500, 334);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblTitulo = new JLabel("Editar usuario");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 6;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 1;
		getContentPane().add(lblTitulo, gbc_lblTitulo);

		JButton btnAceptar = new BotonVerde("Aceptar");
		final EmergenteEditarUsuario thisRef = this;
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nuevoNombre = campoNombre.getText();
				String nuevoEmail = campoCorreo.getText();
				String nuevosApellidos = campoApellidos.getText();
				String nuevaDireccion = campoDireccion.getText();
				String nuevaContraseña = new String(campoContraseña.getPassword());
				String nuevoHijos = campoNumeroHijos.getText();
				String nuevoNick = campoNick.getText();

				try {

					usuarioAEditar.setNombre(nuevoNombre);
					usuarioAEditar.setCorreo(nuevoEmail);
					usuarioAEditar.setApellidos(nuevosApellidos);
					usuarioAEditar.setDireccion(nuevaDireccion);
					usuarioAEditar.setNumehijos(nuevoHijos);
					usuarioAEditar.setNick(nuevoNick);
					usuarioAEditar.setContresnia(nuevaContraseña);

					dispose();
				} catch (SQLException | CorreoInvalidoException | ContraseniaVaciaException e3) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(thisRef, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);

		campoNombre = new JTextField(this.usuarioAEditar.getNombre());
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 3;
		getContentPane().add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 4;
		getContentPane().add(lblApellidos, gbc_lblApellidos);
		campoApellidos = new JTextField(this.usuarioAEditar.getApellidos());
		campoApellidos.setColumns(10);
		GridBagConstraints gbc_campoApellidos = new GridBagConstraints();
		gbc_campoApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_campoApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoApellidos.gridx = 3;
		gbc_campoApellidos.gridy = 4;
		getContentPane().add(campoApellidos, gbc_campoApellidos);

		JLabel lblDireccion = new JLabel("Direccion");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 1;
		gbc_lblDireccion.gridy = 5;
		getContentPane().add(lblDireccion, gbc_lblDireccion);

		campoDireccion = new JTextField(this.usuarioAEditar.getDireccion());
		campoDireccion.setColumns(10);
		GridBagConstraints gbc_campoDireccion = new GridBagConstraints();
		gbc_campoDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_campoDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDireccion.gridx = 3;
		gbc_campoDireccion.gridy = 5;
		getContentPane().add(campoDireccion, gbc_campoDireccion);

		JLabel lblEmail = new JLabel("Correo");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		getContentPane().add(lblEmail, gbc_lblEmail);

		campoCorreo = new JTextField(this.usuarioAEditar.getContrenia());
		GridBagConstraints gbc_campoCorreo = new GridBagConstraints();
		gbc_campoCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_campoCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoCorreo.gridx = 3;
		gbc_campoCorreo.gridy = 6;
		getContentPane().add(campoCorreo, gbc_campoCorreo);
		campoCorreo.setColumns(10);

		JLabel lblNumerohijos = new JLabel("Numero Hijos");
		GridBagConstraints gbc_lblNumerohijos = new GridBagConstraints();
		gbc_lblNumerohijos.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumerohijos.gridx = 1;
		gbc_lblNumerohijos.gridy = 7;
		getContentPane().add(lblNumerohijos, gbc_lblNumerohijos);

		campoNumeroHijos = new JTextField(this.usuarioAEditar.getNumehijos());
		campoNumeroHijos.setColumns(10);
		GridBagConstraints gbc_campoNumeroHijos = new GridBagConstraints();
		gbc_campoNumeroHijos.insets = new Insets(0, 0, 5, 5);
		gbc_campoNumeroHijos.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNumeroHijos.gridx = 3;
		gbc_campoNumeroHijos.gridy = 7;
		getContentPane().add(campoNumeroHijos, gbc_campoNumeroHijos);

		JLabel lblNick = new JLabel("Nick");
		GridBagConstraints gbc_lblNick = new GridBagConstraints();
		gbc_lblNick.anchor = GridBagConstraints.EAST;
		gbc_lblNick.insets = new Insets(0, 0, 5, 5);
		gbc_lblNick.gridx = 1;
		gbc_lblNick.gridy = 8;
		getContentPane().add(lblNick, gbc_lblNick);

		campoNick = new JTextField(this.usuarioAEditar.getNick());
		campoNick.setColumns(10);
		GridBagConstraints gbc_campoNick = new GridBagConstraints();
		gbc_campoNick.insets = new Insets(0, 0, 5, 5);
		gbc_campoNick.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNick.gridx = 3;
		gbc_campoNick.gridy = 8;
		getContentPane().add(campoNick, gbc_campoNick);
		
				JLabel lblContraseña = new JLabel("Contrase\u00F1a");
				GridBagConstraints gbc_lblContraseña = new GridBagConstraints();
				gbc_lblContraseña.anchor = GridBagConstraints.EAST;
				gbc_lblContraseña.insets = new Insets(0, 0, 5, 5);
				gbc_lblContraseña.gridx = 1;
				gbc_lblContraseña.gridy = 9;
				getContentPane().add(lblContraseña, gbc_lblContraseña);
		
				campoContraseña = new JPasswordField(this.usuarioAEditar.getContrenia().toString());
				GridBagConstraints gbc_campoContraseña = new GridBagConstraints();
				gbc_campoContraseña.insets = new Insets(0, 0, 5, 5);
				gbc_campoContraseña.fill = GridBagConstraints.HORIZONTAL;
				gbc_campoContraseña.gridx = 3;
				gbc_campoContraseña.gridy = 9;
				getContentPane().add(campoContraseña, gbc_campoContraseña);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.gridwidth = 4;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 11;
		getContentPane().add(btnAceptar, gbc_btnAceptar);

		JButton btnCancelar = new BotonRojo("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.gridwidth = 2;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 11;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}
}
