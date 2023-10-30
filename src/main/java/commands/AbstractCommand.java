package commands;

import java.util.Scanner;

public abstract class AbstractCommand {

    public String getCommandName() {
        return "default";
    }

    public void execute(Scanner scanner) {
    }
}
