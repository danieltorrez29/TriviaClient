package co.edu.uptc.model.business;

import java.util.ArrayList;

/**
 * 
 * Categorie class
 * 
 * @author Daniel Torres
 */

public class Categorie {

	/**
	 * Name
	 */

	private String name;

	/**
	 * Question list
	 */

	private ArrayList<Question> questions;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param name
	 * @param questions
	 */

	public Categorie(String name, ArrayList<Question> questions) {
		this.name = name;
		this.questions = questions;
	}

	/**
	 * getName method
	 * 
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**
	 * getQuestions method
	 * 
	 * @return questions
	 */

	public ArrayList<Question> getQuestions() {
		return questions;
	}
}