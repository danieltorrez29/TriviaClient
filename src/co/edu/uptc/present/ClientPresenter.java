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
 * @author Daniel Torres
 * @Date 3/11/2022
 * @Description ClientPresenter Class
 */

public class ClientPresenter implements ActionListener {

	/**
	 * Attribute declaration
	 */

	private ClientSideGame clientSideGame;
	private Connection connection;
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
		case "Iniciar":
			triviaFrame.setDefaultLoginPanelButton();
			triviaFrame.changePanel("loginPanel");
			triviaFrame.setDefaultLoginPanelCursorPosition();
			break;

		case "Ingresar":
			request = new Request();
			request.setActionCommand(command);
			request.setUsername(triviaFrame.getLoginEmailUsernameFieldText());
			request.setPassword(triviaFrame.getLoginPasswordFieldText());
			connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
			request = JsonRequestConstructor.createRequestObject(connection.readUTF());
			if (request.isFlag()) {
				MessageDialog.confirmMessageDialog(triviaFrame, "Ingreso exitoso");
				clientSideGame.setLoggedInUser(request.getLoggedInUser());
				triviaFrame.emptyLoginFields();
				triviaFrame.setDefaultLevelTopicSelecionPanelButton();
				triviaFrame.changePanel("levelTopicSelectionPanel");
				triviaFrame.setDefaultLevelTopicSelectionPanelCursorPosition();
			} else {
				triviaFrame.emptyLoginFields();
				triviaFrame.setDefaultLoginPanelCursorPosition();
				MessageDialog.errorMessageDialog(triviaFrame, "Usuario o contraseña incorrectos");
			}
			break;

		case "Registrarse":
			triviaFrame.setDefaultRegisterPanelButton();
			triviaFrame.changePanel("registerPanel");
			triviaFrame.setDefaultRegisterPanelCursorPosition();
			break;

		case "Registrarse - Usuario":
			request = new Request();

