package pantallas;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.EmptyBorder;

import clases.Usuario;
import elementosVisuales.BotonAzul;
import elementosVisuales.BotonRojo;
import elementosVisuales.BotonVerde;
import enums.TipoCompra;
import exepciones.ContraseniaIncorrectaException;
import exepciones.UsuarioNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PantallaCompra extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");
	private JTextField campoNombre;
	private JTextField campoImporte;
	private JTextField campoFecha;
	private JTextField campoComentario;
	private JTextField campoCodigoMovimiento;

	public PantallaCompra(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("queHacer");
				
			}
			
		
		});
		botonAtras.setBounds(10, 405, 89, 23);
		add(botonAtras);
		
		JLabel Compra = new JLabel("Compra");
		Compra.setFont(new Font("Tahoma", Font.BOLD, 29));
		Compra.setBounds(387, 44, 117, 50);
		add(Compra);
		
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre.setToolTipText("");
		Nombre.setBounds(276, 200, 117, 23);
		add(Nombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(417, 204, 117, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel Fijo = new JLabel("Es fijo");
		Fijo.setToolTipText("");
		Fijo.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fijo.setBounds(276, 234, 117, 23);
		add(Fijo);
		
		
		final JRadioButton siFijo = new JRadioButton("pulsar si es fijo");
		siFijo.setBounds(417, 237, 117, 23);
		add(siFijo);

		final JRadioButton noFijo = new JRadioButton("pulsar si no es fijo");
		noFijo.setBounds(543, 237, 117, 23);
		add(noFijo);
		
		JLabel Importe = new JLabel("Importe");
		Importe.setToolTipText("");
		Importe.setFont(new Font("Tahoma", Font.BOLD, 17));
		Importe.setBounds(276, 268, 117, 23);
		add(Importe);
		
		campoImporte = new JTextField();
		campoImporte.setColumns(10);
		campoImporte.setBounds(417, 272, 117, 20);
		add(campoImporte);
		
		JLabel Fecha = new JLabel("Fecha");
		Fecha.setToolTipText("");
		Fecha.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fecha.setBounds(276, 302, 117, 23);
		add(Fecha);
		
		campoFecha = new JTextField();
		campoFecha.setColumns(10);
		campoFecha.setBounds(417, 306, 117, 20);
		add(campoFecha);
		
		JLabel Comentario = new JLabel("Comentario");
		Comentario.setToolTipText("");
		Comentario.setFont(new Font("Tahoma", Font.BOLD, 17));
		Comentario.setBounds(276, 336, 117, 23);
		add(Comentario);
		
		campoComentario = new JTextField();
		campoComentario.setColumns(10);
		campoComentario.setBounds(417, 337, 243, 20);
		add(campoComentario);
	
		
		final JLabel Tipo = new JLabel("Tipo");
		Tipo.setToolTipText("");
		Tipo.setFont(new Font("Tahoma", Font.BOLD, 17));
		Tipo.setBounds(276, 371, 117, 23);
		add(Tipo);
		
		final JComboBox gbc_selectorTipoCompras = new JComboBox();
		gbc_selectorTipoCompras.setModel(new DefaultComboBoxModel(TipoCompra.values()));
		gbc_selectorTipoCompras.setToolTipText("SUPERMERCADO\t\r\nALIMENTACION\r\nDROGERIA\r\nFRESCOS");
		gbc_selectorTipoCompras.setBounds(417, 368, 117, 22);
		add(gbc_selectorTipoCompras);
		
		JLabel codigoMovimiento = new JLabel("CodigoMovimiento");
		codigoMovimiento.setToolTipText("");
		codigoMovimiento.setFont(new Font("Tahoma", Font.BOLD, 17));
		codigoMovimiento.setBounds(228, 405, 180, 23);
		add(codigoMovimiento);
		
		campoCodigoMovimiento = new JTextField();
		campoCodigoMovimiento.setColumns(10);
		campoCodigoMovimiento.setBounds(417, 408, 43, 20);
		add(campoCodigoMovimiento);
		
		
		BotonVerde Rejistrar = new BotonVerde("Rejistrar");
		Rejistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					
			String nombre= campoNombre.getText();
			boolean importeFijo=true;
	
            if (siFijo.isSelected()) {
            	importeFijo=true;
                
            }
            else if(noFijo.isSelected()) {
            	importeFijo =false;
            }
			float importe=Float.parseFloat(campoImporte.getText());
			String fechaEnTexto=campoFecha.getText();
			String[] fechaPartida=fechaEnTexto.split("/");
			LocalDate fecha=
	                LocalDate.of(Integer.parseInt(fechaPartida[2]),
	                                Integer.parseInt(fechaPartida[1]),
	                                Integer.parseInt(fechaPartida[0]));
			String comentario= campoComentario.getText();
			TipoCompra tipo=(TipoCompra)gbc_selectorTipoCompras.getSelectedItem();
			
			int codigoMovimiento=Integer.parseInt(campoCodigoMovimiento.getText());
		
				new clases.Compra(nombre,importeFijo,importe,fecha,comentario,tipo,codigoMovimiento);
				
				JOptionPane.showMessageDialog(ventana,"Registro ok","Resgitro completado",JOptionPane.PLAIN_MESSAGE);
			} catch (SQLException e1) {
				System.out.println(e1);
				e1.printStackTrace();
				JOptionPane.showMessageDialog(
		                ventana,e1.getMessage(),"Error",
		                JOptionPane.ERROR_MESSAGE);
			} catch (ArrayIndexOutOfBoundsException e1) {
                JOptionPane.showMessageDialog(ventana, "Formato erroneo, debe ser dd/mm/yyyy","error",JOptionPane.ERROR_MESSAGE);
				
			}
			
				}
			
		});
		Rejistrar.setBounds(665, 403, 103, 27);
		add(Rejistrar);
		

		JButton botonListaCompras = new BotonAzul("ListaCompra");
		botonListaCompras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clases.Compra.imprimeInforme();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.cambiarPantalla("listaCompras");
				
			}
		});
		botonListaCompras.setText("ListaCompras");
		botonListaCompras.setBounds(60, 339, 132, 20);
		add(botonListaCompras);
		
		JLabel fondo = new JLabel("");
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(-23, 11, 891, 499);
		add(fondo);
		
	
	
	
	
		
	
		
	

	}
}
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		



