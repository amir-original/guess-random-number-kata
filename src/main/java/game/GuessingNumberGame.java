package game;

public interface GuessingNumberGame {
    void start();

    int getRandomNumber();

    String guess(int theGuess);

}
