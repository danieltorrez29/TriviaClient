package co.edu.uptc.model.business;

import java.util.ArrayList;

/**
 * 
 * Question class
 * 
 * @author Daniel Torres
 */

public class Question {

	/**
	 * Statement
	 */

	private String statement;

	/**
	 * Answer list
	 */

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