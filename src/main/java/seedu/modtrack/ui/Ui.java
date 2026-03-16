package seedu.modtrack.ui;

public class Ui {

    public void showOpeningText() {
        String openingText = " Hello! I'm [ModTrack]\n"
                + " What can I do for you?\n"
                + " Ready to go Graduate? Nah wgt ord loh :D"
                + " Type a module code and I will record it for you!";
        System.out.println(openingText);
    }

    public void showClosingText() {
        String closingText = " Bye. Hope to see you again soon!";
        System.out.println(closingText);
    }

    public void showEmptyDescriptionError(String command) {
        System.out.println(" " + command + " Number cannot be empty, ensure a Module code is written after '" + command
                + "'. Thankssssss!");
    }

    public void showInvalidCommandError() {
        System.out.println(
                "Invalid command. Please input the instruction again begining with 'bye'.");
    }

    public void showInvalidNumberError() {
        System.out.println("Module does not exist. Choose another number.");
    }
}
