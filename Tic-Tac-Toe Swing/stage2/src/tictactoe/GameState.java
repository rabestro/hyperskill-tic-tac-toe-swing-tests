package tictactoe;

public enum GameState {
    NOT_STARTED("The game is not started"),
    PLAYING("The game is playing"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    IMPOSSIBLE("Impossible");

    final String message;

    GameState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
