package pantallas;




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;


import elementosVisuales.BotonAzul;

import elementosVisuales.BotonVerde;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JRadioButton;

import javax.swing.JComboBox;


public class PantallaPrestamo extends JPanel {
	;
	private Ventana ventana;
	private final JLabel label = new JLabel("");
	private JTextField campoNombre;
	private JTextField campoImporte;
	private JTextField campoFecha;
	private JTextField textField;
	private JTextField campoCodigoMovimiento;
	private JTextField campoPorcentaje;
	private JTextField campoFechaFin;

	public PantallaPrestamo(Ventana v) {
		this.ventana=v;
		setLayout(null);
		
		JButton botonAtras = new BotonAzul("Atras");
		botonAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ventana.cambiarPantalla("queHacer");
				
			}
			
		
		});
		botonAtras.setBounds(10, 381, 89, 23);
		add(botonAtras);
		
		JLabel Prestamo = new JLabel("Prestamo");
		Prestamo.setFont(new Font("Tahoma", Font.BOLD, 29));
		Prestamo.setBounds(387, 44, 180, 50);
		add(Prestamo);
		
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 17));
		Nombre.setToolTipText("");
		Nombre.setBounds(276, 200, 117, 23);
		add(Nombre);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(450, 204, 117, 20);
		add(campoNombre);
		campoNombre.setColumns(10);
		
		JLabel Fijo = new JLabel("Es fijo");
		Fijo.setToolTipText("");
		Fijo.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fijo.setBounds(276, 234, 117, 23);
		add(Fijo);
		
		
		final JRadioButton siFijo = new JRadioButton("pulsar si es fijo");
		siFijo.setBounds(450, 237, 117, 23);
		add(siFijo);

		final JRadioButton noFijo = new JRadioButton("pulsar si no es fijo");
		noFijo.setBounds(582, 237, 117, 23);
		add(noFijo);
		
		
		
		JLabel importe = new JLabel("Importe");
		importe.setToolTipText("");
		importe.setFont(new Font("Tahoma", Font.BOLD, 17));
		importe.setBounds(276, 268, 117, 23);
		add(importe);
		
		
		
		
		campoImporte = new JTextField();
		campoImporte.setColumns(10);
		campoImporte.setBounds(450, 272, 117, 20);
		add(campoImporte);
		
		JLabel Fecha = new JLabel("Fecha");
		Fecha.setToolTipText("");
		Fecha.setFont(new Font("Tahoma", Font.BOLD, 17));
		Fecha.setBounds(276, 302, 117, 23);
		add(Fecha);
		
		campoFecha = new JTextField();
		campoFecha.setColumns(10);
		campoFecha.setBounds(450, 306, 117, 20);
		add(campoFecha);

		JLabel codigoMovimiento = new JLabel("CodigoMovimiento");
		codigoMovimiento.setToolTipText("");
		codigoMovimiento.setFont(new Font("Tahoma", Font.BOLD, 17));
		codigoMovimiento.setBounds(239, 418, 180, 23);
		add(codigoMovimiento);
		
		campoCodigoMovimiento = new JTextField();
		campoCodigoMovimiento.setColumns(10);
		campoCodigoMovimiento.setBounds(450, 422, 43, 20);
		add(campoCodigoMovimiento);
		
		JLabel FechaFin = new JLabel("Fecha Fin");
		FechaFin.setToolTipText("");
		FechaFin.setFont(new Font("Tahoma", Font.BOLD, 17));
		FechaFin.setBounds(276, 370, 117, 23);
		add(FechaFin);
		
		campoFechaFin = new JTextField();
		campoFechaFin.setBounds(450, 368, 86, 20);
		add(campoFechaFin);
		campoFechaFin.setColumns(10);
		

		JLabel Porcentaje = new JLabel("Porcentaje");
		Porcentaje.setToolTipText("");
		Porcentaje.setFont(new Font("Tahoma", Font.BOLD, 17));
		Porcentaje.setBounds(276, 336, 117, 23);
		add(Porcentaje);
		
		campoPorcentaje = new JTextField();
		campoPorcentaje.setBounds(450, 337, 86, 20);
		add(campoPorcentaje);
		campoPorcentaje.setColumns(10);
		
		
		
		
		
		
		JButton Rejistrar = new BotonVerde("Rejistrar");
		Rejistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre=campoNombre.getText();
					boolean importeFijo=true;
					
		            if (siFijo.isSelected()) {
		            	importeFijo=true;
		                
		            }
		            else if(noFijo.isSelected()) {
		            	importeFijo =false;
		            }
					
					float importe=Float.parseFloat(campoImporte.getText());
				    float porcentaje=Float.parseFloat(campoPorcentaje.getText());
				    
					String fechaEnTexto=campoFecha.getText();
					String[] fechaPartida=fechaEnTexto.split("/");
					LocalDate fecha=
			                LocalDate.of(Integer.parseInt(fechaPartida[2]),
			                                Integer.parseInt(fechaPartida[1]),
			                                Integer.parseInt(fechaPartida[0]));
				
					String fechaEnTexto2=campoFechaFin.getText();
					String[] fechaPartida2=fechaEnTexto2.split("/");
					LocalDate fechaFin=
			                LocalDate.of(Integer.parseInt(fechaPartida2[2]),
			                                Integer.parseInt(fechaPartida2[1]),
			                                Integer.parseInt(fechaPartida2[0]));
					
			
					
					int codigoMovimiento=Integer.parseInt(campoCodigoMovimiento.getText());
				
				
						new clases.Prestamo(nombre,importeFijo,importe,fecha,porcentaje,fechaFin,codigoMovimiento);
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
		Rejistrar.setBounds(561, 461, 103, 27);
		add(Rejistrar);
		
		JLabel fondo = new JLabel("");
		fondo.setToolTipText("");
		
		JButton ListadoPestamo = new BotonAzul("Listado Prestamo y informe.txt");
		ListadoPestamo.setFont(new Font("Dialog", Font.PLAIN, 13));
		ListadoPestamo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					clases.Prestamo.imprimeInforme();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ventana.cambiarPantalla("listaPrestamo");
			}
		});
		ListadoPestamo.setBounds(10, 440, 217, 23);
		add(ListadoPestamo);
		
		
		
		fondo.setIcon(new ImageIcon("B:\\Xamp\\htdocs\\REPOSITOS\\ProyectoFinal1DamAlexLopez\\fondos\\VentanaGastos_de_casa_API.jpg"));
		fondo.setBounds(-23, 11, 891, 499);
		add(fondo);
		
		
		
		
		
		
		
		
		
	
		
		
	
		
		
		
		
		
		
	
		
		
	
		
	
		
	

	}
}
		
		
		
		
		
		
	
		
		
	
		
		
		


		
	
		
	

		



