package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.model.business.Categorie;
import co.edu.uptc.model.business.Difficulty;

/**
 * 
 * LevelCategorieSelectionPanel class
 * 
 * @author Daniel Torres
 */

public class LevelCategorieSelectionPanel extends JPanel {

	/**
	 * Serial version UID constant
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Purple panel
	 */

	private JPanel purplePanel;

	/**
	 * Logo label
	 */

	private JLabel logoLabel;

	/**
	 * Selection level label
	 */

	private JLabel selectionLevelLabel;

	/**
	 * Easy topics label
	 */

	private JLabel easyTopicsLabel;

	/**
	 * Hard topics label
	 */

	private JLabel hardTopicsLabel;

	/**
	 * Levels combo box
	 */

	private JComboBox<String> levelsComboBox;

	/**
	 * Easy topics combo box
	 */

	private JComboBox<String> easyTopicsComboBox;

	/**
	 * Hard topics combo box
	 */

	private JComboBox<String> hardTopicsComboBox;

	/**
	 * Play button
	 */

	private JButton playButton;

	/**
	 * Sign out button
	 */

	private JButton signOutButton;

	/**
	 * Podium button
	 */

	private JButton podiumButton;

	/**
	 * Last stats button
	 */

	private JButton lastStatsButton;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 * @param easyCategorieList
	 * @param hardCategorieList
	 */

	public LevelCategorieSelectionPanel(ActionListener listener, Difficulty easyCategorieList,
			Difficulty hardCategorieList) {
		setSize(420, 900);
		initComponents(listener, easyCategorieList, hardCategorieList);
	}

	/**
	 * 
	 * initComponents void method
	 * 
	 * @param listener
	 * @param easyCategorieList
	 * @param hardCategorieList
	 */

