package pantallas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Usuario;
import elementosVisuales.ElementoListaUsuarios;

public class ListaUsuarios extends JPanel {

    private Ventana ventana;
    public ListaUsuarios(Ventana v) {
        this.ventana=v;
        setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("Usuarios Logeados");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(lblTitulo, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.WEST);

        JPanel listaUsuarios = new JPanel();
        scrollPane.setViewportView(listaUsuarios);
        listaUsuarios.setLayout(new BoxLayout(listaUsuarios, BoxLayout.Y_AXIS));

        ArrayList<Usuario> todos=Usuario.getTodos();

        for(int i=0;i<todos.size();i++) {
            listaUsuarios.add(new ElementoListaUsuarios(ventana, todos.get(i)));
        }

    }}

