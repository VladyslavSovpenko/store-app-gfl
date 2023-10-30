package commands.specialCommands;

import commands.AbstractCommand;
import entity.Souvenir;
import services.ProducerService;
import services.SouvenirService;

import java.util.List;
import java.util.Scanner;

public class DeleteProducerAndSouvenirsCommand extends AbstractCommand {

    private static ProducerService producerService = ProducerService.getInstance();
    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static DeleteProducerAndSouvenirsCommand deleteProducerAndSouvenirsCommand =
            new DeleteProducerAndSouvenirsCommand();

    private DeleteProducerAndSouvenirsCommand() {
    }

    public static DeleteProducerAndSouvenirsCommand getInstance() {
        return deleteProducerAndSouvenirsCommand;
    }

    @Override
    public String getCommandName() {
        return "deleteProducerAndSouvenirs";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Producer id to find");
        String producerID = scanner.nextLine();

        List<Souvenir> souvenirsToDelete = souvenirService.getAllEntities().stream()
                .filter(souvenir -> souvenir.getProducer().getId().equals(Integer.parseInt(producerID)))
                .toList();

        souvenirService.removeAll(souvenirsToDelete);
        producerService.delete(producerID);
    }
}