			if (triviaFrame.getRegisterEmailFieldText().equals("")
					|| triviaFrame.getRegisterUsernameFieldText().equals("")) {
				triviaFrame.setDefaultRegisterPanelCursorPosition();
				registerErrorAction("Usuario inválido o existente");
			} else {
				request.setActionCommand(command);
				request.setFlag(false);
				request.setUsername(triviaFrame.getRegisterUsernameFieldText());
				connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
				request = JsonRequestConstructor.createRequestObject(connection.readUTF());
				if (request.isFlag()) {
					triviaFrame.setDefaultRegisterPanelCursorPosition();
					registerErrorAction("Usuario inválido o existente");
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
							MessageDialog.confirmMessageDialog(triviaFrame, "Usuario registrado exitosamente");
							triviaFrame.emptyRegisterFields();
							triviaFrame.changePanel("loginPanel");
							triviaFrame.setDefaultLoginPanelCursorPosition();
						} else {
							triviaFrame.setDefaultRegisterPanelCursorPosition();
							registerErrorAction("Contraseñas no coinciden o están vacías");
						}
					} else {
						triviaFrame.setDefaultRegisterPanelCursorPosition();
						registerErrorAction("Contraseñas no coinciden o están vacías");
					}
				}
			}

		case "¿Quieres ingresar?":
			triviaFrame.emptyLoginFields();
			triviaFrame.setDefaultLoginPanelButton();
			triviaFrame.changePanel("loginPanel");
			triviaFrame.setDefaultLoginPanelCursorPosition();
			break;

		case "Jugar":
			clientSideGame.startStopWatch();
			triviaFrame.setDefaultQuestionsPanelButton();
			switch (triviaFrame.getLevelSelected()) {
			case "Fácil":
				triviaFrame.setQuestionsPanels(clientSideGame.getAnyDifficulty(0)
						.searchCategorie(triviaFrame.getEasyTopicSelected()).getQuestions());
				triviaFrame.changePanel("questionsPanel");
				break;

			case "Avanzado":
				triviaFrame.setQuestionsPanels(clientSideGame.getAnyDifficulty(1)
						.searchCategorie(triviaFrame.getHardTopicSelected()).getQuestions());
				triviaFrame.changePanel("questionsPanel");
				break;

			default:
				break;
			}
			break;

		case "50/50":
			triviaFrame.hideIncorrectAnswersAction();
			break;

		case "Siguiente":
			if (triviaFrame.isAnyAnswerSelected()) {
				if (triviaFrame.getLastQuestionPanelAux() != triviaFrame.getQuestionComponetsCount()) {
					if (triviaFrame.isCorrectSelectedAnswer()) {
						triviaFrame.incrementCorrect();
						triviaFrame.incrementLastQuestionPanelAux();
						MessageDialog.confirmMessageDialog(triviaFrame, "Respuesta Correcta");
						triviaFrame.nextQuestionPanel();
					} else {
						triviaFrame.incrementIncorrect();
						triviaFrame.incrementLastQuestionPanelAux();
						MessageDialog.errorMessageDialog(triviaFrame, "Respuesta Incorrecta");
						triviaFrame.nextQuestionPanel();
					}
				} else {
					if (triviaFrame.isCorrectSelectedAnswer()) {
						clientSideGame.stopStopWatch();
						triviaFrame.incrementCorrect();
						MessageDialog.confirmMessageDialog(triviaFrame, "Respuesta Correcta");
					} else {
						clientSideGame.stopStopWatch();
						triviaFrame.incrementIncorrect();
						MessageDialog.errorMessageDialog(triviaFrame, "Respuesta Incorrecta");
					}
					switch (triviaFrame.getLevelSelected()) {
					case "Fácil":
						clientSideGame.setLoggedInUserStats(triviaFrame.getLevelSelected(),
								triviaFrame.getEasyTopicSelected(), triviaFrame.getCorrect(),
								triviaFrame.getIncorrect(),
								(triviaFrame.getCorrect() * 100) - clientSideGame.getElapsedSeconds(),
								((double) triviaFrame.getCorrect()
										/ (double) (triviaFrame.getCorrect() + triviaFrame.getIncorrect())) * 100,
								clientSideGame.getElapsedSeconds());
						break;

					case "Avanzado":
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
					request = new Request();
					request.setActionCommand(command);
					request.setLoggedInUser(clientSideGame.getLoggedInUser());
					connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
					triviaFrame.setUIStats(clientSideGame.getLoggedInUser());
					triviaFrame.repaintStatsPanel(clientSideGame.getLoggedInUser().getStats().getAccuracy());
					triviaFrame.setDefaultStatsPanelButton();
					MessageDialog.confirmMessageDialog(triviaFrame, "Trivia Finalizada");
					triviaFrame.changePanel("statsPanel");
				}
			} else {
				MessageDialog.errorMessageDialog(triviaFrame, "Eliga una respuesta");
			}
			break;

		case "Últimas Estadísticas":
			triviaFrame.setUIStats(clientSideGame.getLoggedInUser());
			triviaFrame.repaintStatsPanel(clientSideGame.getLoggedInUser().getStats().getAccuracy());
			triviaFrame.setDefaultStatsPanelButton();
			triviaFrame.changePanel("statsPanel");
			break;

		case "Inicio - Estadísticas":
			triviaFrame.emptyQuestionsCardPanel();
			triviaFrame.setStatsFromScratch();
			triviaFrame.setDefaultLevelTopicSelecionPanelButton();
			triviaFrame.changePanel("levelTopicSelectionPanel");
			triviaFrame.setDefaultLevelTopicSelectionPanelCursorPosition();
			break;

		case "Podio":
			request = new Request();
			request.setActionCommand(command);
			connection.writeUTF(JsonRequestConstructor.createJsonRequestString(request));
			request = JsonRequestConstructor.createRequestObject(connection.readUTF());
			triviaFrame.setUIPodiumUsers(request.getTopFiveUsers());
			triviaFrame.setDefaultPodiumPanelButton();
			triviaFrame.changePanel("podiumPanel");
			break;

		case "Inicio - Podio":
			triviaFrame.setDefaultLevelTopicSelecionPanelButton();
			triviaFrame.changePanel("levelTopicSelectionPanel");
			triviaFrame.setDefaultLevelTopicSelectionPanelCursorPosition();
			break;

		case "Cerrar Sesión":
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