package game;

import java.util.Random;

public class RandomNumberGameImpl implements RandomNumberGame {

    private static final String WIN_MSG = "You are win!";
    private static final String LOWER_NUMBER_MSG = "the number is lower than your guess! please try again.";
    private static final String HIGHER_NUMBER_MSG = "the number is higher than your guess! please try again.";
    private static final String LOSE_MSG = "You are lose!!";

    private int randomNumber = 0;
    private int maxTries = 3;


    public void start() {
        randomNumber = generateRandomNumber(4);
    }

    @Override
    public String guess(int guessNumber) {
        if (isWin(guessNumber)) return WIN_MSG;

        extracted();

        if (isLose()) return LOSE_MSG;
        else if (randomNumber < guessNumber) return LOWER_NUMBER_MSG;

        return HIGHER_NUMBER_MSG;
    }

    private void extracted() {
        maxTries--;
    }

    private boolean isLose() {
        return maxTries == 0;
    }

    private boolean isWin(int theGuess) {
        return theGuess == randomNumber;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    private Integer generateRandomNumber(int number) {
        final Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++)
            result.append(random.nextInt(10));

        return Integer.valueOf(String.valueOf(result));
    }
}
