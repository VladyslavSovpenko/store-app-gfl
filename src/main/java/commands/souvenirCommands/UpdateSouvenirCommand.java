package commands.souvenirCommands;

import commands.AbstractCommand;
import entity.Producer;
import entity.Souvenir;
import services.ProducerService;
import services.SouvenirService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UpdateSouvenirCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static ProducerService producerService = ProducerService.getInstance();
    private static UpdateSouvenirCommand updateSouvenirCommand = new UpdateSouvenirCommand();

    private UpdateSouvenirCommand() {
    }

    public static UpdateSouvenirCommand getInstance() {
        return updateSouvenirCommand;
    }

    @Override
    public String getCommandName() {
        return "updateSouvenir";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Souvenir`s name to find");
        String souvenirName = scanner.nextLine();

        System.out.println("Enter Souvenir`s name to update");
        String updatedName = scanner.nextLine();

        System.out.println("Enter Souvenir`s producer id to update");
        producerService.getAllEntities().forEach(System.out::println);
        String updatedProducer = scanner.nextLine();

        System.out.println("Enter Souvenir`s cost to update");
        Double souvenirCost = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter the production date to update in format dd//mm/yy Ex. 11 09 2023");

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toList();

        Souvenir souvenir = new Souvenir(updatedName, ((Producer) producerService.get(updatedProducer)),
                souvenirCost, integerList.get(0),  integerList.get(1),  integerList.get(2));
        souvenirService.update(souvenirName, souvenir);
    }
}
