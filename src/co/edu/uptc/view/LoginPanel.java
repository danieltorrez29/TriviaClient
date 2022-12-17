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
 * 
 * LoginPanel class
 * 
 * @author Daniel Torres
 */

public class LoginPanel extends JPanel {

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
	 * Username label
	 */

	private JLabel usernameLabel;

	/**
	 * Password label
	 */

	private JLabel passwordLabel;

	/**
	 * Username field
	 */

	private JTextField usernameField;

	/**
	 * Password field
	 */

	private JPasswordField passwordField;

	/**
	 * Username prompt text
	 */

	private PromptText usernamePrompt;

	/**
	 * Password prompt text
	 */

	private PromptText passwordPrompt;

	/**
	 * Login button
	 */

	private JButton loginButton;

	/**
	 * Create account button
	 */

	private JButton createAccountButton;

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

		usernameLabel = new JLabel("username");
		usernameLabel.setFont(new Font("Ebrima", Font.PLAIN, 16));
		usernameLabel.setForeground(new Color(128, 128, 128));
		GridBagConstraints gbc_emailUsernameLabel = new GridBagConstraints();
		gbc_emailUsernameLabel.anchor = GridBagConstraints.WEST;
		gbc_emailUsernameLabel.insets = new Insets(0, 10, 5, 10);
		gbc_emailUsernameLabel.fill = GridBagConstraints.VERTICAL;
		gbc_emailUsernameLabel.gridx = 0;
		gbc_emailUsernameLabel.gridy = 2;
		add(usernameLabel, gbc_emailUsernameLabel);

		usernameField = new JTextField();
		usernameField.setColumns(30);
		usernameField.setForeground(new Color(128, 128, 128));
		usernameField.setFont(new Font("Ebrima", Font.PLAIN, 16));
		usernameField.setBorder(new CompoundBorder(usernameField.getBorder(), new EmptyBorder(5, 0, 5, 0)));
		usernamePrompt = new PromptText("enter username", usernameField);
		usernamePrompt.changeStyle(Font.PLAIN);
		usernamePrompt.changeAlpha(128);
		GridBagConstraints gbc_loginEmailUsernameField = new GridBagConstraints();
		gbc_loginEmailUsernameField.insets = new Insets(0, 10, 5, 10);
		gbc_loginEmailUsernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginEmailUsernameField.gridx = 0;
		gbc_loginEmailUsernameField.gridy = 3;
		add(usernameField, gbc_loginEmailUsernameField);

		passwordLabel = new JLabel("password");
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
		passwordPrompt = new PromptText("enter password", passwordField);
		passwordPrompt.changeStyle(Font.PLAIN);
		passwordPrompt.changeAlpha(128);
		GridBagConstraints gbc_loginPasswordField = new GridBagConstraints();
		gbc_loginPasswordField.insets = new Insets(0, 10, 5, 10);
		gbc_loginPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginPasswordField.gridx = 0;
		gbc_loginPasswordField.gridy = 5;
		add(passwordField, gbc_loginPasswordField);

		loginButton = new JButton("Sign In");
		loginButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		loginButton.setFocusPainted(false);
		loginButton.addActionListener(listener);
		loginButton.setActionCommand("Sign In");
		GridBagConstraints gbc_loginButton = new GridBagConstraints();
		gbc_loginButton.insets = new Insets(10, 0, 5, 0);
		gbc_loginButton.gridx = 0;
		gbc_loginButton.gridy = 6;
		add(loginButton, gbc_loginButton);

		createAccountButton = new JButton("Create Account");
		createAccountButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
		createAccountButton.setFocusPainted(false);
		createAccountButton.addActionListener(listener);
		createAccountButton.setActionCommand("Create Account");
		GridBagConstraints gbc_registerButton = new GridBagConstraints();
		gbc_registerButton.insets = new Insets(0, 0, 280, 0);
		gbc_registerButton.gridx = 0;
		gbc_registerButton.gridy = 7;
		add(createAccountButton, gbc_registerButton);
	}

	/**
	 * 
	 * getLoginUsernameFieldText String method
	 * 
	 * @return username field text
	 */

	public String getLoginUsernameFieldText() {
		return usernameField.getText();
	}

	/**
	 * 
	 * getPasswordFieldText String method
	 * 
	 * @return login password field text
	 */

	public String getLoginPasswordFieldText() {
		return String.valueOf(passwordField.getPassword());
	}

	/**
	 * 
	 * emptyLoginFields void method
	 */

	public void emptyLoginFields() {
		usernameField.setText("");
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
		usernameField.requestFocusInWindow();
	}
}