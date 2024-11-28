package org.game;

/**
 * Class just prints the message into console, imitating a logger, simple and short
 */
public class GameLogger {
	/**
	 * print on the new line
	 */
	public static void printNewLine(String message) {
		System.out.println(message);
	}

	/**
	 * print on the same line, used for entering input lines
	 */

	public static void printSameLine(String message) {
		System.out.print(message);
	}
}
