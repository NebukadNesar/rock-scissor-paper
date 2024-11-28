~~~
       ___           __     __  ____    _                    __  ___                  
      / _ \___  ____/ /__  / / / __/___(_)__ ___ ___  ____  / / / _ \___ ____  ___ ____
     / , _/ _ \/ __/  '_/ / / _\ \/ __/ (_-<(_-</ _ \/ __/ / / / ___/ _ `/ _ \/ -_) __/
    /_/|_|\___/\__/_/\_\ / / /___/\__/_/___/___/\___/_/   / / /_/   \_,_/ .__/\__/_/  
                                /_/                              /_/           /_/            

Rock Scissor Paper Game 
~~~

# Documentation

### Constant

The following constants are used within the Game Engine:

- **MIN_GAME_COUNT**: `1` - The minimum number of games that can be played.
- **MAX_GAME_COUNT**: `10` - The maximum number of games that can be played.
- **NO_WINNER**: `"No Winner"` - Indicates that there was no winner in a round.
- **YOU**: `"You"` - Represents the human player in the game.
- **COMPUTER**: `"Computer"` - Represents the computer player in the game.

### Game Logic

Game is consist of total 3 component GameEngine, Player, InputHandler

### GameEngine

```java
public class GameEngine {
}
```

GameEngine is responsible for evaluating the game logic based on the inputs of Players (Computer player and Human
Player)

Engine will ask users to provide the number of game they want to play, (In reality to human player) and then start the
game loop

- First it will ask Human Player to select his/her duel and then computer select its duels
- GameEngine will then evaluate the both players selected Duels.
- GameEngine will declare the current Round`s winner, as well as its stores each rounds results untill the game ends
- After rounds finished, GameEngine will then evaluate and declare the overall Game winner.
- If Human player has more rounds win then it will be declared as 'You'
- If Computer player has more rounds win then it will be declared as 'Computer'
- If both players have the same rounds win then it will be declared as 'No Winner'

### Player

```java
public class Player {
}
```

Player is responsible for tracking the rounds, whenever the rounds if turned to player, then player
should select his/her/its duel.

Player has two concrete implementations:

- HumanPlayer
- ComputerPlayer

### InputHandler

```java
public class InputHandler {
}
```

InputHandler is responsible for acquiring the players input from different sources.
InputHandler has one concrete implementation

- GameConsoleInputHandler (read inputs from console)

### Testability

All game components can be tested individually, with closely couple components every method of component
can be tested.

- GameEngine can be tested without any input handler.
- Players can be tested without any input handlers.
- Input handler can be tested standalone.

### Compile & Run Configurations
- Java version : 23
- Build Tool: Gradle
- Test dependency: org.junit:junit-bom:5.10.0
- Game does not have any utility or any 3rd party package or library dependency to run.


- Project can be imported into IntelliJ or another IDE
- Build jar file will be located under the <project-directory>/build/libs/.. folder
- Build jar file can be run as follows:  <location-to-java-bin>/java -jar RockScissorPaperGame-1.0.jar














