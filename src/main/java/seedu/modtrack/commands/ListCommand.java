package seedu.modtrack.commands;

import java.util.ArrayList;

import seedu.modtrack.module.Mod;
import seedu.modtrack.ui.Ui;

public class ListCommand extends Command {

    @Override
    public void execute(ArrayList<Mod> list, Ui ui) {
        int totalModuleCredits = list.stream().mapToInt(Mod::getModCredits).sum();
        ui.showList(list, totalModuleCredits);
    }
}
