package game.exceptions;

public class NoStartGameException extends RuntimeException {

    public NoStartGameException() {
        super("You must be start game before guess!!");
    }
}
