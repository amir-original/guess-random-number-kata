package game;

public class GuessingNumberGameImpl implements GuessingNumberGame {



    private int MAX_TRIES = 3;

    private int randomNumber;
    private final RandomNumberGeneratorApi randomNumberGenerator;

    public GuessingNumberGameImpl(RandomNumberGeneratorApi randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void start() {
        randomNumber = randomNumberGenerator.generateRandomNumber();
    }

    @Override
    public String guess(int guessedNumbers) {
        if (isWin(guessedNumbers)) return GuessingNumberMessages.WIN;
        decrementMaxTries();

        if (isLose()) return GuessingNumberMessages.LOSE;
        else if (isGuessHigherThanRandomNumber(guessedNumbers)) return GuessingNumberMessages.LOWER_NUMBER;

        return GuessingNumberMessages.HIGHER_NUMBER;
    }

    private boolean isGuessHigherThanRandomNumber(int guessNumber) {
        return randomNumber < guessNumber;
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
