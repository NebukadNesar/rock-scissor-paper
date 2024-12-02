package org.game.inputhandlers;

import static org.game.GameResources.MAX_GAME_COUNT;

import java.util.Random;

import org.game.Duels;

public class RandomizedInputHandler implements InputHandler {
	private final Random random = new Random();

	@Override
	public int readNumberOfGame() {
		return random.nextInt(MAX_GAME_COUNT) + 1;
	}

	@Override
	public Duels readDuelOfRound() {
		return Duels.values()[random.nextInt(org.game.Duels.values().length)];
	}
}
