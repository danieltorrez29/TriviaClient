package co.edu.uptc.present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

import co.edu.uptc.model.business.ClientSideGame;
import co.edu.uptc.model.persistence.JsonDifficultyListConstructor;
import co.edu.uptc.model.persistence.JsonRequestConstructor;
import co.edu.uptc.net.Connection;
import co.edu.uptc.net.Request;
import co.edu.uptc.view.MessageDialog;
import co.edu.uptc.view.TriviaFrame;

/**
 * 
 * ClientPresenter class
 * 
 * @author Daniel Torres
 */

public class ClientPresenter implements ActionListener {

	/**
	 * Client-side manager
	 */

	private ClientSideGame clientSideGame;

	/**
	 * Connection object
	 */

	private Connection connection;

	/**
	 * Trivia frame
	 */

	private TriviaFrame triviaFrame;

	/**
	 * Constructor method
	 */

	public ClientPresenter() {
		initConnection();
		initObjects();
	}

	/**
	 * 
	 * initConnection void method that establishes connection with server
	 */

	private void initConnection() {
		try (FileInputStream fileInputStream = new FileInputStream("resources/properties/config.properties");
				BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {
			Properties properties = new Properties();
			properties.load(bufferedInputStream);
			connection = new Connection(properties.getProperty("HOST"),
					Integer.parseInt(properties.getProperty("PORT")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * initObjects void method that instances class objects
	 */

	private void initObjects() {
		Request request = JsonRequestConstructor.createRequestObject(connection.readUTF());
		clientSideGame = new ClientSideGame(JsonDifficultyListConstructor.getQuestions(request.getQuestions()));
		triviaFrame = new TriviaFrame(this, clientSideGame.getAnyDifficulty(0), clientSideGame.getAnyDifficulty(1));
		triviaFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				connection.close();
			}
		});
	}

	/**
	 * 
	 * registerErrorAction void method that shows error show dialog window to user
	 * 
	 * @param message
	 */

	private void registerErrorAction(String message) {
		triviaFrame.emptyRegisterFields();
		MessageDialog.errorMessageDialog(triviaFrame, message);
	}

	/**
	 * actionPerformed overwrite method that is responsible for receiving responses
	 * from the server and sending requests
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		Request request = null;
		switch (command) {
		case "Start":
			triviaFrame.setDefaultLoginPanelButton();
			triviaFrame.changePanel("loginPanel");
			triviaFrame.setDefaultLoginPanelCursorPosition();
			break;

		case "Sign In":
			request = new Request();
			request.setActionCommand(command);
			request.setUsername(triviaFrame.getLoginUsernameFieldText());
			request.setPassword(triviaFrame.getLoginPasswordFieldText());
			connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
			request = JsonRequestConstructor.createRequestObject(connection.readUTF());
			if (request.isFlag()) {
				MessageDialog.confirmMessageDialog(triviaFrame, "Successfully sign in");
				clientSideGame.setLoggedInUser(request.getLoggedInUser());
				triviaFrame.emptyLoginFields();
				triviaFrame.setDefaultLevelTopicSelecionPanelButton();
				triviaFrame.changePanel("levelCategorieSelectionPanel");
				triviaFrame.setDefaultLevelCategorieSelectionPanelCursorPosition();
			} else {
				triviaFrame.emptyLoginFields();
				triviaFrame.setDefaultLoginPanelCursorPosition();
				MessageDialog.errorMessageDialog(triviaFrame, "Incorrect username or password");
			}
			break;

		case "Create Account":
			triviaFrame.setDefaultRegisterPanelButton();
			triviaFrame.changePanel("registerPanel");
			triviaFrame.setDefaultRegisterPanelCursorPosition();
			break;

		case "Create Account - User":
			request = new Request();

			if (triviaFrame.getRegisterEmailFieldText().equals("")
					|| triviaFrame.getRegisterUsernameFieldText().equals("")) {
				triviaFrame.setDefaultRegisterPanelCursorPosition();
				registerErrorAction("Invalid or existing user");
			} else {
				request.setActionCommand(command);
				request.setFlag(false);
				request.setUsername(triviaFrame.getRegisterUsernameFieldText());
				connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
				request = JsonRequestConstructor.createRequestObject(connection.readUTF());
				if (request.isFlag()) {
					triviaFrame.setDefaultRegisterPanelCursorPosition();
					registerErrorAction("Invalid or existing user");
				} else {
					if (!triviaFrame.getRegisterPasswordFieldText().equals("")
							|| !triviaFrame.getRegisterConfirmPasswordFieldText().equals("")) {
						if (triviaFrame.getRegisterPasswordFieldText()
								.equals(triviaFrame.getRegisterConfirmPasswordFieldText())) {
							request.setActionCommand(command);
							request.setFlag(true);
							request.setUsername(triviaFrame.getRegisterUsernameFieldText());
							request.setEmail(triviaFrame.getRegisterEmailFieldText());
							request.setPassword(triviaFrame.getRegisterPasswordFieldText());
							connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
							MessageDialog.confirmMessageDialog(triviaFrame, "User successfully registered");
							triviaFrame.emptyRegisterFields();
							triviaFrame.changePanel("loginPanel");
							triviaFrame.setDefaultLoginPanelCursorPosition();
						} else {
							triviaFrame.setDefaultRegisterPanelCursorPosition();
							registerErrorAction("Passwords do not match or are empty");
						}
					} else {
						triviaFrame.setDefaultRegisterPanelCursorPosition();
						registerErrorAction("Passwords do not match or are empty");
					}
				}
			}

		case "Want to login?":
			triviaFrame.emptyLoginFields();
			triviaFrame.setDefaultLoginPanelButton();
			triviaFrame.changePanel("loginPanel");
			triviaFrame.setDefaultLoginPanelCursorPosition();
			break;

		case "Play":
			clientSideGame.startStopWatch();
			triviaFrame.setDefaultQuestionsPanelButton();
			switch (triviaFrame.getLevelSelected()) {
			case "Easy":
				triviaFrame.setQuestionsPanels(clientSideGame.getAnyDifficulty(0)
						.searchCategorie(triviaFrame.getEasyTopicSelected()).getQuestions());
				triviaFrame.changePanel("questionsPanel");
				break;

			case "Hard":
				triviaFrame.setQuestionsPanels(clientSideGame.getAnyDifficulty(1)
						.searchCategorie(triviaFrame.getHardTopicSelected()).getQuestions());
				triviaFrame.changePanel("questionsPanel");
				break;

			default:
				break;
			}
			break;

		case "50/50":
			triviaFrame.hideWrongAnswersAction();
			break;

		case "Next":
			if (triviaFrame.isAnyAnswerSelected()) {
				if (triviaFrame.getLastQuestionPanelAux() != triviaFrame.getQuestionComponetsCount()) {
					if (triviaFrame.isCorrectSelectedAnswer()) {
						triviaFrame.incrementCorrect();
						triviaFrame.incrementLastQuestionPanelAux();
						MessageDialog.confirmMessageDialog(triviaFrame, "Correct Answer");
						triviaFrame.nextQuestionPanel();
					} else {
						triviaFrame.incrementIncorrect();
						triviaFrame.incrementLastQuestionPanelAux();
						MessageDialog.errorMessageDialog(triviaFrame, "Wrong Answer");
						triviaFrame.nextQuestionPanel();
					}
				} else {
					if (triviaFrame.isCorrectSelectedAnswer()) {
						clientSideGame.stopStopWatch();
						triviaFrame.incrementCorrect();
						MessageDialog.confirmMessageDialog(triviaFrame, "Correct Answer");
					} else {
						clientSideGame.stopStopWatch();
						triviaFrame.incrementIncorrect();
						MessageDialog.errorMessageDialog(triviaFrame, "Wrong Answer");
					}
					switch (triviaFrame.getLevelSelected()) {
					case "Easy":
						clientSideGame.setLoggedInUserStats(triviaFrame.getLevelSelected(),
								triviaFrame.getEasyTopicSelected(), triviaFrame.getCorrect(),
								triviaFrame.getIncorrect(),
								(triviaFrame.getCorrect() * 100) - clientSideGame.getElapsedSeconds(),
								((double) triviaFrame.getCorrect()
										/ (double) (triviaFrame.getCorrect() + triviaFrame.getIncorrect())) * 100,
								clientSideGame.getElapsedSeconds());
						break;

					case "Hard":
						clientSideGame.setLoggedInUserStats(triviaFrame.getLevelSelected(),
								triviaFrame.getHardTopicSelected(), triviaFrame.getCorrect(),
								triviaFrame.getIncorrect(),
								(triviaFrame.getCorrect() * 100) - clientSideGame.getElapsedSeconds(),
								((double) triviaFrame.getCorrect()
										/ (double) (triviaFrame.getCorrect() + triviaFrame.getIncorrect())) * 100,
								clientSideGame.getElapsedSeconds());
						break;

					default:
						break;
					}
					clientSideGame.getLoggedInUser().getStats()
							.setGamesPlayed(clientSideGame.getLoggedInUser().getStats().getGamesPlayed() + 1);
					request = new Request();
					request.setActionCommand(command);
					request.setLoggedInUser(clientSideGame.getLoggedInUser());
					connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
					triviaFrame.setUIStats(clientSideGame.getLoggedInUser());
					triviaFrame.repaintStatsPanel(clientSideGame.getLoggedInUser().getStats().getAccuracy());
					triviaFrame.setDefaultStatsPanelButton();
					MessageDialog.confirmMessageDialog(triviaFrame, "Trivia Completed");
					triviaFrame.changePanel("statsPanel");
				}
			} else {
				MessageDialog.errorMessageDialog(triviaFrame, "Choose an option");
			}
			break;

		case "Last Stats":
			triviaFrame.setUIStats(clientSideGame.getLoggedInUser());
			triviaFrame.repaintStatsPanel(clientSideGame.getLoggedInUser().getStats().getAccuracy());
			triviaFrame.setDefaultStatsPanelButton();
			triviaFrame.changePanel("statsPanel");
			break;

		case "Home - Stats":
			triviaFrame.emptyQuestionsCardPanel();
			triviaFrame.setStatsFromScratch();
			triviaFrame.setDefaultLevelTopicSelecionPanelButton();
			triviaFrame.changePanel("levelCategorieSelectionPanel");
			triviaFrame.setDefaultLevelCategorieSelectionPanelCursorPosition();
			break;

		case "Podium":
			request = new Request();
			request.setActionCommand(command);
			connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
			request = JsonRequestConstructor.createRequestObject(connection.readUTF());
			triviaFrame.setUIPodiumUsers(request.getTopFiveUsers());
			triviaFrame.setDefaultPodiumPanelButton();
			triviaFrame.changePanel("podiumPanel");
			break;

		case "Home - Podium":
			triviaFrame.setDefaultLevelTopicSelecionPanelButton();
			triviaFrame.changePanel("levelCategorieSelectionPanel");
			triviaFrame.setDefaultLevelCategorieSelectionPanelCursorPosition();
			break;

		case "Sign Out":
			clientSideGame.setLoggedInUser(null);
			triviaFrame.setDefaultLoginPanelButton();
			triviaFrame.changePanel("loginPanel");
			triviaFrame.setDefaultLoginPanelCursorPosition();
			break;

		default:
			break;
		}
	}
}