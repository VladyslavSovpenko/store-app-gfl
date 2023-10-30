package commands.specialCommands;

import commands.AbstractCommand;
import entity.Producer;
import services.ProducerService;
import services.SouvenirService;

import java.util.Scanner;

//Вивести ?нформац?ю про сувен?ри, виготовлен? в задан?й країн?.
public class GetSouvenirsByCountryCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static ProducerService producerService = ProducerService.getInstance();
    private static GetSouvenirsByCountryCommand getSouvenirsByCountryCommand = new GetSouvenirsByCountryCommand();

    private GetSouvenirsByCountryCommand() {
    }

    public static GetSouvenirsByCountryCommand getInstance() {
        return getSouvenirsByCountryCommand;
    }

    @Override
    public String getCommandName() {
        return "getSouvenirsByCountry";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Producer name to find");
        producerService.getAllEntities()
                .stream()
                .map(Producer::getCountry)
                .distinct()
                .forEach(System.out::println);

        String country = scanner.nextLine();
        souvenirService.getAllEntities()
                .stream()
                .filter(s -> s.getProducer().getCountry().equals(country))
                .forEach(System.out::println);
    }
}
