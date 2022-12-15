package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.edu.uptc.model.business.User;

/**
 * @author Daniel Torres
 * @Date 16/11/2022
 * @Description StatsPanel Class
 */

public class StatsPanel extends JPanel {

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;
	private JLabel statsLabel;
	private JLabel profilePicLabel;
	private JLabel usernameLabel;
	private JLabel scoreTitleLabel;
	private JLabel accuracyTitleLabel;
	private JLabel scoreLabel;
	private JLabel accuracyLabel;
	private JLabel correctLabel;
	private JLabel incorrectLabel;
	private JLabel correctTitleLabel;
	private JLabel incorrectTitleLabel;
	private JLabel timeLabel;
	private JLabel timeTitleLabel;
	private JButton homeButton;
	private double accuracy;
	private JLabel topicLabel;
	private JLabel difficultyLabel;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 */

	public StatsPanel(ActionListener listener) {
		setBackground(new Color(61, 8, 89));
		setSize(420, 900);
		setLayout(null);
		accuracy = 0;
		initComponents(listener);
	}

	/**
	 * 
	 * initComponents void method
	 * 
	 * @param listener
	 */

	private void initComponents(ActionListener listener) {
		statsLabel = new JLabel("Estadísticas");
		statsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statsLabel.setFont(new Font("Ebrima", Font.BOLD, 30));
		statsLabel.setForeground(new Color(255, 255, 255));
		statsLabel.setBounds(114, 23, 186, 27);
		add(statsLabel);

		profilePicLabel = new JLabel("");
		profilePicLabel.setBounds(39, 85, 152, 138);
		add(profilePicLabel);

		topicLabel = new JLabel("");
		topicLabel.setForeground(new Color(255, 255, 255));
		topicLabel.setFont(new Font("Ebrima", Font.BOLD, 22));
		topicLabel.setBounds(201, 85, 186, 31);
		add(topicLabel);

		difficultyLabel = new JLabel("");
		difficultyLabel.setForeground(new Color(192, 192, 192));
		difficultyLabel.setFont(new Font("Ebrima", Font.BOLD, 14));
		difficultyLabel.setBounds(201, 115, 186, 31);
		add(difficultyLabel);

		usernameLabel = new JLabel("");
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setFont(new Font("Ebrima", Font.BOLD, 18));
		usernameLabel.setBounds(201, 169, 182, 27);
		add(usernameLabel);

		homeButton = new JButton("Inicio");
		homeButton.setBackground(new Color(255, 255, 255));
		homeButton.setFont(new Font("Ebrima", Font.BOLD, 18));
		homeButton.setFocusPainted(false);
		homeButton.addActionListener(listener);
		homeButton.setActionCommand("Inicio - Estadísticas");
		homeButton.setBounds(39, 746, 344, 31);
		add(homeButton);

		scoreTitleLabel = new JLabel("Puntuación");
		scoreTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreTitleLabel.setForeground(new Color(192, 192, 192));
		scoreTitleLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		scoreTitleLabel.setBounds(51, 236, 122, 14);
		add(scoreTitleLabel);

		accuracyTitleLabel = new JLabel("Precisión");
		accuracyTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accuracyTitleLabel.setForeground(new Color(192, 192, 192));
		accuracyTitleLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		accuracyTitleLabel.setBounds(241, 236, 103, 14);
		add(accuracyTitleLabel);

		scoreLabel = new JLabel("");
		scoreLabel.setForeground(new Color(255, 255, 255));
		scoreLabel.setFont(new Font("Ebrima", Font.BOLD, 28));
		scoreLabel.setBounds(65, 261, 97, 37);
		add(scoreLabel);

		accuracyLabel = new JLabel("");
		accuracyLabel.setForeground(new Color(255, 255, 255));
		accuracyLabel.setFont(new Font("Ebrima", Font.BOLD, 28));
		accuracyLabel.setBounds(251, 261, 122, 37);
		add(accuracyLabel);

		correctLabel = new JLabel("");
		correctLabel.setHorizontalAlignment(SwingConstants.CENTER);
		correctLabel.setForeground(new Color(255, 255, 255));
		correctLabel.setFont(new Font("Ebrima", Font.BOLD, 28));
		correctLabel.setBounds(86, 474, 77, 37);
		add(correctLabel);

		incorrectLabel = new JLabel("");
		incorrectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectLabel.setForeground(new Color(255, 255, 255));
		incorrectLabel.setFont(new Font("Ebrima", Font.BOLD, 28));
		incorrectLabel.setBounds(242, 474, 77, 37);
		add(incorrectLabel);

		correctTitleLabel = new JLabel("Correcto");
		correctTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		correctTitleLabel.setForeground(new Color(192, 192, 192));
		correctTitleLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		correctTitleLabel.setBounds(86, 522, 87, 14);
		add(correctTitleLabel);

		incorrectTitleLabel = new JLabel("Incorrecto");
		incorrectTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		incorrectTitleLabel.setForeground(new Color(192, 192, 192));
		incorrectTitleLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		incorrectTitleLabel.setBounds(229, 522, 103, 14);
		add(incorrectTitleLabel);

		timeLabel = new JLabel("");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setForeground(new Color(255, 255, 255));
		timeLabel.setFont(new Font("Ebrima", Font.BOLD, 28));
		timeLabel.setBounds(153, 633, 97, 31);
		add(timeLabel);

		timeTitleLabel = new JLabel("Tiempo total");
		timeTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeTitleLabel.setForeground(new Color(192, 192, 192));
		timeTitleLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		timeTitleLabel.setBounds(129, 675, 138, 14);
		add(timeTitleLabel);

	}

