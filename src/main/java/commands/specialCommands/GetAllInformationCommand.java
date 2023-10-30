package commands.specialCommands;

import commands.AbstractCommand;
import entity.Producer;
import entity.Souvenir;
import services.SouvenirService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetAllInformationCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static GetAllInformationCommand getAllInformationCommand =
            new GetAllInformationCommand();

    private GetAllInformationCommand() {
    }

    public static GetAllInformationCommand getInstance() {
        return getAllInformationCommand;
    }

    @Override
    public String getCommandName() {
        return "getAllInformation";
    }

    @Override
    public void execute(Scanner scanner) {
        Map<Producer, List<Souvenir>> souvenirsByProducer = souvenirService.getAllEntities().stream()
                .collect(Collectors.groupingBy(Souvenir::getProducer));

        souvenirsByProducer.forEach((producer, producerSouvenirs) -> {
            System.out.println("Producer: " + producer.getName());
            producerSouvenirs.forEach(souvenir ->
                    System.out.println("  Souvenir: " + souvenir.getName() +
                            ", Price: " + souvenir.getPrice() +
                            ", Creation Date: " + souvenir.getCreationDate()));
            System.out.println();
        });
    }
}
