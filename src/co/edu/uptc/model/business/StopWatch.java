package co.edu.uptc.model.business;

/**
 * 
 * StopWatch class
 * 
 * @author Daniel Torres
 */

public class StopWatch {

	/**
	 * Nanoseconds per second constant
	 */

	private final long nanoSecondsPerSecond = 1000000000;

	/**
	 * Stopwatch start time
	 */

	private long stopWatchStartTime;

	/**
	 * Stopwatch stop time
	 */

	private long stopWatchStopTime;

	/**
	 * Stopwatch running
	 */

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