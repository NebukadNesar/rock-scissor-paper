package org.game;

import static org.game.GameLogger.printNewLine;

import org.game.inputhandlers.InputHandlerFactory;
import org.game.players.Participant;
import org.game.players.Player;
import org.game.players.PlayerFactory;

/**
 * Rock Scissor Paper Game,
 * <p>
 * Initialize resources and starts to GameEngine.
 */
public class RockScissorPaperGame {

	public static void main(String[] args) {
		RockScissorPaperGame game = new RockScissorPaperGame();
		game.startGame();
	}

	private void startGame() {
		printNewLine(GameResources.GAME_BANNER);
		printNewLine(GameResources.GAME_RULES);
		Player humanPlayer = PlayerFactory.creatHumanPlayer();
		Player computerPlayer = PlayerFactory.creatComputerPlayer();
		GameEngine engine = new GameEngine(humanPlayer, computerPlayer);
		engine.playGame();
	}

}
