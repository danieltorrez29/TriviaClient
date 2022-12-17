package co.edu.uptc.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * Connection class
 * 
 * @author Daniel Torres
 */

public class Connection {

	/**
	 * Client socket
	 */

	private Socket socket;

	/**
	 * Input stream
	 */

	private DataInputStream input;

	/**
	 * Output stream
	 */

	private DataOutputStream output;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param host
	 * @param port
	 */

	public Connection(String host, int port) {
		try {
			socket = new Socket(host, port);
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * writeUTF void method
	 * 
	 * @param json
	 */

	public void writeUTF(String json) {
		try {
			output.writeUTF(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * readUTF String method
	 * 
	 * @return String
	 */

	public String readUTF() {
		try {
			return input.readUTF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * close void method
	 */

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * inputStreamAvailable int method that determines channel's bytes amount
	 * available
	 * 
	 * @return int
	 */

	public int inputStreamAvailable() {
		int bytes = 0;
		try {
			bytes = input.available();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}
}