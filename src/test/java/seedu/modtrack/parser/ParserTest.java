package seedu.modtrack.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.modtrack.commands.AddCommand;
import seedu.modtrack.commands.Command;
import seedu.modtrack.commands.DeleteCommand;
import seedu.modtrack.commands.ExitCommand;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {
    private Parser parser;

    @BeforeEach
    public void setUp() {
        this.parser = new Parser();
    }

    @Test
    public void parse_validAddCommand_returnsAddCommand() throws InvalidCommandException {
        String input = "add n/CS2113 y/Year 2 s/Sem 1";
        Command result = this.parser.parse(input);

        // Verify the type of command returned
        assertTrue(result instanceof AddCommand, "Result should be an instance of AddCommand");

        // If your AddCommand has getters, you can verify the fields here:
        // AddCommand addCmd = (AddCommand) result;
        // assertEquals("CS2113", addCmd.getModName());
    }

    @Test
    public void parse_validDeleteCommand_returnsDeleteCommand() throws InvalidCommandException {
        String input = "delete n/CS2113";
        Command result = this.parser.parse(input);

        assertTrue(result instanceof DeleteCommand);
    }

    @Test
    public void parse_exitCommand_returnsExitCommand() throws InvalidCommandException {
        // Testing both alias words
        assertTrue(this.parser.parse("exit") instanceof ExitCommand);
        assertTrue(this.parser.parse("bye") instanceof ExitCommand);
    }

    @Test
    public void parse_missingPrefix_throwsInvalidCommandException() {
        // Testing the extractValue failure logic
        String input = "add CS2113 y/2 s/1"; // Missing n/

        Exception exception = assertThrows(InvalidCommandException.class, () -> {
            this.parser.parse(input);
        });

        assertTrue(exception.getMessage().contains("Missing field: n/"));
    }

    @Test
    public void parse_invalidYearFormat_throwsInvalidCommandException() {
        String input = "add n/CS2113 y/SecondYear s/Sem 1"; // "SecondYear" is not parseable as int

        assertThrows(InvalidCommandException.class, () -> {
            this.parser.parse(input);
        });
    }

    @Test
    public void parse_emptyInput_throwsInvalidCommandException() {
        assertThrows(InvalidCommandException.class, () -> this.parser.parse("   "));
    }

    @Test
    public void parse_unknownCommand_throwsInvalidCommandException() {
        assertThrows(InvalidCommandException.class, () -> this.parser.parse("update n/CS2113"));
    }
}
