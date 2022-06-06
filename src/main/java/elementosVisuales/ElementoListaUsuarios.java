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
                
                
                        JLabel lblNick = new JLabel(this.usuario.getNick());
                        GridBagConstraints gbc_lblNick = new GridBagConstraints();
                        gbc_lblNick.gridwidth = 3;
                        gbc_lblNick.insets = new Insets(0, 0, 5, 5);
                        gbc_lblNick.gridx = 4;
                        gbc_lblNick.gridy = 2;
                        add(lblNick, gbc_lblNick);
                
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
                        gbc_btnBorrarUsuario.gridx = 8;
                        gbc_btnBorrarUsuario.gridy = 2;
                        add(btnBorrarUsuario, gbc_btnBorrarUsuario);
                
                JLabel lblNombre = new JLabel(this.usuario.getNombre());
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
                
                JLabel lblapellidos = new JLabel(this.usuario.getApellidos());
                GridBagConstraints gbc_lblapellidos = new GridBagConstraints();
                gbc_lblapellidos.insets = new Insets(0, 0, 5, 5);
                gbc_lblapellidos.gridx = 5;
                gbc_lblapellidos.gridy = 4;
                add(lblapellidos, gbc_lblapellidos);
                
                JLabel lblGuion_3 = new JLabel("-");
                GridBagConstraints gbc_lblGuion_3 = new GridBagConstraints();
                gbc_lblGuion_3.insets = new Insets(0, 0, 5, 5);
                gbc_lblGuion_3.gridx = 6;
                gbc_lblGuion_3.gridy = 4;
                add(lblGuion_3, gbc_lblGuion_3);
                
                JLabel lbldireccion = new JLabel(usuario.getDireccion());
                GridBagConstraints gbc_lbldireccion = new GridBagConstraints();
                gbc_lbldireccion.insets = new Insets(0, 0, 5, 5);
                gbc_lbldireccion.gridx = 7;
                gbc_lbldireccion.gridy = 4;
                add(lbldireccion, gbc_lbldireccion);
        
                JLabel lblCorreo = new JLabel(this.usuario.getCorreo());
                GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
                gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
                gbc_lblCorreo.gridx = 3;
                gbc_lblCorreo.gridy = 5;
                add(lblCorreo, gbc_lblCorreo);
        
                JLabel lblGuion = new JLabel("-");
                GridBagConstraints gbc_lblGuion = new GridBagConstraints();
                gbc_lblGuion.insets = new Insets(0, 0, 5, 5);
                gbc_lblGuion.gridx = 4;
                gbc_lblGuion.gridy = 5;
                add(lblGuion, gbc_lblGuion);
        
                JLabel lblFechaNacimiento = new JLabel(this.usuario.getFechaNacimiento().toString());
                GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
                gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
                gbc_lblFechaNacimiento.gridx = 5;
                gbc_lblFechaNacimiento.gridy = 5;
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
                gbc_btnEditarUsuario.insets = new Insets(0, 0, 5, 0);
                gbc_btnEditarUsuario.gridx = 8;
                gbc_btnEditarUsuario.gridy = 5;
                add(btnEditarUsuario, gbc_btnEditarUsuario);
    }

	
}


