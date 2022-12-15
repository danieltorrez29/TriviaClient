package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import co.edu.uptc.model.business.Answer;
import co.edu.uptc.model.business.Question;

/**
 * @author Daniel Torres
 * @Date 16/11/2022
 * @Description QuestionPanel Class
 */

public class QuestionPanel extends JPanel {

	/**
	 * Attribute declaration
	 */

	private static final long serialVersionUID = 1L;
	private JTextArea questionStatementTextArea;
	private JToggleButton answerToggleButton;
	private JToggleButton firstFlagToggleButton;
	private JToggleButton secondFlagToggleButton;
	private ButtonGroup buttonGroup;

	/**
	 * 
	 * Constructor method
	 */

	public QuestionPanel() {
		setSize(420, 350);
		setLayout(null);
	}

	/**
	 * 
	 * initComponents void method
	 * 
	 * @param question
	 */

	public void initComponents(Question question) {
		questionStatementTextArea = new JTextArea(question.getStatement());
		questionStatementTextArea.setFont(new Font("Ebrima", Font.BOLD, 18));
		questionStatementTextArea.setEditable(false);
		questionStatementTextArea.setBackground(new Color(240, 240, 240));
		questionStatementTextArea.setBounds(52, 40, 328, 72);
		questionStatementTextArea.setWrapStyleWord(true);
		questionStatementTextArea.setLineWrap(true);
		add(questionStatementTextArea);

		int yPositionAux = 138;
		int countFlagAux = 0;

		buttonGroup = new ButtonGroup();

		for (Answer answer : question.getAnswers()) {
			answerToggleButton = new JToggleButton(answer.getStatement());
			answerToggleButton.setFont(new Font("Ebrima", Font.PLAIN, 16));
			answerToggleButton.setBounds(52, yPositionAux, 328, 23);
			answerToggleButton.setFocusPainted(false);
			answerToggleButton.setUI(new MetalToggleButtonUI());

			if (answer.getFlagIsCorrect())
				answerToggleButton.setActionCommand(Boolean.toString(answer.getFlagIsCorrect()));

			if (answer.getFlagFiftyFifty() == false) {
				countFlagAux++;
				if (countFlagAux == 1) {
					firstFlagToggleButton = answerToggleButton;
				} else {
					secondFlagToggleButton = answerToggleButton;
				}
			}
			add(answerToggleButton);

			buttonGroup.add(answerToggleButton);
			yPositionAux += 34;
		}
	}

	/**
	 * 
	 * isCorrectSelectedAnswer boolean method
	 * 
	 * @return true || false
	 */

	public boolean isCorrectSelectedAnswer() {
		return buttonGroup.getSelection().getActionCommand() != null ? true : false;
	}

	/**
	 * 
	 * hideIncorrectAnswers void method
	 */

	public void hideIncorrectAnswers() {
		firstFlagToggleButton.setVisible(false);
		secondFlagToggleButton.setVisible(false);
	}

	/**
	 * getButtonGroup method
	 * 
	 * @return buttonGroup
	 */

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}
}
