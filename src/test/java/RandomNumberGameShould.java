import game.GuessingNumberGame;
import game.GuessingNumberGameImpl;
import game.exceptions.NoStartGameException;
import org.junit.Before;
import org.junit.Test;

import static game.GuessingNumberMessages.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RandomNumberGameShould {

    private static final int GAME_ANSWER = 1234;
    private GuessingNumberGame game;

    @Before
    public void setUp() {
        game = new GuessingNumberGameImpl(new RandomNumberGeneratorDouble());
        game.start();
    }

    @Test
    public void when_player_start_game_generate_a_random_number() {
        assertThat(game.getRandomNumber()).isEqualTo(GAME_ANSWER);
    }

    @Test
    public void player_win_in_first_move() {
        assertThat(game.guess(GAME_ANSWER)).isEqualTo(WIN);
    }

    @Test
    public void notify_the_user_if_number_its_higher_or_lower_when_user_does_not_correct_guess() {
        assertThat(game.guess(1235)).isEqualTo(RAND_IS_LOWER_THAN_GUESSED);
        assertThat(game.guess(1212)).isEqualTo(RAND_IS_HIGHER_THAN_GUESSED);
    }

    @Test
    public void return_lose_if_the_user_not_guess_on_three_intents() {
        assertThat(game.guess(1245)).isEqualTo(RAND_IS_LOWER_THAN_GUESSED);
        assertThat(game.guess(1225)).isEqualTo(RAND_IS_HIGHER_THAN_GUESSED);
        assertThat(game.guess(1255)).isEqualTo(LOSE);
    }

    @Test
    public void player_is_win_in_second_move() {
        assertThat(game.guess(4565)).isEqualTo(RAND_IS_LOWER_THAN_GUESSED);
        assertThat(game.guess(GAME_ANSWER)).isEqualTo(WIN);
    }

    @Test
    public void player_is_win_in_third_move() {
        assertThat(game.guess(4565)).isEqualTo(RAND_IS_LOWER_THAN_GUESSED);
        assertThat(game.guess(1012)).isEqualTo(RAND_IS_HIGHER_THAN_GUESSED);
        assertThat(game.guess(GAME_ANSWER)).isEqualTo(WIN);
    }

    @Test
    public void throw_exception_if_forget_to_call_start_method() {
        final GuessingNumberGameImpl game = new GuessingNumberGameImpl(new RandomNumberGeneratorDouble());
        assertThatExceptionOfType(NoStartGameException.class).isThrownBy(() -> game.guess(GAME_ANSWER));
    }
}
