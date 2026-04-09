package seedu.modtrack;

import org.junit.jupiter.api.Test;

import seedu.modtrack.model.AddCommand;
import seedu.modtrack.model.Command;
import seedu.modtrack.model.ExitCommand;
import seedu.modtrack.model.MarkCommand;
import seedu.modtrack.model.SetProgressCommand;
import seedu.modtrack.parser.InvalidCommandException;
import seedu.modtrack.parser.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {

    private final Parser parser = new Parser();

    @Test
    public void parse_addCommand_success() throws InvalidCommandException {
        Command command = parser.parse("add n/CS2113 y/YEAR2 s/SEM1");
        assertInstanceOf(AddCommand.class, command);
    }

    @Test
    public void parse_markCommand_success() throws InvalidCommandException {
        Command command = parser.parse("mark n/CS2113");
        assertInstanceOf(MarkCommand.class, command);
    }

    @Test
    public void parse_progressCommand_success() throws InvalidCommandException {
        Command command = parser.parse("progress n/CS2113 p/80");
        assertInstanceOf(SetProgressCommand.class, command);
    }

    @Test
    public void parse_exitCommand_success() throws InvalidCommandException {
        Command command = parser.parse("exit");
        assertInstanceOf(ExitCommand.class, command);
    }

    @Test
    public void parse_byeCommand_success() throws InvalidCommandException {
        Command command = parser.parse("bye");
        assertInstanceOf(ExitCommand.class, command);
    }

    @Test
    public void parse_emptyInput_throwsException() {
        InvalidCommandException exception = assertThrows(
                InvalidCommandException.class,
                () -> parser.parse("   ")
        );
        assertEquals("Input cannot be empty.", exception.getMessage());
    }

    @Test
    public void parse_invalidCommand_throwsException() {
        InvalidCommandException exception = assertThrows(
                InvalidCommandException.class,
                () -> parser.parse("hello")
        );
        assertEquals("Invalid command.", exception.getMessage());
    }

    @Test
    public void parse_addMissingName_throwsException() {
        InvalidCommandException exception = assertThrows(
                InvalidCommandException.class,
                () -> parser.parse("add y/YEAR2 s/SEM1")
        );
        assertEquals("Missing field: n/", exception.getMessage());
    }

    @Test
    public void parse_progressOutOfRange_throwsException() {
        InvalidCommandException exception = assertThrows(
                InvalidCommandException.class,
                () -> parser.parse("progress n/CS2113 p/101")
        );
        assertEquals("Progress must be between 0 and 100.", exception.getMessage());
    }

    @Test
    public void parse_progressNonInteger_throwsException() {
        InvalidCommandException exception = assertThrows(
                InvalidCommandException.class,
                () -> parser.parse("progress n/CS2113 p/eighty")
        );
        assertEquals("Progress must be an integer from 0 to 100.", exception.getMessage());
    }

    @Test
    public void parse_showGradReq_success() throws InvalidCommandException {
        Command command = parser.parse("show grad req");
        assertEquals("ShowGradReqCommand", command.getClass().getSimpleName());
    }
}