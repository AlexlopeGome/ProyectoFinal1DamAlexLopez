package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import elementosVisuales.BotonVerde;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

public class PantallaInicio extends JPanel {
	private Ventana ventana;
	

	private File musica;
	private Clip clip;
	private AudioInputStream audioInputStream;

	public PantallaInicio(Ventana v) {
		this.ventana = v;
		setToolTipText("");
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setBackground(Color.WHITE);
		setLayout(null);

	
		JLabel lblIniciarSesion = new JLabel("Home Manager");
		lblIniciarSesion.setForeground(Color.WHITE);
		lblIniciarSesion.setBounds(269, 27, 243, 37);
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblIniciarSesion);
	musica = new File(FileSystems.getDefault().getPath("").toAbsolutePath() + "./sonidos/simpsong.wav");
		JButton btnbtnbotonVerde = new BotonVerde("Vamoss....");
		btnbtnbotonVerde.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			if(ventana.usuario!=null) {
				ventana.cambiarPantalla("queHacer");
				JOptionPane.showMessageDialog(ventana, "Bienvenido, "+ventana.usuario, "Login correcto", JOptionPane.PLAIN_MESSAGE);
			}else {
			ventana.cambiarPantalla("Principal");
			}
				play();
				setEnabled(false);

			}
		});
		btnbtnbotonVerde.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnbtnbotonVerde.setText("Lets GO....");
		btnbtnbotonVerde.setForeground(Color.BLACK);
		btnbtnbotonVerde.setToolTipText("Vamos....");
		btnbtnbotonVerde.setBounds(253, 241, 277, 27);
		add(btnbtnbotonVerde);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./fondos/inicioApi.jpg"));
		lblNewLabel.setBounds(-23, 11, 891, 499);
		add(lblNewLabel);

	}

	public void play() {
		try {
			audioInputStream = AudioSystem.getAudioInputStream(musica);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			System.err.println(e);
		}
	}

}
