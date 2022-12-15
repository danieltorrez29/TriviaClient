package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Daniel Torres
 * @Date 16/11/2022
 * @Description WelcomePanel Class
 */

public class WelcomePanel extends JPanel {

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;
	private JButton startButton;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 */

	public WelcomePanel(ActionListener listener) {
		setSize(420, 900);
		setLayout(null);
		initComponents(listener);
	}

	/**
	 * 
	 * initComponents void method
	 * 
	 * @param listener
	 */

	private void initComponents(ActionListener listener) {
		startButton = new JButton("Iniciar");
		startButton.setFont(new Font("Ebrima", Font.BOLD, 18));
		startButton.setBounds(29, 576, 345, 32);
		startButton.setFocusPainted(false);
		startButton.addActionListener(listener);
		startButton.setActionCommand("Iniciar");
		add(startButton);
	}

	/**
	 * paint overwrite method
	 */

	@Override
	public void paint(Graphics g) {
		g.setColor(new Color(61, 8, 89));
		g.fillRect(0, 0, 420, 200);
		g.fillRect(0, 650, 420, getHeight());
		try {
			g.drawImage(ImageIO.read(new File("resources/images/logo_brand_name.png")), 55, 250, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
