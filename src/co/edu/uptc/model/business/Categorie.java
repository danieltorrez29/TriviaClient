package co.edu.uptc.model.business;

import java.util.ArrayList;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description Categorie Class
 */

public class Categorie {

	/**
	 * Attribute declaration
	 */

	private String name;
	private ArrayList<Question> questions;

	/**
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