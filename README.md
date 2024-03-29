**BlackJack GUI Game**
![image](https://github.com/HIS-MOHAMMED/BlackJackGameGUI/assets/138883671/efbe1f5b-ea8c-44d1-bac6-393945f06d9b)
Welcome to Blackjack GUI Game, a Java Swing-based implementation of the classic casino card game Blackjack.

### Overview
This project is a simple implementation of Blackjack with a graphical user interface (GUI) built using Java Swing. It allows players to play Blackjack against a computer-controlled dealer. The game features standard Blackjack rules and basic player interaction options.
### Rules of the Game:
- The game is played with a standard deck of 52 cards.
- Players start with two cards and can choose to hit (draw another card) or stand (end their turn).
- Card values: Number cards are valued at their number, face cards (Jack, Queen, King) are valued at 10, and Aces are valued at either 1 or 11 depending on the situation.
- Blackjack occurs when a player or dealer gets a hand value of 21 with just two cards.
- The dealer draws cards until their hand value reaches 17 or higher.
- If neither player nor dealer busts or gets Blackjack, the one with the highest score wins the round.
- If the deck runs out of cards, it gets shuffled, and the game continues.

### Classes:
1. **Player Class**: Manages player-specific actions like hitting or standing.
2. **Dealer Class**: Handles dealer-specific operations, such as drawing cards according to predefined rules.
3. **Person Class**: Acts as the parent class for Dealer and Player, providing common functionalities like managing cards and printing hands.
4. **Card Class**: Represents a single card, including its rank and suit.
   - *Rank Enum*: Holds card ranks along with their numerical values.
   - *Suit Enum*: Holds card suits.
5. **Deck Class**: Manages a collection of cards and performs deck operations like shuffling.
6. **Hand Class**: Represents the cards held by a player or dealer and calculates their total value.
7. **Game Class**: Handles game logic, starting new rounds, and keeping track of scores.
8. **Main Class**: Entry point to start the game.


................................................................................................................
Special Thanks for Guideness : https://kevinsguides.com/guides/code/java/javaprojs/gui-blackjack#finishing-touches
