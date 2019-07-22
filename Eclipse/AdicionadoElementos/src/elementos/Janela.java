package elementos;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame {

	AudioClip audio;

	public Janela() {
		iniciar();
	}

	private void iniciar() {
		JButton tocar = new JButton("Tocar musica");
		tocar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		tocar.setBounds(10, 10, 200, 40);
		add(tocar);
		JButton parar = new JButton("Parar musica");
		parar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		parar.setBounds(220, 10, 200, 40);
		add(parar);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Principal");
		setResizable(false);
		setSize(500, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		URL url = Janela.class.getResource("musica.wav");
		audio = Applet.newAudioClip(url);
		audio.play();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		audio.stop();
	}

	public static void main(String[] args) {
		new Janela();
	}

}
