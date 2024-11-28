package org.game;

public class GameResources {
    //intentionally limited number games
    public static final int MIN_GAME_COUNT = 1;
    public static final int MAX_GAME_COUNT = 10;
    public static final String PLAYER1 = "Player1";
    public static final String PLAYER2 = "Player2";
    public static final String NO_WINNER = "No winner";
    public static final String GAME_BANNER = """
               ___           __     __  ____    _                    __  ___                  \s
              / _ \\___  ____/ /__  / / / __/___(_)__ ___ ___  ____  / / / _ \\___ ____  ___ ____
             / , _/ _ \\/ __/  '_/ / / _\\ \\/ __/ (_-<(_-</ _ \\/ __/ / / / ___/ _ `/ _ \\/ -_) __/
            /_/|_|\\___/\\__/_/\\_\\ / / /___/\\__/_/___/___/\\___/_/   / / /_/   \\_,_/ .__/\\__/_/  \s
                                /_/                              /_/           /_/            \s
            """;
    public static final String GAME_RULES = """
            Rock-Scissors-Paper is a game for two players. Each player simultaneously opens his/her hand to display a symbol:
                • Fist equals rock
                • Open hand equals paper
                • Showing the index and middle finger equals scissors.
            The winner is determined by the following schema:
                • Paper beats (wraps) rock
                • Rock beats (blunts) scissors
                • Scissors beats (cuts) paper
            1- Choose the number of game you want to play
            2- Choose your move Rock, Scissor or Paper
            3- Who ever wins more rounds wins the game
            """;
}
