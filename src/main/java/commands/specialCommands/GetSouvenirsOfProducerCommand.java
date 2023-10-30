package commands.specialCommands;

import commands.AbstractCommand;
import services.ProducerService;
import services.SouvenirService;

import java.util.Scanner;

//Вивести ?нформац?ю про сувен?ри заданого виробника.
public class GetSouvenirsOfProducerCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static ProducerService producerService = ProducerService.getInstance();
    private static GetSouvenirsOfProducerCommand getProducerAndSouvenirsCommand = new GetSouvenirsOfProducerCommand();

    private GetSouvenirsOfProducerCommand() {
    }

    public static GetSouvenirsOfProducerCommand getInstance() {
        return getProducerAndSouvenirsCommand;
    }

    @Override
    public String getCommandName() {
        return "getInformationOfProducer";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Producer name to find");
        producerService.getAllEntities().forEach(pr-> System.out.println(pr.getName()));

        String producer = scanner.nextLine();
        souvenirService.getAllEntities().stream()
                .filter(s -> s.getProducer().getName().equals(producer))
                .forEach(System.out::println);
    }
}
