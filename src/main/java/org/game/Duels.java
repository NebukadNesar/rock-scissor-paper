package org.game;

public enum Duels {
	Rock("rock"),
	Scissor("scissor"),
	Paper("paper");

	private final String name;

	Duels(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Duels findDuelByName(String name) {
		for (Duels duel : values()) {
			if (duel.getName().equals(name)) {
				return duel;
			}
		}
		return null;
	}
}
