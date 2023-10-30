package commands.souvenirCommands;

import commands.AbstractCommand;
import entity.Souvenir;
import services.SouvenirService;

import java.util.List;
import java.util.Scanner;

public class GetAllSouvenirsCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static final GetAllSouvenirsCommand getAllCustomersCommand = new GetAllSouvenirsCommand();

    private GetAllSouvenirsCommand() {
    }

    public static GetAllSouvenirsCommand getInstance() {
        return getAllCustomersCommand;
    }


    @Override
    public String getCommandName() {
        return "getAllSouvenirs";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Souvenir> souvenirs = souvenirService.getAllEntities();
        if (!souvenirs.isEmpty()) {
            souvenirs.forEach(System.out::println);
        } else {
            System.out.println("Souvenir`s list is empty");
        }
    }
}
