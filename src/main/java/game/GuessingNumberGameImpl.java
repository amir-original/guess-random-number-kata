package game;

import game.exceptions.NoStartGameException;

import static game.GuessingNumberMessages.*;

public class GuessingNumberGameImpl implements GuessingNumberGame {

    private static final int NO_START = -1;

    private int MAX_TRIES = NO_START;
    private int randomNumber;
    private final RandomNumberGeneratorApi randomNumberGenerator;

    public GuessingNumberGameImpl(RandomNumberGeneratorApi randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        randomNumber = randomNumberGenerator.generateRandomNumber();
        MAX_TRIES = 3;
    }

    @Override
    public String guess(int guessedNumber) {
        if (MAX_TRIES == NO_START) throw new NoStartGameException();
        return isWin(guessedNumber) ? WIN : processOtherConditions(guessedNumber);

    }


    private String processOtherConditions(int guessedNumber) {
        decrementMaxTries();
        if (isLose()) {
            return LOSE;
        } else if (isGuessedNumHigherThanRandomNumber(guessedNumber)) {
            return RAND_IS_LOWER_THAN_GUESSED;
        }else {
            return RAND_IS_HIGHER_THAN_GUESSED;
        }
    }

    private boolean isGuessedNumHigherThanRandomNumber(int guessedNumber) {
        return randomNumber < guessedNumber;
    }

    private void decrementMaxTries() {
        MAX_TRIES--;
    }

    private boolean isLose() {
        return MAX_TRIES == 0;
    }

    private boolean isWin(int theGuess) {
        return theGuess == randomNumber;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

}
