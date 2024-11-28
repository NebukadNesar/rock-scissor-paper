package org.game;

import static org.game.GameLogger.printNewLine;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.game.inputhandlers.GameConsoleInputHandler;
import org.game.inputhandlers.InputHandler;
import org.game.players.ComputerPlayer;
import org.game.players.HumanPlayer;
import org.game.players.Player;

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
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		InputHandler gameConsoleInputHandler = new GameConsoleInputHandler(inputReader);
		Player computer = new ComputerPlayer();
		Player human = new HumanPlayer(gameConsoleInputHandler);
		GameEngine engine = new GameEngine(human, computer);
		engine.playGame();
	}

}
