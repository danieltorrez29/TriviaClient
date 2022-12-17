package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.model.business.Question;

/**
 * 
 * QuestionsPanel class
 * 
 * @author Daniel Torres
 */

public class QuestionsPanel extends JPanel {

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Purple panel
	 */

	private JPanel purplePanel;

	/**
	 * Questions card panel
	 */

	private JPanel questionsCardPanel;

	/**
	 * Empty panel
	 */

	private JPanel emptyPanel;

	/**
	 * Logo label
	 */

	private JLabel logoLabel;

	/**
	 * Question panel
	 */

	private QuestionPanel questionPanel;

	/**
	 * Next button
	 */

	private JButton nextButton;

	/**
	 * Fifty button
	 */

	private JButton fiftyButton;

	/**
	 * Correct
	 */

	private int correct;

	/**
	 * Incorrect
	 */

	private int incorrect;

	/**
	 * Last question panel aux
	 */

	private int lastQuestionPanelAux;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param listener
	 */

	public QuestionsPanel(ActionListener listener) {
		setSize(420, 900);
		correct = incorrect = 0;
		lastQuestionPanelAux = 1;
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
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 162, 0, 407, 0, 59, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		purplePanel = new JPanel();
		purplePanel.setBackground(new Color(61, 8, 89));
		GridBagConstraints gbc_purplePanel = new GridBagConstraints();
		gbc_purplePanel.insets = new Insets(0, 0, 5, 0);
		gbc_purplePanel.gridwidth = 2;
		gbc_purplePanel.fill = GridBagConstraints.BOTH;
		gbc_purplePanel.gridx = 0;
		gbc_purplePanel.gridy = 0;
		add(purplePanel, gbc_purplePanel);

		logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon("resources/images/logo.png"));
		GridBagConstraints gbc_logoLabel = new GridBagConstraints();
		gbc_logoLabel.gridwidth = 2;
		gbc_logoLabel.insets = new Insets(20, 0, 5, 0);
		gbc_logoLabel.gridx = 0;
		gbc_logoLabel.gridy = 1;
		add(logoLabel, gbc_logoLabel);

		questionsCardPanel = new JPanel();
		GridBagConstraints gbc_questionsCardPanel = new GridBagConstraints();
		gbc_questionsCardPanel.gridwidth = 2;
		gbc_questionsCardPanel.insets = new Insets(0, 0, 5, 0);
		gbc_questionsCardPanel.fill = GridBagConstraints.BOTH;
		gbc_questionsCardPanel.gridx = 0;
		gbc_questionsCardPanel.gridy = 2;
		add(questionsCardPanel, gbc_questionsCardPanel);
		questionsCardPanel.setLayout(new CardLayout(0, 0));

		fiftyButton = new JButton("50/50");
		fiftyButton.setFocusPainted(false);
		fiftyButton.setMargin(new Insets(2, 60, 2, 60));
		fiftyButton.setFont(new Font("Ebrima", Font.BOLD, 16));
		fiftyButton.addActionListener(listener);
		fiftyButton.setActionCommand("50/50");
		GridBagConstraints gbc_fiftyButton = new GridBagConstraints();
		gbc_fiftyButton.insets = new Insets(0, 0, 15, 5);
		gbc_fiftyButton.gridx = 0;
		gbc_fiftyButton.gridy = 3;
		add(fiftyButton, gbc_fiftyButton);

		nextButton = new JButton("Next");
		nextButton.setMargin(new Insets(2, 50, 2, 50));
		nextButton.setFocusPainted(false);
		nextButton.setFont(new Font("Ebrima", Font.BOLD, 16));
		nextButton.addActionListener(listener);
		nextButton.setActionCommand("Next");
		GridBagConstraints gbc_nextButton = new GridBagConstraints();
		gbc_nextButton.insets = new Insets(0, 0, 15, 0);
		gbc_nextButton.gridx = 1;
		gbc_nextButton.gridy = 3;
		add(nextButton, gbc_nextButton);

