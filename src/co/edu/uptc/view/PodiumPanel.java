package co.edu.uptc.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;

import co.edu.uptc.model.business.User;

import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * @author Daniel Torres
 * @Date 14/12/2022
 * @Description PodiumPanel Class
 */

public class PodiumPanel extends JPanel {

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;
	private JLabel titleLabel;
	private JButton homeButton;
	private JLabel secondPlaceNameLabel;
	private JLabel firstPlaceNameLabel;
	private JLabel thirdPlaceNameLabel;
	private JLabel secondPlaceScoreLabel;
	private JLabel firstPlaceScoreLabel;
	private JLabel thirdPlaceScoreLabel;
	private JLabel fourthPlaceNameLabel;
	private JLabel fourthPlaceScoreLabel;
	private JLabel fifthPlaceNameLabel;
	private JLabel fifthPlaceScoreLabel;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 */

	public PodiumPanel(ActionListener listener) {
		setBackground(new Color(61, 8, 89));
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
		titleLabel = new JLabel("PODIO");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Ebrima", Font.BOLD, 32));
		titleLabel.setBounds(10, 32, 380, 40);
		add(titleLabel);

		secondPlaceNameLabel = new JLabel("");
		secondPlaceNameLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		secondPlaceNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlaceNameLabel.setForeground(new Color(255, 255, 255));
		secondPlaceNameLabel.setBounds(22, 515, 110, 14);
		add(secondPlaceNameLabel);

		homeButton = new JButton("Inicio");
		homeButton.setFont(new Font("Ebrima", Font.BOLD, 18));
		homeButton.setForeground(new Color(0, 0, 0));
		homeButton.setFocusPainted(false);
		homeButton.addActionListener(listener);
		homeButton.setActionCommand("Inicio - Podio");
		homeButton.setBounds(39, 684, 335, 31);
		add(homeButton);

		firstPlaceNameLabel = new JLabel("");
		firstPlaceNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlaceNameLabel.setForeground(new Color(255, 255, 255));
		firstPlaceNameLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		firstPlaceNameLabel.setBounds(142, 515, 110, 14);
		add(firstPlaceNameLabel);

		thirdPlaceNameLabel = new JLabel("");
		thirdPlaceNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlaceNameLabel.setForeground(new Color(255, 255, 255));
		thirdPlaceNameLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		thirdPlaceNameLabel.setBounds(272, 515, 110, 14);
		add(thirdPlaceNameLabel);

		secondPlaceScoreLabel = new JLabel("");
		secondPlaceScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlaceScoreLabel.setForeground(new Color(255, 255, 255));
		secondPlaceScoreLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		secondPlaceScoreLabel.setBounds(22, 540, 110, 14);
		add(secondPlaceScoreLabel);

		firstPlaceScoreLabel = new JLabel("");
		firstPlaceScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlaceScoreLabel.setForeground(new Color(255, 255, 255));
		firstPlaceScoreLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		firstPlaceScoreLabel.setBounds(142, 540, 110, 14);
		add(firstPlaceScoreLabel);

		thirdPlaceScoreLabel = new JLabel("");
		thirdPlaceScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlaceScoreLabel.setForeground(new Color(255, 255, 255));
		thirdPlaceScoreLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		thirdPlaceScoreLabel.setBounds(272, 540, 110, 14);
		add(thirdPlaceScoreLabel);

		fourthPlaceNameLabel = new JLabel("");
		fourthPlaceNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlaceNameLabel.setForeground(new Color(255, 255, 255));
		fourthPlaceNameLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		fourthPlaceNameLabel.setBounds(39, 605, 110, 14);
		add(fourthPlaceNameLabel);

		fourthPlaceScoreLabel = new JLabel("");
		fourthPlaceScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlaceScoreLabel.setForeground(new Color(255, 255, 255));
		fourthPlaceScoreLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		fourthPlaceScoreLabel.setBounds(39, 630, 110, 14);
		add(fourthPlaceScoreLabel);

		fifthPlaceNameLabel = new JLabel("");
		fifthPlaceNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlaceNameLabel.setForeground(new Color(255, 255, 255));
		fifthPlaceNameLabel.setFont(new Font("Ebrima", Font.BOLD, 13));
		fifthPlaceNameLabel.setBounds(250, 605, 110, 14);
		add(fifthPlaceNameLabel);

		fifthPlaceScoreLabel = new JLabel("");
		fifthPlaceScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlaceScoreLabel.setForeground(new Color(255, 255, 255));
		fifthPlaceScoreLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		fifthPlaceScoreLabel.setBounds(250, 630, 110, 14);
		add(fifthPlaceScoreLabel);
	}

	/**
	 * getHomeButton method
	 * 
	 * @return homeButton
	 */

	public JButton getHomeButton() {
		return homeButton;
	}

	/**
	 * 
	 * setUIPodiumUsers void method
	 * 
	 * @param users
	 */

	public void setUIPodiumUsers(ArrayList<User> users) {
		for (int i = 0; i < users.size(); i++) {
			switch (i) {
			case 0:
				setUserUIStats(users.get(i), firstPlaceNameLabel, firstPlaceScoreLabel);
				break;

			case 1:
				setUserUIStats(users.get(i), secondPlaceNameLabel, secondPlaceScoreLabel);
				break;

			case 2:
				setUserUIStats(users.get(i), thirdPlaceNameLabel, thirdPlaceScoreLabel);
				break;

			case 3:
				setUserUIStats(users.get(i), fourthPlaceNameLabel, fourthPlaceScoreLabel);
				break;

			case 4:
				setUserUIStats(users.get(i), fifthPlaceNameLabel, fifthPlaceScoreLabel);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * 
	 * setUserUIStats void method
	 * 
	 * @param user
	 * @param nameLabel
	 * @param scoreLabel
	 */

	private void setUserUIStats(User user, JLabel nameLabel, JLabel scoreLabel) {
		nameLabel.setText(user.getUsername());
		scoreLabel.setText(String.valueOf(user.getStats().getScore()));
	}

	/**
	 * paint overwrite method
	 */

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(134, 76, 191));
		g.fillRoundRect(20, 300, 110, 210, 20, 20);

		g.fillRoundRect(145, 200, 110, 310, 20, 20);

		g.fillRoundRect(270, 350, 110, 160, 20, 20);

		g.setColor(Color.WHITE);
		g.drawLine(20, 575, 380, 575);

		try {
			g.drawImage(ImageIO.read(new File("resources/images/silver_medal.png")), 45, 300, this);
			g.drawImage(ImageIO.read(new File("resources/images/2.png")), 45, 400, this);
			g.drawImage(ImageIO.read(new File("resources/images/trophie.png")), 170, 135, this);
			g.drawImage(ImageIO.read(new File("resources/images/1.png")), 170, 250, this);
			g.drawImage(ImageIO.read(new File("resources/images/bronze_medal.png")), 295, 350, this);
			g.drawImage(ImageIO.read(new File("resources/images/3.png")), 295, 430, this);
			g.drawImage(ImageIO.read(new File("resources/images/4.png")), 170, 600, this);
			g.drawImage(ImageIO.read(new File("resources/images/5.png")), 210, 600, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}