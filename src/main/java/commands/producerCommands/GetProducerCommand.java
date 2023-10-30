package commands.producerCommands;

import commands.AbstractCommand;
import services.ProducerService;

import java.util.Scanner;

public class GetProducerCommand extends AbstractCommand {

    private static ProducerService producerService = ProducerService.getInstance();
    private static GetProducerCommand getCustomerCommand = new GetProducerCommand();

    private GetProducerCommand() {
    }

    public static GetProducerCommand getInstance() {
        return getCustomerCommand;
    }

    @Override
    public String getCommandName() {
        return "getProducer";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Producer id to find");
        System.out.println(producerService.get(scanner.nextLine()));
    }
}
