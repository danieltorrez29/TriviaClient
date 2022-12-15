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
 * @Description RegisterPanel Class
 */

public class RegisterPanel extends JPanel {

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;
	private JPanel purplePanel;
	private JLabel emailLabel;
	private JLabel logoLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;
	private JTextField emailField;
	private JTextField usernameField;
	private PromptText emailPrompt;
	private PromptText usernamePrompt;
	private PromptText passwordPrompt;
	private PromptText confirmPasswordPrompt;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JButton registerButton;
	private JButton wantToLoginButton;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 */

	public RegisterPanel(ActionListener listener) {
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
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 43, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
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

		emailLabel = new JLabel("correo");
		emailLabel.setForeground(new Color(128, 128, 128));
		emailLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
		GridBagConstraints gbc_emailLabel = new GridBagConstraints();
		gbc_emailLabel.anchor = GridBagConstraints.WEST;
		gbc_emailLabel.insets = new Insets(0, 10, 5, 10);
		gbc_emailLabel.gridx = 0;
		gbc_emailLabel.gridy = 2;
		add(emailLabel, gbc_emailLabel);

		emailField = new JTextField();
		emailField.setForeground(new Color(128, 128, 128));
		emailField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		emailField.setBorder(new CompoundBorder(emailField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		emailPrompt = new PromptText("ingrese correo", emailField);
		emailPrompt.changeStyle(Font.PLAIN);
		emailPrompt.changeAlpha(128);
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 10, 5, 10);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 0;
		gbc_emailField.gridy = 3;
		add(emailField, gbc_emailField);
		emailField.setColumns(10);

		usernameLabel = new JLabel("nombre de usuario");
		usernameLabel.setForeground(new Color(128, 128, 128));
		usernameLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.WEST;
		gbc_usernameLabel.insets = new Insets(0, 10, 5, 10);
		gbc_usernameLabel.gridx = 0;
		gbc_usernameLabel.gridy = 4;
		add(usernameLabel, gbc_usernameLabel);

		usernameField = new JTextField();
		usernameField.setForeground(new Color(128, 128, 128));
		usernameField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		usernameField.setBorder(new CompoundBorder(usernameField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		usernamePrompt = new PromptText("ingrese nombre de usuario", usernameField);
		usernamePrompt.changeStyle(Font.PLAIN);
		usernamePrompt.changeAlpha(128);
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.insets = new Insets(0, 10, 5, 10);
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.gridx = 0;
		gbc_usernameField.gridy = 5;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);

		passwordLabel = new JLabel("contraseña");
		passwordLabel.setForeground(new Color(128, 128, 128));
		passwordLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_passwordLabel.insets = new Insets(0, 10, 5, 10);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 6;
		add(passwordLabel, gbc_passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(128, 128, 128));
		passwordField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		passwordField.setBorder(new CompoundBorder(passwordField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		passwordField.setEchoChar('•');
		passwordPrompt = new PromptText("ingrese contraseña", passwordField);
		passwordPrompt.changeStyle(Font.PLAIN);
		passwordPrompt.changeAlpha(128);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 10, 5, 10);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 7;
		add(passwordField, gbc_passwordField);

		confirmPasswordLabel = new JLabel("confirmar contraseña");
		confirmPasswordLabel.setForeground(new Color(128, 128, 128));
		confirmPasswordLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
		GridBagConstraints gbc_confirmPasswordLabel = new GridBagConstraints();
		gbc_confirmPasswordLabel.anchor = GridBagConstraints.WEST;
		gbc_confirmPasswordLabel.insets = new Insets(0, 10, 5, 10);
		gbc_confirmPasswordLabel.gridx = 0;
		gbc_confirmPasswordLabel.gridy = 8;
		add(confirmPasswordLabel, gbc_confirmPasswordLabel);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setForeground(new Color(128, 128, 128));
		confirmPasswordField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		confirmPasswordField
				.setBorder(new CompoundBorder(confirmPasswordField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		confirmPasswordField.setEchoChar('•');
		confirmPasswordPrompt = new PromptText("confirme contraseña", confirmPasswordField);
		confirmPasswordPrompt.changeStyle(Font.PLAIN);
		confirmPasswordPrompt.changeAlpha(128);
		GridBagConstraints gbc_confirmPasswordField = new GridBagConstraints();
		gbc_confirmPasswordField.insets = new Insets(0, 10, 5, 10);
		gbc_confirmPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_confirmPasswordField.gridx = 0;
		gbc_confirmPasswordField.gridy = 9;
		add(confirmPasswordField, gbc_confirmPasswordField);

		registerButton = new JButton("Registrarse");
		registerButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		registerButton.setFocusPainted(false);
		registerButton.addActionListener(listener);
		registerButton.setActionCommand("Registrarse - Usuario");
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.insets = new Insets(10, 0, 5, 0);
		gbc_registerButton.gridx = 0;
		gbc_registerButton.gridy = 10;
		add(registerButton, gbc_registerButton);

		wantToLoginButton = new JButton("¿Quieres ingresar?");
		wantToLoginButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		wantToLoginButton.setFocusPainted(false);
		wantToLoginButton.addActionListener(listener);
		wantToLoginButton.setActionCommand("¿Quieres ingresar?");
		GridBagConstraints gbc_wantToLoginButton = new GridBagConstraints();
		gbc_wantToLoginButton.insets = new Insets(0, 0, 5, 0);
		gbc_wantToLoginButton.gridx = 0;
		gbc_wantToLoginButton.gridy = 11;
		add(wantToLoginButton, gbc_wantToLoginButton);
	}

	/**
	 * 
	 * getRegisterEmailFieldText String method
	 * 
	 * @return registerEmailFieldText
	 */

	public String getRegisterEmailFieldText() {
		return emailField.getText();
	}

	/**
	 * 
	 * getRegisterUsernameFieldText String method
	 * 
	 * @return registerUsernameFieldText
	 */

	public String getRegisterUsernameFieldText() {
		return usernameField.getText();
	}

	/**
	 * 
	 * getRegisterPasswordFieldText String method
	 * 
	 * @return registerPasswordFieldText
	 */

	public String getRegisterPasswordFieldText() {
		return String.valueOf(passwordField.getPassword());
	}

	/**
	 * 
	 * getRegisterConfirmPasswordFieldText String method
	 * 
	 * @return registerConfirmPasswordFieldText
	 */

	public String getRegisterConfirmPasswordFieldText() {
		return String.valueOf(confirmPasswordField.getPassword());
	}

	/**
	 * 
	 * emptyFields void method
	 */

	public void emptyRegisterFields() {
		emailField.setText("");
		usernameField.setText("");
		passwordField.setText("");
		confirmPasswordField.setText("");
	}

	/**
	 * getRegisterButton method
	 * 
	 * @return registerButton
	 */

	public JButton getRegisterButton() {
		return registerButton;
	}

	/**
	 * 
	 * setDefaultRegisterPanelCursorPosition void method
	 */

	public void setDefaultRegisterPanelCursorPosition() {
		emailField.requestFocusInWindow();
	}
}
