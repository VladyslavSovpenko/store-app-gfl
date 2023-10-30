package commands.souvenirCommands;

import commands.AbstractCommand;
import entity.Producer;
import entity.Souvenir;
import services.ProducerService;
import services.SouvenirService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CreateSouvenirCommand extends AbstractCommand {

    private static CreateSouvenirCommand createSouvenirCommand = new CreateSouvenirCommand();
    private static ProducerService producerService = ProducerService.getInstance();
    private static SouvenirService souvenirService = SouvenirService.getInstance();

    private CreateSouvenirCommand() {
    }

    public static CreateSouvenirCommand getInstance() {
        return createSouvenirCommand;
    }

    @Override
    public String getCommandName() {
        return "createSouvenir";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Producer> producers = producerService.getAllEntities();
        if (producers.isEmpty()) {
            System.out.println("Please create Producers");
        } else {
            System.out.println("Enter Souvenir name");
            String name = scanner.nextLine();
            System.out.println("Enter Souvenir producer`s id");
            producers.forEach(System.out::println);
            String producerId = scanner.nextLine();
            System.out.println("Enter Souvenir`s cost");
            Double souvenirCost = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter the production date to update in format dd//mm/yy Ex. 11 09 2023");

            List<Integer> integerList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .toList();

            souvenirService.post(new Souvenir(name, ((Producer) producerService.get(producerId)),
                    souvenirCost, integerList.get(0), integerList.get(1), integerList.get(2)));
        }
    }

}
