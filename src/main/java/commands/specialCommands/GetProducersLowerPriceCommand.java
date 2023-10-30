package commands.specialCommands;

import commands.AbstractCommand;
import services.SouvenirService;

import java.util.Scanner;

//Вивести ?нформац?ю про виробник?в, чиї ц?ни на сувен?ри менше заданої
public class GetProducersLowerPriceCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static GetProducersLowerPriceCommand getProducersLowerPriceCommand = new GetProducersLowerPriceCommand();

    private GetProducersLowerPriceCommand() {
    }

    public static GetProducersLowerPriceCommand getInstance() {
        return getProducersLowerPriceCommand;
    }

    @Override
    public String getCommandName() {
        return "getProducersWithLowerPrice";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter the price below which you want to view producers");
        Double maxPrice = Double.parseDouble(scanner.nextLine());

        souvenirService.getAllEntities()
                .stream()
                .filter(souvenir -> souvenir.getPrice().compareTo(maxPrice) < 0)
                .map(souvenir -> souvenir.getProducer().getName() + " - " + souvenir.getPrice())
                .distinct()
                .forEach(System.out::println);
    }
}
