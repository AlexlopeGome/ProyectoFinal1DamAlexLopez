package pantallas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import clases.GastoExtra;
import elementosVisuales.ElementoListaGastosExtra;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaListaGastosExtra extends JPanel {
	/**
	 * Pantalla q contieNe el elemento Visual Corespondiente a su Clase 
	 * @author AlexLopez
	 *
	 */
    private Ventana ventana;
    public PantallaListaGastosExtra(Ventana v) {
        this.ventana=v;
        setLayout(new BorderLayout(0, 0));

        JLabel lblTitulo = new JLabel("Gastos Registrados");
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
        
      

        ArrayList<GastoExtra> todos=GastoExtra.getTodosGastosExtra();
        float precioTotal=0;
        for(int i=0;i<todos.size();i++) {
            listaUsuarios.add(new ElementoListaGastosExtra(ventana, todos.get(i)));
            precioTotal=precioTotal + todos.get(i).getImporte();
        }
        /**
         * Sumatoria de GastosExtra
         */
        JLabel lblTotalImporte = new JLabel("Total "+ precioTotal+"€");
        lblTotalImporte.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblTotalImporte.setForeground(Color.BLUE);
        add(lblTotalImporte, BorderLayout.EAST);
    }}

