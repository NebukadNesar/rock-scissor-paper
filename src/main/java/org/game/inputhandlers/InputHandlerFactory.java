package org.game.inputhandlers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputHandlerFactory {

	public static InputHandler createInteractiveInputHandler() {
		return new InterActiveInputHandler(new BufferedReader(new InputStreamReader(System.in)));
	}

	public static InputHandler createRandomizedInputHandler() {
		return new RandomizedInputHandler();
	}
}
