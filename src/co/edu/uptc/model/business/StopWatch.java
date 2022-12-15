package co.edu.uptc.model.business;

/**
 * @author Daniel Torres
 * @Date 23/11/2022
 * @Description StopWatch Class
 */

public class StopWatch {

	/**
	 * Constants
	 */

	private final long nanoSecondsPerSecond = 1000000000;

	/**
	 * Attribute declaration
	 */

	private long stopWatchStartTime, stopWatchStopTime;
	private boolean stopWatchRunning;

	/**
	 * 
	 * Constructor method
	 */

	public StopWatch() {
		stopWatchStartTime = 0;
		stopWatchStopTime = 0;
		stopWatchRunning = false;
	}

	/**
	 * 
	 * start void method
	 */

	public void start() {
		this.stopWatchStartTime = System.nanoTime();
		this.stopWatchRunning = true;
	}

	/**
	 * 
	 * stop void method
	 */

	public void stop() {
		this.stopWatchStopTime = System.nanoTime();
		this.stopWatchRunning = false;
	}

	/**
	 * 
	 * getElapsedSeconds long method
	 * 
	 * @return seconds elapsed time
	 */

	public long getElapsedSeconds() {
		long elapsedTime;

		if (stopWatchRunning)
			elapsedTime = (System.nanoTime() - stopWatchStartTime);
		else
			elapsedTime = (stopWatchStopTime - stopWatchStartTime);

		return elapsedTime / nanoSecondsPerSecond;
	}
}