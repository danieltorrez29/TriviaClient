package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * @author Daniel Torres
 * @Date 16/11/2022
 * @Description LoginPanel Class
 */

public class LoginPanel extends JPanel {

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;
	private JPanel purplePanel;
	private JLabel logoLabel;
	private JLabel emailUsernameLabel;
	private JLabel passwordLabel;
	private JTextField emailUsernameField;
	private JPasswordField passwordField;
	private PromptText emailUsernamePrompt;
	private PromptText passwordPrompt;
	private JButton loginButton;
	private JButton registerButton;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 */

	public LoginPanel(ActionListener listener) {
		this.setSize(420, 900);
		initComponents(listener);
	}

	/**
	 * 
	 * initComponents void method
	 * 
	 * @param listener
	 */

	private void initComponents(ActionListener listener) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 173, 0 };
		gridBagLayout.rowHeights = new int[] { 600, 0, 0, 0, 0, 0, 0, 0, 14, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		purplePanel = new JPanel();
		purplePanel.setBackground(new Color(61, 8, 89));
		GridBagConstraints gbc_purplePanel = new GridBagConstraints();
		gbc_purplePanel.insets = new Insets(0, 0, 5, 0);
		gbc_purplePanel.fill = GridBagConstraints.BOTH;
		gbc_purplePanel.gridx = 0;
		gbc_purplePanel.gridy = 0;
		add(purplePanel, gbc_purplePanel);

		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("resources/images/logo_resized.png"));
		GridBagConstraints gbc_logoLabel = new GridBagConstraints();
		gbc_logoLabel.insets = new Insets(10, 0, 5, 0);
		gbc_logoLabel.gridx = 0;
		gbc_logoLabel.gridy = 1;
		add(logoLabel, gbc_logoLabel);

		emailUsernameLabel = new JLabel("correo / nombre de usuario");
		emailUsernameLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
		emailUsernameLabel.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_emailUsernameLabel = new GridBagConstraints();
		gbc_emailUsernameLabel.anchor = GridBagConstraints.WEST;
		gbc_emailUsernameLabel.insets = new Insets(0, 10, 5, 10);
		gbc_emailUsernameLabel.fill = GridBagConstraints.VERTICAL;
		gbc_emailUsernameLabel.gridx = 0;
		gbc_emailUsernameLabel.gridy = 2;
		add(emailUsernameLabel, gbc_emailUsernameLabel);

		emailUsernameField = new JTextField();
		emailUsernameField.setColumns(30);
		emailUsernameField.setForeground(new Color(128, 128, 128));
		emailUsernameField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		emailUsernameField.setBorder(new CompoundBorder(emailUsernameField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		emailUsernamePrompt = new PromptText("ingrese correo o nombre de usuario", emailUsernameField);
		emailUsernamePrompt.changeStyle(Font.PLAIN);
		emailUsernamePrompt.changeAlpha(128);
		GridBagConstraints gbc_loginEmailUsernameField = new GridBagConstraints();
		gbc_loginEmailUsernameField.insets = new Insets(0, 10, 5, 10);
		gbc_loginEmailUsernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginEmailUsernameField.gridx = 0;
		gbc_loginEmailUsernameField.gridy = 3;
		add(emailUsernameField, gbc_loginEmailUsernameField);

		passwordLabel = new JLabel("contrase\u00F1a");
		passwordLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
		passwordLabel.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.insets = new Insets(0, 10, 5, 10);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 4;
		add(passwordLabel, gbc_passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setColumns(27);
		passwordField.setForeground(new Color(128, 128, 128));
		passwordField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		passwordField.setBorder(new CompoundBorder(passwordField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		passwordField.setEchoChar('•');
		passwordPrompt = new PromptText("ingrese contraseña", passwordField);
		passwordPrompt.changeStyle(Font.PLAIN);
		passwordPrompt.changeAlpha(128);
		GridBagConstraints gbc_loginPasswordField = new GridBagConstraints();
		gbc_loginPasswordField.insets = new Insets(0, 10, 5, 10);
		gbc_loginPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginPasswordField.gridx = 0;
		gbc_loginPasswordField.gridy = 5;
		add(passwordField, gbc_loginPasswordField);

		loginButton = new JButton("Ingresar");
		loginButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		loginButton.setFocusPainted(false);
		loginButton.addActionListener(listener);
		loginButton.setActionCommand("Ingresar");
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(10, 0, 5, 0);
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 6;
		add(loginButton, gbc_loginButton);

		registerButton = new JButton("Registrarse");
		registerButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		registerButton.setFocusPainted(false);
		registerButton.addActionListener(listener);
		registerButton.setActionCommand("Registrarse");
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.insets = new Insets(0, 0, 280, 0);
		gbc_registerButton.gridx = 0;
		gbc_registerButton.gridy = 7;
		add(registerButton, gbc_registerButton);
	}

	/**
	 * 
	 * getEmailUsernameFieldText String method
	 * 
	 * @return loginEmailUsernameFieldText
	 */

	public String getLoginEmailUsernameFieldText() {
		return emailUsernameField.getText();
	}

	/**
	 * 
	 * getPasswordFieldText String method
	 * 
	 * @return loginPasswordFieldText
	 */

	public String getLoginPasswordFieldText() {
		return String.valueOf(passwordField.getPassword());
	}

	/**
	 * 
	 * emptyLoginFields void method
	 */

	public void emptyLoginFields() {
		emailUsernameField.setText("");
		passwordField.setText("");
	}

	/**
	 * getLoginButton method
	 * 
	 * @return loginButton
	 */

	public JButton getLoginButton() {
		return loginButton;
	}

	/**
	 * 
	 * setDefaultLoginPanelCursorPosition void method
	 */

	public void setDefaultLoginPanelCursorPosition() {
		emailUsernameField.requestFocusInWindow();
	}
}