	/**
	 * 
	 * setStats void method
	 * 
	 * @param loggedInUser
	 */

	public void setUIStats(User loggedInUser) {
		profilePicLabel.setIcon(new ImageIcon(loggedInUser.getProfilePicPath()));
		topicLabel.setText(loggedInUser.getStats().getCategorie());
		difficultyLabel.setText(loggedInUser.getStats().getLevel());
		usernameLabel.setText(loggedInUser.getUsername());
		scoreLabel.setText(String.valueOf(loggedInUser.getStats().getScore()));
		accuracyLabel.setText(String.format("%.1f", loggedInUser.getStats().getAccuracy()) + "%");
		correctLabel.setText(String.valueOf(loggedInUser.getStats().getCorrect()));
		incorrectLabel.setText(String.valueOf(loggedInUser.getStats().getIncorrect()));
		timeLabel.setText(loggedInUser.getStats().getTime() + " s");
	}

	/**
	 * 
	 * repaintStatsPanel void method
	 * 
	 * @param accuracy
	 */

	public void repaintStatsPanel(double accuracy) {
		this.accuracy = accuracy;
		repaint();
	}

	/**
	 * getPlayAgainButton method
	 * 
	 * @return homeButton
	 */

	public JButton getHomeButton() {
		return homeButton;
	}

	/**
	 * paint overwrite method
	 */

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		int correctAccuracyWidth = (int) (340 * (this.accuracy / 100));

		g.setColor(new Color(1, 200, 133));
		g.fillRoundRect(30, 340, correctAccuracyWidth, 30, 10, 10);

		int incorrectAccuracyWidth = 360 - correctAccuracyWidth;

		g.setColor(new Color(240, 61, 103));
		g.fillRoundRect(20 + correctAccuracyWidth, 340, incorrectAccuracyWidth, 30, 10, 10);

		g.setColor(Color.WHITE);
		g.fillRoundRect(correctAccuracyWidth, 335, 50, 40, 10, 10);

		g.setColor(Color.BLACK);
		g.setFont(new Font("Ebrima", Font.PLAIN, 18));
		g.drawString(String.format("%.0f", accuracy) + "%", 5 + correctAccuracyWidth, 360);

		try {
			g.drawImage(ImageIO.read(new File("resources/images/checked.png")).getScaledInstance(50, 50,
					Image.SCALE_SMOOTH), 100, 410, null);
			g.drawImage(
					ImageIO.read(new File("resources/images/error.png")).getScaledInstance(55, 55, Image.SCALE_SMOOTH),
					250, 410, null);
			g.drawImage(ImageIO.read(new File("resources/images/chronometer.png")).getScaledInstance(55, 55,
					Image.SCALE_SMOOTH), 170, 570, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
