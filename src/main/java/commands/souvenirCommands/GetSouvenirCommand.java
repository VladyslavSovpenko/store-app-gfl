package commands.souvenirCommands;

import commands.AbstractCommand;
import services.SouvenirService;

import java.util.Scanner;

public class GetSouvenirCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static GetSouvenirCommand getSouvenirCommand = new GetSouvenirCommand();

    private GetSouvenirCommand() {
    }

    public static GetSouvenirCommand getInstance() {
        return getSouvenirCommand;
    }

    @Override
    public String getCommandName() {
        return "getSouvenir";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Souvenir id to find");
        System.out.println(souvenirService.get(scanner.nextLine()));
    }
}
