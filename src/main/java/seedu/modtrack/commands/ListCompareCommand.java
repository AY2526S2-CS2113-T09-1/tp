package seedu.modtrack.commands;

import seedu.modtrack.referencelist.ReferenceList;
import seedu.modtrack.module.Mod;
import seedu.modtrack.ui.Ui;
import java.util.ArrayList;

public class ListCompareCommand extends Command {

    @Override
    public void execute(ArrayList<Mod> taskList, Ui ui) {
        assert taskList != null : "taskList passed to ListCompareCommand should not be null";
        ArrayList<Mod> requiredModules = ReferenceList.getReferenceList();

        ArrayList<Mod> completed = new ArrayList<>();
        ArrayList<Mod> missing = new ArrayList<>();
        ArrayList<Mod> extraModules = new ArrayList<>();

        for (Mod reqMod : requiredModules) {
            Mod matchingTask = null;

            for (Mod task : taskList) {
                if (isMatch(reqMod,task)) {
                    boolean isNormalComplete = task.getIsComplete();
                    boolean isTransferred = task.getCompletionType().equals("TRANSFERRED");
                    boolean isExempted = task.getCompletionType().equals("EXEMPTED");
                    if (isNormalComplete || isTransferred || isExempted) {
                        matchingTask = task;
                    }
                    break;
                }
            }

            if (matchingTask!=null) {
                completed.add(matchingTask);
            } else {
                missing.add(reqMod);
            }
        }
        for (Mod task : taskList) {
            boolean foundInRef = false;
            for (Mod reqMod : requiredModules) {
                if (isMatch(reqMod, task)) {
                    foundInRef = true;
                    break;
                }
            }
            if (!foundInRef) {
                extraModules.add(task);
            }
        }

        ui.showComparedList(completed, missing,extraModules);
    }

    private boolean isMatch(Mod req, Mod task) {
        String reqName = req.getModName().trim().toLowerCase();
        String taskName = task.getModName().trim().toLowerCase();
        return reqName.contains(taskName);
    }
}
