package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import co.edu.uptc.model.business.Difficulty;
import co.edu.uptc.model.business.Question;
import co.edu.uptc.model.business.User;

/**
 * @author Daniel Torres
 * @Date 16/11/2022
 * @Description TriviaFrame Class
 */

public class TriviaFrame extends JFrame {

	/**
	 * Identifiers
	 */

	private final static String WELCOME_PANEL = "welcomePanel";
	private final static String LOGIN_PANEL = "loginPanel";
	private final static String REGISTER_PANEL = "registerPanel";
	private final static String LEVEL_TOPIC_SELECION_PANEL = "levelTopicSelectionPanel";
	private final static String QUESTIONS_PANEL = "questionsPanel";
	private final static String STATS_PANEL = "statsPanel";
	private final static String PODIUM_PANEL = "podiumPanel";

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;
	private RegisterPanel registerPanel;
	private LevelTopicSelectionPanel levelTopicSelectionPanel;
	private QuestionsPanel questionsPanel;
	private StatsPanel statsPanel;
	private PodiumPanel podiumPanel;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 * @param easyCategorieList
	 * @param hardCategorieList
	 */

	public TriviaFrame(ActionListener listener, Difficulty easyCategorieList, Difficulty hardCategorieList) {
		super("Trivia");
		setSize(420, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("resources/images/logo.png"));
		setLookAndFeel();
		initComponents(listener, easyCategorieList, hardCategorieList);
		initPanels();
		setVisible(true);
	}

	/**
	 * 
	 * setLookAndFeel void method
	 */

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("ToggleButton.select", new Color(224, 238, 249));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * initComponents void method
	 * 
	 * @param listener
	 */

	private void initComponents(ActionListener listener, Difficulty easyCategorieList, Difficulty hardCategorieList) {
		contentPane = new JPanel();
		welcomePanel = new WelcomePanel(listener);
		loginPanel = new LoginPanel(listener);
		registerPanel = new RegisterPanel(listener);
		levelTopicSelectionPanel = new LevelTopicSelectionPanel(listener, easyCategorieList, hardCategorieList);
		questionsPanel = new QuestionsPanel(listener);
		statsPanel = new StatsPanel(listener);
		podiumPanel = new PodiumPanel(listener);

		contentPane.setLayout(new CardLayout());
		setContentPane(contentPane);
	}

	/**
	 * 
	 * initPanels void method
	 */

	private void initPanels() {
		contentPane.add(welcomePanel, WELCOME_PANEL);
		contentPane.add(loginPanel, LOGIN_PANEL);
		contentPane.add(registerPanel, REGISTER_PANEL);
		contentPane.add(levelTopicSelectionPanel, LEVEL_TOPIC_SELECION_PANEL);
		contentPane.add(questionsPanel, QUESTIONS_PANEL);
		contentPane.add(statsPanel, STATS_PANEL);
		contentPane.add(podiumPanel, PODIUM_PANEL);
	}

	/**
	 * 
	 * changePanel void method
	 * 
	 * @param command
	 */

	public void changePanel(String command) {
		((CardLayout) contentPane.getLayout()).show(contentPane, command);
	}

	/**
	 * 
	 * getLoginEmailUsernameFieldText String method
	 * 
	 * @return loginEmailUsernameFieldText
	 */

	public String getLoginEmailUsernameFieldText() {
		return loginPanel.getLoginEmailUsernameFieldText();
	}

	/**
	 * 
	 * getLoginPasswordFieldText String method
	 * 
	 * @return loginPasswordFieldText
	 */

	public String getLoginPasswordFieldText() {
		return loginPanel.getLoginPasswordFieldText();
	}

	/**
	 * 
	 * emptyLoginFields void method
	 */

	public void emptyLoginFields() {
		loginPanel.emptyLoginFields();
	}

	/**
	 * 
	 * getRegisterEmailFieldText String method
	 * 
	 * @return registerEmailFieldText
	 */

	public String getRegisterEmailFieldText() {
		return registerPanel.getRegisterEmailFieldText();
	}

	/**
	 * 
	 * getRegisterUsernameFieldText String method
	 * 
	 * @return registerUsernameFieldText
	 */

	public String getRegisterUsernameFieldText() {
		return registerPanel.getRegisterUsernameFieldText();
	}

	/**
	 * 
	 * getRegisterPasswordFieldText String method
	 * 
	 * @return registerPasswordFieldText
	 */

	public String getRegisterPasswordFieldText() {
		return registerPanel.getRegisterPasswordFieldText();
	}

	/**
	 * 
	 * getRegisterConfirmPasswordFieldText String method
	 * 
	 * @return registerConfirmPasswordFieldText
	 */

	public String getRegisterConfirmPasswordFieldText() {
		return registerPanel.getRegisterConfirmPasswordFieldText();
	}

	/**
	 * 
	 * emptyFields void method
	 */

	public void emptyRegisterFields() {
		registerPanel.emptyRegisterFields();
	}

	/**
	 * 
	 * getLevelSelected String method
	 * 
	 * @return level selected
	 */

	public String getLevelSelected() {
		return levelTopicSelectionPanel.getLevelSelected();
	}

	/**
	 * 
	 * getEasyTopicSelected String method
	 * 
	 * @return easy topic selected
	 */

	public String getEasyTopicSelected() {
		return levelTopicSelectionPanel.getEasyTopicSelected();
	}

	/**
	 * 
	 * getHardTopicSelected String method
	 * 
	 * @return hard topic selected
	 */

