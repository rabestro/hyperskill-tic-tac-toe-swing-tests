import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.exception.outcomes.WrongAnswer;
import org.hyperskill.hstest.stage.SwingTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.swing.SwingComponent;
import tictactoe.TicTacToe;

import javax.swing.JButton;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;
import static org.hyperskill.hstest.testcase.CheckResult.correct;

public class TicTacToeTest extends SwingTest {
    private static final String EMPTY_CELL = " ";
    private static final String MARK_X = "X";
    private static final String MARK_O = "O";

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
    @SwingComponent
    private JButtonFixture buttonReset;
    @SwingComponent
    private JLabelFixture labelStatus;

    private Stream<JButtonFixture> cells() {
        return Stream.of(
                buttonA3, buttonB3, buttonC3,
                buttonA2, buttonB2, buttonC2,
                buttonA1, buttonB1, buttonC1
        );
    }

    private final List<JButton> buttons = new ArrayList<>();

    @DynamicTest(feedback = "Cells should be visible")
    CheckResult test1() {
        cells().forEach(this::requireVisible);
        cells().map(JButtonFixture::target).forEach(buttons::add);
        return correct();
    }

    @DynamicTest(feedback = "Cells should be enabled")
    CheckResult test2() {
        cells().forEach(this::requireEnabled);
        return correct();
    }

    @DynamicTest(feedback = "All cells should be empty before the game")
    CheckResult test3() {
        cells().forEach(cell -> cell.requireText(EMPTY_CELL));
        return correct();
    }

    private int[] cols;
    private int[] rows;

    @DynamicTest(feedback = "The board should have exactly three rows and columns")
    CheckResult test4() {
        cols = buttons.stream().mapToInt(JButton::getX).distinct().sorted().toArray();
        rows = buttons.stream().mapToInt(JButton::getY).distinct().sorted().toArray();

        assertEquals(3, cols.length,
                "The board should have only 3 columns. "
                        + "The coordinates for columns are {0}, "
                        + "the buttons have {1} different coordinates for columns",
                Arrays.toString(cols), cols.length);

        assertEquals(3, rows.length,
                "The board should have only 3 rows. "
                        + "The coordinates for rows are {0}, "
                        + "The buttons have {0} different coordinates for rows",
                Arrays.toString(rows), rows.length);

        return correct();
    }

    private static final String[] ROW_NAME = new String[]{"top", "middle", "bottom"};
    private static final String[] COL_NAME = new String[]{"left", "middle", "right"};

    @DynamicTest(feedback = "The buttons are incorrectly placed on the board")
    CheckResult test5() {
        range(0, 9).forEach(index -> {

            assertEquals(rows[index / 3], buttons.get(index).getY(),
                    "The button {0} should be located on the {1} row",
                    buttons.get(index).getText(), ROW_NAME[index / 3]);

            assertEquals(cols[index % 3], buttons.get(index).getX(),
                    "The button {0} should be located on the {1} column",
                    buttons.get(index).getText(), COL_NAME[index % 3]);
        });

        return correct();
    }

    @DynamicTest(feedback = "An JLabel with name 'LabelStatus' should be added as status bar")
    CheckResult test6() {
        labelStatus.requireVisible();
        return correct();
    }

    @DynamicTest(feedback = "The status bar should contains text 'The game is not started' before the game")
    CheckResult test7() {
        labelStatus.requireText("The game is not started");
        return correct();
    }

    @DynamicTest(feedback = "An JButton with name 'ButtonReset' should be added and enabled")
    CheckResult test8() {
        buttonReset.requireEnabled();
        return correct();
    }

    @DynamicTest(feedback = "The Game")
    CheckResult test10() {
        buttonA1.click();
        buttonA1.requireText(MARK_X);
        buttonA3.click();
        buttonA3.requireText(MARK_O);
        return correct();
    }

    private static void assertEquals(
            final Object expected,
            final Object actual,
            final String error,
            final Object... args) {

        if (!expected.equals(actual)) {
            final var feedback = MessageFormat.format(error, args);
            throw new WrongAnswer(feedback);
        }
    }
}