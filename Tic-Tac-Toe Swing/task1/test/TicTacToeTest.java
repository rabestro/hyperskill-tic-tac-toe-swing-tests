import org.assertj.swing.fixture.JButtonFixture;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.stage.SwingTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.swing.SwingComponent;
import tictactoe.TicTacToe;

import java.util.Map;

import static org.hyperskill.hstest.testcase.CheckResult.correct;

public class TicTacToeTest extends SwingTest {
    public TicTacToeTest() {
        super(new TicTacToe());
    }

    @SwingComponent
    private JButtonFixture buttonA1;
    @SwingComponent
    private JButtonFixture buttonA2;
    @SwingComponent
    private JButtonFixture buttonA3;
    @SwingComponent
    private JButtonFixture buttonB1;
    @SwingComponent
    private JButtonFixture buttonB2;
    @SwingComponent
    private JButtonFixture buttonB3;
    @SwingComponent
    private JButtonFixture buttonC1;
    @SwingComponent
    private JButtonFixture buttonC2;
    @SwingComponent
    private JButtonFixture buttonC3;

    @DynamicTest
    CheckResult test1() {
        final var board = Map.of(
                "A1", buttonA1, "A2", buttonA2, "A3", buttonA3,
                "B1", buttonB1, "B2", buttonB2, "B3", buttonB3,
                "C1", buttonC1, "C2", buttonC2, "C3", buttonC3);

        board.entrySet().stream().forEach(entry -> {
            requireVisible(entry.getValue());
        });

        return correct();
    }
}