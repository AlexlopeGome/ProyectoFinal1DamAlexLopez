package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import clases.GastoExtra;
import pantallas.Ventana;;

/**
 * pantalla q conmtiene una lista de los gastos extras
 * 
 * @author AlexLopez
 *
 */
public class ElementoListaGastosExtra extends JPanel {

	private Ventana ventana;
	private GastoExtra extra;

	/**
	 * Contructor ElemtosListaGastosExtra
	 * 
	 * @param v  de tipo ventana
	 * @param eX de tipo gasto extra
	 */
	public ElementoListaGastosExtra(Ventana v, GastoExtra eX) {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.GREEN));
		this.ventana = v;
		this.extra = eX;
		this.setMaximumSize(new Dimension(8000, 200));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 11, 9, 0, 90, 52, 123, 37, 98, 222, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./iconos/user2.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNick = new JLabel("");
		GridBagConstraints gbc_lblNick = new GridBagConstraints();
		gbc_lblNick.gridwidth = 3;
		gbc_lblNick.insets = new Insets(0, 0, 5, 5);
		gbc_lblNick.gridx = 4;
		gbc_lblNick.gridy = 2;
		add(lblNick, gbc_lblNick);

		JButton btnBorrarUsuario = new JButton("Borrar Gastos Extra");
		btnBorrarUsuario.addMouseListener(new MouseAdapter() {
			/**
			 * clic q elimina el gastoExtra
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				extra.eliminarGastoExtra();
			}
		});
		btnBorrarUsuario.setIcon(new ImageIcon("./iconos/delete.png"));
		GridBagConstraints gbc_btnBorrarUsuario = new GridBagConstraints();
		gbc_btnBorrarUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrarUsuario.gridx = 8;
		gbc_btnBorrarUsuario.gridy = 2;
		add(btnBorrarUsuario, gbc_btnBorrarUsuario);

		JLabel lblNombre = new JLabel(this.extra.getNombre());
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 4;
		add(lblNombre, gbc_lblNombre);

		JLabel lblGuion_2_3_1 = new JLabel("-");
		GridBagConstraints gbc_lblGuion_2_3_1 = new GridBagConstraints();
		gbc_lblGuion_2_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuion_2_3_1.gridx = 4;
		gbc_lblGuion_2_3_1.gridy = 4;
		add(lblGuion_2_3_1, gbc_lblGuion_2_3_1);

		JLabel lblImporteFijo = new JLabel(String.valueOf(this.extra.isImporteFijo()));
		GridBagConstraints gbc_lblImporteFijo = new GridBagConstraints();
		gbc_lblImporteFijo.insets = new Insets(0, 0, 5, 5);
		gbc_lblImporteFijo.gridx = 5;
		gbc_lblImporteFijo.gridy = 4;
		add(lblImporteFijo, gbc_lblImporteFijo);

		JLabel lblGuion_2_2 = new JLabel("-");
		GridBagConstraints gbc_lblGuion_2_2 = new GridBagConstraints();
		gbc_lblGuion_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuion_2_2.gridx = 6;
		gbc_lblGuion_2_2.gridy = 4;
		add(lblGuion_2_2, gbc_lblGuion_2_2);

		JLabel lblimporte = new JLabel(String.valueOf(this.extra.getImporte()));
		GridBagConstraints gbc_lblimporte = new GridBagConstraints();
		gbc_lblimporte.insets = new Insets(0, 0, 5, 5);
		gbc_lblimporte.gridx = 7;
		gbc_lblimporte.gridy = 4;
		add(lblimporte, gbc_lblimporte);

		JLabel lblfecha = new JLabel(DateTimeFormatter.ISO_DATE.format(this.extra.getFecha()));
		GridBagConstraints gbc_lblfecha = new GridBagConstraints();
		gbc_lblfecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblfecha.gridx = 3;
		gbc_lblfecha.gridy = 5;
		add(lblfecha, gbc_lblfecha);

		JLabel lblGuion_2_3 = new JLabel("-");
		GridBagConstraints gbc_lblGuion_2_3 = new GridBagConstraints();
		gbc_lblGuion_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblGuion_2_3.gridx = 4;
		gbc_lblGuion_2_3.gridy = 5;
		add(lblGuion_2_3, gbc_lblGuion_2_3);

		JLabel lblCodigoMovimiento = new JLabel(String.valueOf(this.extra.getCodigoMovimiento()));
		GridBagConstraints gbc_lblCodigoMovimiento = new GridBagConstraints();
		gbc_lblCodigoMovimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoMovimiento.gridx = 5;
		gbc_lblCodigoMovimiento.gridy = 5;
		add(lblCodigoMovimiento, gbc_lblCodigoMovimiento);

	}

}
