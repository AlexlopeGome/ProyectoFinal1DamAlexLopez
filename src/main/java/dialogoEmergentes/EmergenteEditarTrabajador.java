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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import clases.Trabajador;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import enums.TipoActividadDesenpeniada;
import exepciones.ContraseniaVaciaException;
import exepciones.CorreoInvalidoException;
import exepciones.NickInvalidoExceptions;
import pantallas.Ventana;

public class EmergenteEditarTrabajador extends JDialog {

	private Ventana madre;
	private Trabajador trabajadorAEditar;
	private JTextField campoNombre;
	private JTextField campoTelefono;
	
	private JTextField campoActiviadad;
	private JTextField campoActividad;
;

	public EmergenteEditarTrabajador(Ventana v, Trabajador t) {
		madre = v;
		trabajadorAEditar = t;
		this.setSize(500, 334);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { -5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JButton btnAceptar = new BotonVerde("Aceptar");
		final EmergenteEditarTrabajador thisRef = this;
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String nuevoNombre = campoNombre.getText();
				int nuevoTelefono = Integer.parseInt(campoTelefono.getText());
				String nuevaActividad=campoActividad.getText();
				
				trabajadorAEditar.setNombre(nuevoNombre);
				trabajadorAEditar.setTelefono(nuevoTelefono);
				trabajadorAEditar.setActivi(nuevaActividad);
				dispose();

			}
		});
		
				JLabel lblTitulo = new JLabel("Lista Trabajadorores");
				lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 26));
				GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
				gbc_lblTitulo.gridwidth = 6;
				gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
				gbc_lblTitulo.gridx = 3;
				gbc_lblTitulo.gridy = 2;
				getContentPane().add(lblTitulo, gbc_lblTitulo);
	
	
	

		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);

		campoNombre = new JTextField(this.trabajadorAEditar.getNombre());
		GridBagConstraints gbc_campoNombre = new GridBagConstraints();
		gbc_campoNombre.insets = new Insets(0, 0, 5, 5);
		gbc_campoNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoNombre.gridx = 3;
		gbc_campoNombre.gridy = 3;
		getContentPane().add(campoNombre, gbc_campoNombre);
		campoNombre.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 4;
		getContentPane().add(lblTelefono, gbc_lblTelefono);
		campoTelefono = new JTextField(String.valueOf(this.trabajadorAEditar.getTelefono()));
		campoTelefono.setColumns(10);
		GridBagConstraints gbc_campoTelefono = new GridBagConstraints();
		gbc_campoTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_campoTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoTelefono.gridx = 3;
		gbc_campoTelefono.gridy = 4;
		getContentPane().add(campoTelefono, gbc_campoTelefono);
		
				JLabel lblActividad = new JLabel("Actividad");
				GridBagConstraints gbc_lblActividad = new GridBagConstraints();
				gbc_lblActividad.anchor = GridBagConstraints.EAST;
				gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
				gbc_lblActividad.gridx = 1;
				gbc_lblActividad.gridy = 5;
				getContentPane().add(lblActividad, gbc_lblActividad);
		
		campoActividad = new JTextField(this.trabajadorAEditar.getActivi());
		campoActividad.setColumns(10);
		GridBagConstraints gbc_campoActividad = new GridBagConstraints();
		gbc_campoActividad.insets = new Insets(0, 0, 5, 5);
		gbc_campoActividad.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoActividad.gridx = 3;
		gbc_campoActividad.gridy = 5;
		getContentPane().add(campoActividad, gbc_campoActividad);
		
		

		
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAceptar.gridwidth = 4;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 12;
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
		gbc_btnCancelar.gridy = 12;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}
}
