package co.edu.uptc.model.business;

import java.util.ArrayList;

/**
 * @author Daniel Torres
 * @Date 7/12/2022
 * @Description ClientSideGame Class
 */

public class ClientSideGame {

	/**
	 * Attribute declaration
	 */

	private ArrayList<Difficulty> questions;
	private User loggedInUser;
	private StopWatch stopWatch;
	private ArrayList<User> topFiveUsers;

	/**
	 * Constructor method
	 */

	public ClientSideGame(ArrayList<Difficulty> questions) {
		this.questions = questions;
		stopWatch = new StopWatch();
	}

	/**
	 * 
	 * getAnyDifficulty Difficulty method that returns a Difficulty object given a
	 * difficulty level
	 * 
	 * @param level
	 * @return Difficulty
	 */

	public Difficulty getAnyDifficulty(int level) {
		return questions.stream().filter(question -> question.getLevel() == level).findAny().orElse(null);
	}

	/**
	 * 
	 * setLoggedInUserStats void method
	 * 
	 * @param level
	 * @param categorie
	 * @param correct
	 * @param incorrect
	 * @param score
	 * @param accuracy
	 * @param time
	 */

	public void setLoggedInUserStats(String level, String categorie, int correct, int incorrect, int score,
			double accuracy, int time) {
		Stats loggedInUserStats = loggedInUser.getStats();
		loggedInUserStats.setLevel(level);
		loggedInUserStats.setCategorie(categorie);
		loggedInUserStats.setCorrect(correct);
		loggedInUserStats.setIncorrect(incorrect);
		loggedInUserStats.setScore(score);
		loggedInUserStats.setAccuracy(accuracy);
		loggedInUserStats.setTime(time);
	}

	/**
	 * getLoggedInUser method
	 * 
	 * @return loggedInUser
	 */

	public User getLoggedInUser() {
		return loggedInUser;
	}

	/**
	 * setLoggedInUser method
	 * 
	 * @param loggedInUser
	 */

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	/**
	 * setQuestions method
	 * 
	 * @param questions
	 */

	public void setQuestions(ArrayList<Difficulty> questions) {
		this.questions = questions;
	}

	/**
	 * 
	 * startStopWatch void method
	 */

	public void startStopWatch() {
		stopWatch.start();
	}

	/**
	 * 
	 * stopStopWatch void method
	 */

	public void stopStopWatch() {
		stopWatch.stop();
	}

	/**
	 * 
	 * getElapsedSeconds int method
	 * 
	 * @return int
	 */

	public int getElapsedSeconds() {
		return (int) stopWatch.getElapsedSeconds();
	}

	/**
	 * getTopFiveUsers method that returns best five users list regarding its score
	 * 
	 * @return topFiveUsers
	 */

	public ArrayList<User> getTopFiveUsers() {
		return topFiveUsers;
	}

	/**
	 * setTopFiveUsers method
	 * 
	 * @param topFiveUsers
	 */

	public void setTopFiveUsers(ArrayList<User> topFiveUsers) {
		this.topFiveUsers = topFiveUsers;
	}
}