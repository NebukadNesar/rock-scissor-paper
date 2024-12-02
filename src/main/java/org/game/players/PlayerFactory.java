package org.game.players;

import org.game.inputhandlers.InputHandlerFactory;

public class PlayerFactory {

	public static Player creatHumanPlayer() {
		return new Participant(InputHandlerFactory.createInteractiveInputHandler());
	}

	public static Player creatComputerPlayer() {
		return new Participant(InputHandlerFactory.createRandomizedInputHandler());
	}
}