		emptyPanel = new JPanel();
		GridBagConstraints gbc_emptyPanel = new GridBagConstraints();
		gbc_emptyPanel.gridwidth = 2;
		gbc_emptyPanel.insets = new Insets(0, 0, 0, 5);
		gbc_emptyPanel.fill = GridBagConstraints.BOTH;
		gbc_emptyPanel.gridx = 0;
		gbc_emptyPanel.gridy = 5;
		add(emptyPanel, gbc_emptyPanel);
	}

	/**
	 * 
	 * setQuestionsPanels void method
	 * 
	 * @param questions
	 */

	public void setQuestionsPanels(ArrayList<Question> questions) {
		for (Question question : questions) {
			questionPanel = new QuestionPanel();
			questionPanel.initComponents(question);
			questionsCardPanel.add(questionPanel);
		}
	}

	/**
	 * 
	 * emptyQuestionsCardPanel void method
	 */

	public void emptyQuestionsCardPanel() {
		questionsCardPanel.removeAll();
	}

	/**
	 * 
	 * getCurrentQuestionPanel QuestionPanel method
	 * 
	 * @return current question panel
	 */

	private QuestionPanel getCurrentQuestionPanel() {
		QuestionPanel currentCard = null;
		for (Component component : questionsCardPanel.getComponents())
			if (component.isVisible()) {
				currentCard = (QuestionPanel) component;
				break;
			}
		return currentCard;
	}

	/**
	 * 
	 * isAnyAnswerSelected boolean method
	 * 
	 * @return true || false
	 */

	public boolean isAnyAnswerSelected() {
		return getCurrentQuestionPanel().getButtonGroup().getSelection() != null ? true : false;
	}

	/**
	 * 
	 * isCorrectSelectedAnswer boolean method
	 * 
	 * @return true || false
	 */

	public boolean isCorrectSelectedAnswer() {
		return getCurrentQuestionPanel().isCorrectSelectedAnswer();
	}

	/**
	 * 
	 * hideIncorrectAnswersAction void method
	 */

	public void hideWrongAnswersAction() {
		getCurrentQuestionPanel().hideIncorrectAnswers();
	}

	/**
	 * 
	 * nextQuestionPanel void method
	 */

	public void nextQuestionPanel() {
		((CardLayout) questionsCardPanel.getLayout()).next(questionsCardPanel);
	}

	/**
	 * 
	 * incrementCorrect void method
	 */

	public void incrementCorrect() {
		this.correct++;
	}

	/**
	 * 
	 * incrementIncorrect void method
	 */

	public void incrementIncorrect() {
		this.incorrect++;
	}

	/**
	 * 
	 * incrementLastQuestionPanelAux void method
	 */

	public void incrementLastQuestionPanelAux() {
		this.lastQuestionPanelAux++;
	}

	/**
	 * getCorrect method
	 * 
	 * @return correct
	 */

	public int getCorrect() {
		return correct;
	}

	/**
	 * getIncorrect method
	 * 
	 * @return incorrect
	 */

	public int getIncorrect() {
		return incorrect;
	}

	/**
	 * getLastQuestionPanelAux method
	 * 
	 * @return lastQuestionPanelAux
	 */

	public int getLastQuestionPanelAux() {
		return lastQuestionPanelAux;
	}

	/**
	 * 
	 * getQuestionComponetsCount int method
	 * 
	 * @return question card panel components count
	 */

	public int getQuestionComponetsCount() {
		return questionsCardPanel.getComponentCount();
	}

	/**
	 * 
	 * setStatsFromScratch void method
	 */

	public void setStatsFromScratch() {
		this.correct = 0;
		this.incorrect = 0;
		this.lastQuestionPanelAux = 1;
	}

	/**
	 * getNextButton method
	 * 
	 * @return nextButton
	 */

	public JButton getNextButton() {
		return nextButton;
	}
}