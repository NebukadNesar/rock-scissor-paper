package org.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDuels {

	/**
	 * With this test a newly added Duel or removed Duel can be detected. As well as
	 * expected duels IDs can be verified.
	 */
	@Test
	public void test_DuelsFindById() {
		int[] randomDuelsIds = { 1, 2, 1, 1, 1, 1, 1 };
		boolean[] expectedOutComeOfResult = { true, true, true, true, true, true, true };

		int testInputCount = randomDuelsIds.length;
		boolean[] actualOutComeOfResult = new boolean[testInputCount];

		for (int i = 0; i < testInputCount; i++) {
			Duels randomlySelectedDuel = Duels.values()[randomDuelsIds[i]];
			actualOutComeOfResult[i] = randomlySelectedDuel != null;
		}

		Assertions.assertArrayEquals(expectedOutComeOfResult, actualOutComeOfResult,
				"Actual outcome and expected outcome does not match of Duels selection by id");
	}

	/**
	 * Validates Duels internal method findDuelByName method correctly working or not
	 */
	@Test
	public void test_DuelsFindByName() {
		String[] randomDuelsIds = { "Rock", "Scissor", "P a p e r", "Paper", "-1", null, "" };
		boolean[] expectedOutComeOfResult = { true, true, false, true, false, false, false };

		int testInputCount = randomDuelsIds.length;
		boolean[] actualOutComeOfResult = new boolean[testInputCount];

		for (int i = 0; i < testInputCount; i++) {
			String randomlySelectedDuelName = randomDuelsIds[i];
			randomlySelectedDuelName = randomlySelectedDuelName == null ? "" : randomlySelectedDuelName.toLowerCase().trim();
			Duels randomlySelectedDuel = Duels.findDuelByName(randomlySelectedDuelName);
			actualOutComeOfResult[i] = randomlySelectedDuel != null;
		}

		Assertions.assertArrayEquals(expectedOutComeOfResult, actualOutComeOfResult,
				"Actual outcome and expected outcome does not match of Duels selection by name");
	}
}
