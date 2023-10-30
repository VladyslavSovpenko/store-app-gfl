package commands.specialCommands;

import commands.AbstractCommand;
import entity.Souvenir;
import services.SouvenirService;

import java.util.Scanner;

//Вивести ?нформац?ю про виробник?в заданого сувен?ру, виробленого у заданому року.
public class GetProducerByYearCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static GetProducerByYearCommand getAllInformationCommand =
            new GetProducerByYearCommand();

    private GetProducerByYearCommand() {
    }

    public static GetProducerByYearCommand getInstance() {
        return getAllInformationCommand;
    }

    @Override
    public String getCommandName() {
        return "getProducerByYear";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter year");
        Integer year = Integer.parseInt(scanner.nextLine());

        souvenirService.getAllEntities().stream()
                .filter(souvenir -> souvenir.getCreationDate().getYear() == year)
                .map(Souvenir::getProducer)
                .distinct()
                .forEach(producer ->
                        System.out.println("Producer: " + producer.getName())
                );
    }
}
