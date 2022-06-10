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
import clases.Trabajador;
import clases.Usuario;
import elementosVisuales.ElementoListaCompras;
import elementosVisuales.ElementoListaExtraEscolar;
import elementosVisuales.ElementoListaGastosExtra;
import elementosVisuales.ElementoListaTrabajadores;
import elementosVisuales.ElementoListaUsuarios;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class PantallaListaCompras extends JPanel {
	/**
	 * Pantalla q contieNe el elemento Visual Corespondiente a su Clase 
	 * @author AlexLopez
	 *
	 */
    private Ventana ventana;
 
    private final JTextField textField = new JTextField();
    public PantallaListaCompras(Ventana v) {
    	textField.setColumns(10);
        this.ventana=v;
        setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel(" Compras Registradas");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(lblTitulo, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.WEST);

        JPanel listaCompra  = new JPanel();
        scrollPane.setViewportView(listaCompra);
        listaCompra .setLayout(new BoxLayout(listaCompra , BoxLayout.Y_AXIS));
        
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
        
      

        ArrayList<Compra> todos=Compra.getTodasCompras();
        float precioTotal=0;

        for(int i=0;i<todos.size();i++) {
        	listaCompra.add(new ElementoListaCompras(ventana, todos.get(i)));
            precioTotal=precioTotal + todos.get(i).getImporte();
        }
        /**
         * Sumatoria de compras
         */
        JLabel campoTotal = new JLabel("Total "+precioTotal+"€");
        campoTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
        campoTotal.setForeground(Color.BLUE);
        add(campoTotal, BorderLayout.EAST);
    }}