	public String getHardTopicSelected() {
		return levelTopicSelectionPanel.getHardTopicSelected();
	}

	/**
	 * 
	 * setStats void method
	 * 
	 * @param loggedInUser
	 */

	public void setUIStats(User loggedInUser) {
		statsPanel.setUIStats(loggedInUser);
	}

	/**
	 * 
	 * setQuestionsPanels void method
	 * 
	 * @param questions
	 */

	public void setQuestionsPanels(ArrayList<Question> questions) {
		questionsPanel.setQuestionsPanels(questions);
	}

	/**
	 * 
	 * isCorrectSelectedAnswer boolean method
	 * 
	 * @return
	 */

	public boolean isCorrectSelectedAnswer() {
		return questionsPanel.isCorrectSelectedAnswer();
	}

	/**
	 * 
	 * nextQuestionPanel void method
	 */

	public void nextQuestionPanel() {
		questionsPanel.nextQuestionPanel();
	}

	/**
	 * 
	 * hideIncorrectAnswersAction void method
	 */

	public void hideIncorrectAnswersAction() {
		questionsPanel.hideIncorrectAnswersAction();
	}

	/**
	 * 
	 * incrementCorrect void method
	 */

	public void incrementCorrect() {
		questionsPanel.incrementCorrect();
	}

	/**
	 * 
	 * incrementIncorrect void method
	 */

	public void incrementIncorrect() {
		questionsPanel.incrementIncorrect();
	}

	/**
	 * 
	 * incrementLastQuestionPanelAux void method
	 */

	public void incrementLastQuestionPanelAux() {
		questionsPanel.incrementLastQuestionPanelAux();
	}

	/**
	 * getCorrect method
	 * 
	 * @return correct
	 */

	public int getCorrect() {
		return questionsPanel.getCorrect();
	}

	/**
	 * getIncorrect method
	 * 
	 * @return incorrect
	 */

	public int getIncorrect() {
		return questionsPanel.getIncorrect();
	}

	/**
	 * getLastQuestionPanelAux method
	 * 
	 * @return lastQuestionPanelAux
	 */

	public int getLastQuestionPanelAux() {
		return questionsPanel.getLastQuestionPanelAux();
	}

	/**
	 * 
	 * getQuestionComponetsCount int method
	 * 
	 * @return questions panels count
	 */

	public int getQuestionComponetsCount() {
		return questionsPanel.getQuestionComponetsCount();
	}

	/**
	 * 
	 * isAnyAnswerSelected boolean method
	 * 
	 * @return true || false
	 */

	public boolean isAnyAnswerSelected() {
		return questionsPanel.isAnyAnswerSelected();
	}

	/**
	 * 
	 * emptyQuestionsCardPanel void method
	 * 
	 * @param questions
	 */

	public void emptyQuestionsCardPanel() {
		questionsPanel.emptyQuestionsCardPanel();
	}

	/**
	 * 
	 * setStatsFromScratch void method
	 */

	public void setStatsFromScratch() {
		questionsPanel.setStatsFromScratch();
	}

	/**
	 * 
	 * repaintStatsPanel void method
	 * 
	 * @param accuracy
	 */

	public void repaintStatsPanel(double accuracy) {
		statsPanel.repaintStatsPanel(accuracy);
	}

	/**
	 * 
	 * setDefaultLoginPanelButton void method
	 */

	public void setDefaultLoginPanelButton() {
		getRootPane().setDefaultButton(loginPanel.getLoginButton());
	}

	/**
	 * 
	 * setDefaultRegisterPanelButton void method
	 */

	public void setDefaultRegisterPanelButton() {
		getRootPane().setDefaultButton(registerPanel.getRegisterButton());
	}

	/**
	 * 
	 * setDefaultLevelTopicSelecionPanelButton void method
	 */

	public void setDefaultLevelTopicSelecionPanelButton() {
		getRootPane().setDefaultButton(levelTopicSelectionPanel.getPlayButton());
	}

	/**
	 * 
	 * setDefaultQuestionsPanelButton void method
	 */

	public void setDefaultQuestionsPanelButton() {
		getRootPane().setDefaultButton(questionsPanel.getNextButton());
	}

	/**
	 * 
	 * setDefaultStatsPanelButton void method
	 */

	public void setDefaultStatsPanelButton() {
		getRootPane().setDefaultButton(statsPanel.getHomeButton());
	}

	/**
	 * 
	 * setDefaultLoginPanelCursorPosition void method
	 */

	public void setDefaultLoginPanelCursorPosition() {
		loginPanel.setDefaultLoginPanelCursorPosition();
	}

	/**
	 * 
	 * setDefaultRegisterPanelCursorPosition void method
	 */

	public void setDefaultRegisterPanelCursorPosition() {
		registerPanel.setDefaultRegisterPanelCursorPosition();
	}

	/**
	 * 
	 * setDefaultLevelTopicSelectionPanelComboBox void method
	 */

	public void setDefaultLevelTopicSelectionPanelCursorPosition() {
		levelTopicSelectionPanel.setDefaultLevelTopicSelectionPanelCursorPosition();
	}

	/**
	 * 
	 * setDefaultPodiumPanelButton void method
	 */

	public void setDefaultPodiumPanelButton() {
		getRootPane().setDefaultButton(podiumPanel.getHomeButton());
	}

	/**
	 * 
	 * setUIPodiumUsers void method
	 * 
	 * @param users
	 */

	public void setUIPodiumUsers(ArrayList<User> users) {
		podiumPanel.setUIPodiumUsers(users);
	}
}