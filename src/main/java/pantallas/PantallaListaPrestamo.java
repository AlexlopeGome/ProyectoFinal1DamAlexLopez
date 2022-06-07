package pantallas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import clases.Compra;
import clases.ExtraEscolar;
import clases.GastoExtra;
import clases.Prestamo;
import clases.Trabajador;
import clases.Usuario;
import elementosVisuales.ElementoListaCompras;
import elementosVisuales.ElementoListaExtraEscolar;
import elementosVisuales.ElementoListaGastosExtra;
import elementosVisuales.ElementoListaPrestamo;
import elementosVisuales.ElementoListaTrabajadores;
import elementosVisuales.ElementoListaUsuarios;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaListaPrestamo extends JPanel {

    private Ventana ventana;
    public PantallaListaPrestamo(Ventana v) {
        this.ventana=v;
        setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel(" Prestamos Registradas");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(lblTitulo, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.WEST);

        JPanel listaPrestamo  = new JPanel();
        scrollPane.setViewportView(listaPrestamo );
        listaPrestamo .setLayout(new BoxLayout(listaPrestamo , BoxLayout.Y_AXIS));
        
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

        ArrayList<Prestamo > todos=Prestamo.getTodosprestamo();

        for(int i=0;i<todos.size();i++) {
        	listaPrestamo.add(new  ElementoListaPrestamo(ventana, todos.get(i)));
        }

    }}

