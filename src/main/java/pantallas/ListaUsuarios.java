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

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Pantalla q contieNe el elemento Visual Corespondiente a su Clase 
 * @author AlexLopez
 *
 */
public class ListaUsuarios extends JPanel {

    private Ventana ventana;
    public ListaUsuarios(Ventana v) {
        this.ventana=v;
        setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("Trabajadores Existentes");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(lblTitulo, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.WEST);

        JPanel listaUsuarios = new JPanel();
        scrollPane.setViewportView(listaUsuarios);
        listaUsuarios.setLayout(new BoxLayout(listaUsuarios, BoxLayout.Y_AXIS));
        
        JButton bontonAtras = new JButton("Atras");
        bontonAtras.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		ventana.cambiarPantalla("queHacer");
        	}
        });
        bontonAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
        bontonAtras.setForeground(Color.BLACK);
        bontonAtras.setBackground(Color.CYAN);
        add(bontonAtras, BorderLayout.SOUTH);

        ArrayList<Usuario> todos=Usuario.getTodos();

        for(int i=0;i<todos.size();i++) {
            listaUsuarios.add(new ElementoListaUsuarios(ventana, todos.get(i)));
        }

    }}

