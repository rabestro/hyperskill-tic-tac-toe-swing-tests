package tictactoe;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class Easy implements Runnable {
    private static final Logger log = Logger.getLogger(Easy.class.getName());

    private final Board board;
    private final Consumer<Cell> moveReceiver;

    Easy(Board board, Consumer<Cell> moveReceiver) {
        this.board = board;
        this.moveReceiver = moveReceiver;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            moveReceiver.accept(board.getRandomFreeCell());
        } catch (InterruptedException e) {
            log.warning(e::getMessage);
        }
    }
}
