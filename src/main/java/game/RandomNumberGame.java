package game;

public interface RandomNumberGame {
    void start();

    int getRandomNumber();

    String guess(int theGuess);

}
