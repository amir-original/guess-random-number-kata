import game.GuessingNumberGame;
import game.GuessingNumberGameImpl;
import game.RandomNumberGeneratorApi;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGameShould {
    private static final String WIN_MSG = "You are win!";
    private static final String LOWER_NUMBER_MSG = "the number is lower than your guess! please try again.";
    private static final String HIGHER_NUMBER_MSG = "the number is higher than your guess! please try again.";
    private static final String LOSE_MSG = "You are lose!!";

    private GuessingNumberGame game;

    @Before
    public void setUp() {
        game = new GuessingNumberGameImpl(new RandomNumberGeneratorDouble());
        game.start();
    }

    @Test
    public void when_player_start_game_generate_a_random_number() {
        assertThat(game.getRandomNumber()).isEqualTo(1234);
    }

    @Test
    public void return_win_word_when_player_guess_is_correct_in_first_times() {
        assertThat(game.guess(1234)).isEqualTo(WIN_MSG);
    }

    @Test
    public void notify_the_user_if_number_its_higher_or_lower_when_user_does_correct_guess() {
        assertThat(game.guess(1235)).isEqualTo(LOWER_NUMBER_MSG);
        assertThat(game.guess(1225)).isEqualTo(HIGHER_NUMBER_MSG);
    }

    @Test
    public void return_lose_if_the_user_not_guess_on_three_intents() {
        assertThat(game.guess(1235)).isEqualTo(LOWER_NUMBER_MSG);
        assertThat(game.guess(1225)).isEqualTo(HIGHER_NUMBER_MSG);
        assertThat(game.guess(1255)).isEqualTo(LOSE_MSG);
    }

    @Test
    public void player_is_win_in_second_move() {
        assertThat(game.guess(4565)).isEqualTo(LOWER_NUMBER_MSG);
        assertThat(game.guess(1234)).isEqualTo(WIN_MSG);
    }

    @Test
    public void player_is_win_in_third_move() {
        assertThat(game.guess(4565)).isEqualTo(LOWER_NUMBER_MSG);
        assertThat(game.guess(1012)).isEqualTo(HIGHER_NUMBER_MSG);
        assertThat(game.guess(1234)).isEqualTo(WIN_MSG);
    }

    private static class RandomNumberGeneratorDouble implements RandomNumberGeneratorApi {

        public RandomNumberGeneratorDouble() {
        }

        @Override
        public Integer generateRandomNumber() {
            return 1234;
        }
    }
}
