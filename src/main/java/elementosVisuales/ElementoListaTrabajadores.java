package elementosVisuales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import clases.EntidadConNombre;
import clases.Trabajador;
import clases.Usuario;
import dialogoEmergentes.EmergenteEditarTrabajador;
import dialogoEmergentes.EmergenteEditarUsuario;
import pantallas.Ventana;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElementoListaTrabajadores extends JPanel{

    private Ventana ventana;
    private Trabajador trabajador;

    public ElementoListaTrabajadores(Ventana v, Trabajador t) {
        setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.GREEN));
        this.ventana=v;
        this.trabajador=t;
        this.setMaximumSize(new Dimension(8000,200));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{11, 9, 0, 90, 52, 123, 37, 98, 222, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
                
                        JButton btnBorrarUsuario = new JButton("Borrar Trabajador");
                        btnBorrarUsuario.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                setVisible(false);
                                trabajador.eliminarTrabajador();
                            }
                        });
                        btnBorrarUsuario.setIcon(new ImageIcon("./iconos/delete.png"));
                        GridBagConstraints gbc_btnBorrarUsuario = new GridBagConstraints();
                        gbc_btnBorrarUsuario.insets = new Insets(0, 0, 5, 0);
                        gbc_btnBorrarUsuario.gridx = 8;
                        gbc_btnBorrarUsuario.gridy = 2;
                        add(btnBorrarUsuario, gbc_btnBorrarUsuario);
                
                JLabel lblNombre = new JLabel(this.trabajador.getNombre());
                GridBagConstraints gbc_lblNombre = new GridBagConstraints();
                gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
                gbc_lblNombre.gridx = 3;
                gbc_lblNombre.gridy = 4;
                add(lblNombre, gbc_lblNombre);
                
                JLabel lblGuion_2 = new JLabel("-");
                GridBagConstraints gbc_lblGuion_2 = new GridBagConstraints();
                gbc_lblGuion_2.insets = new Insets(0, 0, 5, 5);
                gbc_lblGuion_2.gridx = 4;
                gbc_lblGuion_2.gridy = 4;
                add(lblGuion_2, gbc_lblGuion_2);
                
                JLabel lblTelefono = new JLabel(String.valueOf(this.trabajador.getTelefono()));
                GridBagConstraints gbc_lblapellidos = new GridBagConstraints();
                gbc_lblapellidos.insets = new Insets(0, 0, 5, 5);
                gbc_lblapellidos.gridx = 5;
                gbc_lblapellidos.gridy = 4;
                add(lblTelefono, gbc_lblapellidos);
                
                JLabel lblGuion_3 = new JLabel("-");
                GridBagConstraints gbc_lblGuion_3 = new GridBagConstraints();
                gbc_lblGuion_3.insets = new Insets(0, 0, 5, 5);
                gbc_lblGuion_3.gridx = 4;
                gbc_lblGuion_3.gridy = 5;
                add(lblGuion_3, gbc_lblGuion_3);
        
                JLabel lblActividad = new JLabel(this.trabajador.getActivi());
                GridBagConstraints gbc_lblActividad = new GridBagConstraints();
                gbc_lblActividad.insets = new Insets(0, 0, 5, 5);
                gbc_lblActividad.gridx = 5;
                gbc_lblActividad.gridy = 5;
                add(lblActividad, gbc_lblActividad);
                
        
               
    }

	
}