	private void initComponents(ActionListener listener, Difficulty easyCategorieList, Difficulty hardCategorieList) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 508, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		purplePanel = new JPanel();
		purplePanel.setBackground(new Color(61, 8, 89));
		GridBagConstraints gbc_purplePanel = new GridBagConstraints();
		gbc_purplePanel.gridwidth = 2;
		gbc_purplePanel.insets = new Insets(0, 0, 5, 0);
		gbc_purplePanel.fill = GridBagConstraints.BOTH;
		gbc_purplePanel.gridx = 0;
		gbc_purplePanel.gridy = 0;
		add(purplePanel, gbc_purplePanel);

		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("resources/images/logo_brand_name.png"));
		GridBagConstraints gbc_logoLabel = new GridBagConstraints();
		gbc_logoLabel.gridwidth = 2;
		gbc_logoLabel.insets = new Insets(10, 0, 10, 0);
		gbc_logoLabel.gridx = 0;
		gbc_logoLabel.gridy = 1;
		add(logoLabel, gbc_logoLabel);

		selectionLevelLabel = new JLabel("Select level");
		selectionLevelLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		GridBagConstraints gbc_selectionLevelLabel = new GridBagConstraints();
		gbc_selectionLevelLabel.gridwidth = 2;
		gbc_selectionLevelLabel.insets = new Insets(20, 0, 5, 0);
		gbc_selectionLevelLabel.gridx = 0;
		gbc_selectionLevelLabel.gridy = 2;
		add(selectionLevelLabel, gbc_selectionLevelLabel);

		levelsComboBox = new JComboBox<String>();
		levelsComboBox.setFont(new Font("Ebrima", Font.PLAIN, 16));
		levelsComboBox.setEditable(false);
		levelsComboBox.addItem("Easy");
		levelsComboBox.addItem("Hard");
		GridBagConstraints gbc_levelComboBox = new GridBagConstraints();
		gbc_levelComboBox.gridwidth = 2;
		gbc_levelComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_levelComboBox.gridx = 0;
		gbc_levelComboBox.gridy = 3;
		add(levelsComboBox, gbc_levelComboBox);

		easyTopicsLabel = new JLabel("Categories - Easy");
		easyTopicsLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		GridBagConstraints gbc_easyTopicsLabel = new GridBagConstraints();
		gbc_easyTopicsLabel.insets = new Insets(10, 0, 5, 5);
		gbc_easyTopicsLabel.gridx = 0;
		gbc_easyTopicsLabel.gridy = 4;
		add(easyTopicsLabel, gbc_easyTopicsLabel);

		hardTopicsLabel = new JLabel("Categories - Hard");
		hardTopicsLabel.setFont(new Font("Ebrima", Font.BOLD, 16));
		GridBagConstraints gbc_hardTopicsLabel = new GridBagConstraints();
		gbc_hardTopicsLabel.insets = new Insets(10, 0, 5, 0);
		gbc_hardTopicsLabel.gridx = 1;
		gbc_hardTopicsLabel.gridy = 4;
		add(hardTopicsLabel, gbc_hardTopicsLabel);

		easyTopicsComboBox = new JComboBox<String>();
		easyTopicsComboBox.setFont(new Font("Ebrima", Font.PLAIN, 16));
		for (Categorie easyTopic : easyCategorieList.getCategories())
			easyTopicsComboBox.addItem(easyTopic.getName());
		GridBagConstraints gbc_easyTopicsComboBox = new GridBagConstraints();
		gbc_easyTopicsComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_easyTopicsComboBox.gridx = 0;
		gbc_easyTopicsComboBox.gridy = 5;
		add(easyTopicsComboBox, gbc_easyTopicsComboBox);

		hardTopicsComboBox = new JComboBox<String>();
		hardTopicsComboBox.setFont(new Font("Ebrima", Font.PLAIN, 16));
		for (Categorie hardTopic : hardCategorieList.getCategories())
			hardTopicsComboBox.addItem(hardTopic.getName());
		GridBagConstraints gbc_hardTopicsComboBox = new GridBagConstraints();
		gbc_hardTopicsComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_hardTopicsComboBox.gridx = 1;
		gbc_hardTopicsComboBox.gridy = 5;
		add(hardTopicsComboBox, gbc_hardTopicsComboBox);

		playButton = new JButton("Play");
		playButton.setMargin(new Insets(2, 140, 2, 140));
		playButton.setFont(new Font("Ebrima", Font.BOLD, 18));
		playButton.addActionListener(listener);
		playButton.setActionCommand("Play");
		GridBagConstraints gbc_playButton = new GridBagConstraints();
		gbc_playButton.gridwidth = 2;
		gbc_playButton.insets = new Insets(20, 0, 20, 0);
		gbc_playButton.gridx = 0;
		gbc_playButton.gridy = 6;
		add(playButton, gbc_playButton);

		signOutButton = new JButton("Sign Out");
		signOutButton.setFont(new Font("Ebrima", Font.BOLD, 16));
		signOutButton.setFocusPainted(false);
		GridBagConstraints gbc_signOutButton = new GridBagConstraints();
		gbc_signOutButton.insets = new Insets(0, 0, 50, 0);
		gbc_signOutButton.gridwidth = 2;
		gbc_signOutButton.gridx = 0;
		gbc_signOutButton.gridy = 9;
		signOutButton.addActionListener(listener);
		signOutButton.setActionCommand("Sign Out");
		add(signOutButton, gbc_signOutButton);

		lastStatsButton = new JButton("Last Stats");
		lastStatsButton.setMargin(new Insets(2, 60, 2, 60));
		lastStatsButton.setFont(new Font("Ebrima", Font.BOLD, 16));
		lastStatsButton.addActionListener(listener);
		lastStatsButton.setActionCommand("Last Stats");
		GridBagConstraints gbc_lastStatsButton = new GridBagConstraints();
		gbc_lastStatsButton.gridwidth = 2;
		gbc_lastStatsButton.insets = new Insets(0, 0, 20, 0);
		gbc_lastStatsButton.gridx = 0;
		gbc_lastStatsButton.gridy = 7;
		add(lastStatsButton, gbc_lastStatsButton);

		podiumButton = new JButton("Podium");
		podiumButton.setMargin(new Insets(2, 60, 2, 60));
		podiumButton.setFont(new Font("Ebrima", Font.BOLD, 16));
		podiumButton.addActionListener(listener);
		podiumButton.setActionCommand("Podium");
		GridBagConstraints gbc_podiumButton = new GridBagConstraints();
		gbc_podiumButton.gridwidth = 2;
		gbc_podiumButton.insets = new Insets(0, 0, 20, 0);
		gbc_podiumButton.gridx = 0;
		gbc_podiumButton.gridy = 8;
		add(podiumButton, gbc_podiumButton);
	}

	/**
	 * 
	 * getLevelSelected String method
	 * 
	 * @return level selected
	 */

	public String getLevelSelected() {
		return levelsComboBox.getSelectedItem().toString();
	}

	/**
	 * 
	 * getEasyTopicSelected String method
	 * 
	 * @return easy topic selected
	 */

	public String getEasyTopicSelected() {
		return easyTopicsComboBox.getSelectedItem().toString();
	}

	/**
	 * 
	 * getHardTopicSelected String method
	 * 
	 * @return hard topic selected
	 */

	public String getHardTopicSelected() {
		return hardTopicsComboBox.getSelectedItem().toString();
	}

	/**
	 * getPlayButton method
	 * 
	 * @return playButton
	 */

	public JButton getPlayButton() {
		return playButton;
	}

	/**
	 * 
	 * setDefaultLevelCategorieSelectionPanelCursorPosition void method
	 */

	public void setDefaultLevelCategorieSelectionPanelCursorPosition() {
		levelsComboBox.requestFocusInWindow();
	}
}