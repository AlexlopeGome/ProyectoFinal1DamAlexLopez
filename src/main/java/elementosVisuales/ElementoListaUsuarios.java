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

import clases.Usuario;
import dialogoEmergentes.EmergenteEditarUsuario;
import pantallas.Ventana;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElementoListaUsuarios extends JPanel{

    private Ventana ventana;
    private Usuario usuario;

    public ElementoListaUsuarios(Ventana v, Usuario u) {
        setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.GREEN));
        this.ventana=v;
        this.usuario=u;
        this.setMaximumSize(new Dimension(8000,70));
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{11, 9, 0, 90, 52, 123, 98, 222, 0};
        gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("./iconos/user2.png"));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        add(lblNewLabel, gbc_lblNewLabel);


        JLabel lblNombre = new JLabel(this.usuario.getNombre());
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.gridwidth = 3;
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 3;
        gbc_lblNombre.gridy = 1;
        add(lblNombre, gbc_lblNombre);

        JButton btnBorrarUsuario = new JButton("Borrar Usuario");
        btnBorrarUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                usuario.eliminar();
            }
        });
        btnBorrarUsuario.setIcon(new ImageIcon("./iconos/delete.png"));
        GridBagConstraints gbc_btnBorrarUsuario = new GridBagConstraints();
        gbc_btnBorrarUsuario.insets = new Insets(0, 0, 5, 0);
        gbc_btnBorrarUsuario.gridx = 7;
        gbc_btnBorrarUsuario.gridy = 1;
        add(btnBorrarUsuario, gbc_btnBorrarUsuario);

        JLabel lblEmail = new JLabel(this.usuario.getCorreo());
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
        gbc_lblEmail.gridx = 3;
        gbc_lblEmail.gridy = 3;
        add(lblEmail, gbc_lblEmail);

        JLabel lblGuion = new JLabel("-");
        GridBagConstraints gbc_lblGuion = new GridBagConstraints();
        gbc_lblGuion.insets = new Insets(0, 0, 0, 5);
        gbc_lblGuion.gridx = 4;
        gbc_lblGuion.gridy = 3;
        add(lblGuion, gbc_lblGuion);

        JLabel lblFechaNacimiento = new JLabel(this.usuario.getFechaNacimiento().toString());
        GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
        gbc_lblFechaNacimiento.insets = new Insets(0, 0, 0, 5);
        gbc_lblFechaNacimiento.gridx = 5;
        gbc_lblFechaNacimiento.gridy = 3;
        add(lblFechaNacimiento, gbc_lblFechaNacimiento);

        JButton btnEditarUsuario = new JButton("Editar Usuario");
        btnEditarUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnEditarUsuario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EmergenteEditarUsuario editor=new EmergenteEditarUsuario(ventana, usuario);
                editor.setVisible(true);
            }
        });
        btnEditarUsuario.setIcon(new ImageIcon("./iconos/edit.png"));
        GridBagConstraints gbc_btnEditarUsuario = new GridBagConstraints();
        gbc_btnEditarUsuario.gridx = 7;
        gbc_btnEditarUsuario.gridy = 3;
        add(btnEditarUsuario, gbc_btnEditarUsuario);
    }

}


