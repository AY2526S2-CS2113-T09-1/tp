package seedu.modtrack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import seedu.modtrack.model.Command;
import seedu.modtrack.parser.InvalidCommandException;
import seedu.modtrack.model.Mod;
import seedu.modtrack.model.ReferenceList;
import seedu.modtrack.model.Storage;
import seedu.modtrack.parser.Parser;
import seedu.modtrack.ui.Ui;

public class ModTrack {

    private Ui ui;
    private ReferenceList referenceList;
    private ArrayList<Mod> taskList;
    private Parser parser;
    private Storage storage;

    public ModTrack() {
        this.ui = new Ui();
        this.referenceList = new ReferenceList();
        this.parser = new Parser();
        this.storage = new Storage();

        this.referenceList.populateReferenceList(this.referenceList.list);
        this.taskList = this.storage.load();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean isRunning = true;

        this.ui.showOpeningText();

        while (isRunning) {
            String instruction = in.nextLine();

            try {
                Command command = this.parser.parse(instruction);
                command.execute(this.taskList);

                this.storage.save(this.taskList);

                if (command.isExit()) {
                    isRunning = false;
                }
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Error saving data: " + e.getMessage());
            }
        }

        in.close();
    }

    public static void main(String[] args) {
        ModTrack modTrack = new ModTrack();
        modTrack.run();
    }
}
