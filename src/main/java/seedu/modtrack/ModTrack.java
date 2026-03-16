package seedu.modtrack;

import java.util.Scanner;

import seedu.modtrack.ui.Ui;

public class ModTrack {

    private Ui ui;

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public ModTrack() {
        this.ui = new Ui();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        Boolean isRunning = true;

        this.ui.showOpeningText();
        while (isRunning) {
            String instruction = in.nextLine();
            if (instruction.equals("bye")) {
                isRunning = false;
                this.ui.showClosingText();
            } else {
                this.ui.showInvalidCommandError();
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        ModTrack modTrack = new ModTrack();
        modTrack.run();
    }
}
