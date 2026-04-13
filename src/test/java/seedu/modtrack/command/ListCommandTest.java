package seedu.modtrack.command;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import seedu.modtrack.commands.ListCommand;
import seedu.modtrack.module.Mod;
import seedu.modtrack.ui.Ui;

class ListCommandTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Ui ui;

    // This runs before EVERY test - sets up the "bucket" automatically
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(this.outContent));
        this.ui = new Ui();
    }

    // This runs after EVERY test - puts the console back to normal
    @AfterEach
    void tearDown() {
        System.setOut(this.originalOut);
    }

    @Test
    void execute_singleModule_printsFullFormattedOutput() {
        // 1. Setup
        ArrayList<Mod> modInterests = new ArrayList<>();
        // Assuming constructor: Mod(name, year, sem, credits)
        modInterests.add(new Mod("CS1010", 1, 1, 4));

        ListCommand command = new ListCommand();

        // 2. Act
        command.execute(modInterests, this.ui);

        // 3. Assert - We get the output and normalize line endings
        String output = this.outContent.toString().replace("\r\n", "\n").trim();

        // Check for the Header
        assertTrue(output.contains("===== Your Tracked Modules ====="), "Header missing!");

        // Check for exact formatting of the fields
        assertTrue(output.contains("Name: CS1010"), "Module name formatted incorrectly");
        assertTrue(output.contains("Year: YEAR1"), "Year formatting incorrect");
        assertTrue(output.contains("Semester: SEM1"), "Semester formatting incorrect");
        assertTrue(output.contains("Modular Credits: 4"), "Credits missing or wrong");
        assertTrue(output.contains("Status: Incomplete"), "Default status should be Incomplete");
    }

    @Test
    void execute_emptyList_printsCleanMessage() {
        ListCommand command = new ListCommand();
        command.execute(new ArrayList<>(), this.ui);

        String output = this.outContent.toString().trim();

        // Using assertEquals is more robust than assertTrue(contains) for short messages
        String expected = "===== Your Tracked Modules =====" + System.lineSeparator()
                        + "Total Modular Credits: 4" + System.lineSeparator()
                        + "Total Remaining Modular Credits: 156" + System.lineSeparator() + "No modules tracked yet.";
        assertEquals(expected.trim(), output);
    }

    @Test
    void execute_multipleModules_printsAllInOrder() {
        ArrayList<Mod> modInterests = new ArrayList<>();
        modInterests.add(new Mod("CS1010", 1, 1, 4));
        modInterests.add(new Mod("MA1511", 1, 1, 2));

        ListCommand command = new ListCommand();
        command.execute(modInterests, this.ui);

        String output = this.outContent.toString();

        // Check that BOTH names appear in the output
        assertTrue(output.contains("CS1010"));
        assertTrue(output.contains("MA1511"));
    }

    @Test
    void execute_completedModule_showsCorrectStatus() {
        ArrayList<Mod> modInterests = new ArrayList<>();
        Mod completedMod = new Mod("CS1010", 1, 1, 4);
        completedMod.setToDone(); // Assuming this method exists
        modInterests.add(completedMod);

        new ListCommand().execute(modInterests, this.ui);

        String output = this.outContent.toString();
        assertTrue(output.contains("Status: Complete"), "Should show 'Complete' for finished modules");
    }

}
