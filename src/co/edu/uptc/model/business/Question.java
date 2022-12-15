package co.edu.uptc.model.business;

import java.util.ArrayList;

/**
 * @author Daniel Torres
 * @Date 16/11/2022
 * @Description Question Class
 */

public class Question {
	/**
	 * Attribute declaration
	 */

	private String statement;
	private ArrayList<Answer> answers;

	/**
	 * Constructor method
	 * 
	 * @param statement
	 * @param answers
	 */

	public Question(String statement, ArrayList<Answer> answers) {
		this.statement = statement;
		this.answers = answers;
	}

	/**
	 * getStatement method
	 * 
	 * @return statement
	 */

	public String getStatement() {
		return statement;
	}

	/**
	 * getAnswers method
	 * 
	 * @return answers
	 */

	public ArrayList<Answer> getAnswers() {
		return answers;
	}
}