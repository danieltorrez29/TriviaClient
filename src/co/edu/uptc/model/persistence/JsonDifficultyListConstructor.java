package co.edu.uptc.model.persistence;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import co.edu.uptc.model.business.Answer;
import co.edu.uptc.model.business.Difficulty;
import co.edu.uptc.model.business.Question;
import co.edu.uptc.model.business.Categorie;

/**
 * 
 * JsonDifficultyListConstructor class
 * 
 * @author Daniel Torres
 */

public class JsonDifficultyListConstructor {

	/**
	 * 
	 * getQuestions method that builds a Difficulty list from a json String
	 * 
	 * @param jsonQuestions
	 * @return Difficulty List
	 */

	public static ArrayList<Difficulty> getQuestions(String jsonQuestions) {
		ArrayList<Difficulty> difficultyList = new ArrayList<Difficulty>();
		ArrayList<Categorie> easyCategorieList = new ArrayList<Categorie>();
		ArrayList<Categorie> hardCategorieList = new ArrayList<Categorie>();
		ArrayList<Question> questionList;
		ArrayList<Answer> answerList;
		String categorie = "";
		String statement = "";
		int level = 0;
		JsonArray levelArray = JsonParser.parseString(jsonQuestions).getAsJsonArray();
		for (JsonElement levelElement : levelArray) {
			JsonObject levelObject = levelElement.getAsJsonObject();

			categorie = levelObject.get("categorie").getAsString();
			level = levelObject.get("level").getAsInt();

			JsonArray questionArray = levelObject.getAsJsonArray("questions");

			questionList = new ArrayList<Question>();

			for (JsonElement questionElement : questionArray) {
				JsonObject questionObject = questionElement.getAsJsonObject();

				statement = questionObject.get("statement").getAsString();

				JsonArray answerArray = questionObject.getAsJsonArray("answers");

				answerList = new ArrayList<Answer>();

				for (JsonElement answerElement : answerArray) {
					JsonObject answerObject = answerElement.getAsJsonObject();

					answerList.add(new Answer(answerObject.get("statement").getAsString(),
							answerObject.get("flagIsCorrect").getAsBoolean(),
							answerObject.get("flagFiftyFifty").getAsBoolean()));
				}
				questionList.add(new Question(statement, answerList));
			}
			if (level == 0) {
				easyCategorieList.add(new Categorie(categorie, questionList));
			} else {
				hardCategorieList.add(new Categorie(categorie, questionList));
			}
		}
		difficultyList.add(new Difficulty(0, easyCategorieList));
		difficultyList.add(new Difficulty(1, hardCategorieList));
		return difficultyList;
	}
}