package commands.souvenirCommands;

import commands.AbstractCommand;
import entity.Producer;
import entity.Souvenir;
import services.SouvenirService;

import java.util.List;
import java.util.Scanner;

public class RemoveSouvenirCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static RemoveSouvenirCommand removeSouvenirCommand = new RemoveSouvenirCommand();

    private RemoveSouvenirCommand() {
    }

    public static RemoveSouvenirCommand getInstance() {
        return removeSouvenirCommand;
    }

    @Override
    public String getCommandName() {
        return "removeSouvenir";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Souvenir> allSouvenirs = souvenirService.getAllEntities();
        if (!allSouvenirs.isEmpty()) {
            allSouvenirs.forEach(System.out::println);
            System.out.println("Enter Souvenir id to remove");
            String customerName = scanner.nextLine();
            souvenirService.delete(customerName);
        } else {
            System.out.println("Souvenirs list is empty");
        }
    }
}
