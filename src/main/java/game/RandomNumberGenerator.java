package game;

import java.util.Random;

public class RandomNumberGenerator implements RandomNumberGeneratorApi{

    private int randomNumberSize = 1;

    public RandomNumberGenerator(int randomNumberSize) {
        this.randomNumberSize = randomNumberSize;
    }

    public RandomNumberGenerator() {
    }

    public Integer generateRandomNumber() {
        final Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < randomNumberSize; i++)
            result.append(random.nextInt(10));

        return Integer.valueOf(result.toString());
    }
}
