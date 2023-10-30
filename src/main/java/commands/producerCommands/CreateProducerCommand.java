package commands.producerCommands;

import commands.AbstractCommand;
import entity.Producer;
import services.ProducerService;

import java.util.Scanner;

public class CreateProducerCommand extends AbstractCommand {

    private static ProducerService customerService = ProducerService.getInstance();
    private static final CreateProducerCommand createProducerCommand = new CreateProducerCommand();

    private CreateProducerCommand() {
    }

    public static CreateProducerCommand getInstance() {
        return createProducerCommand;
    }

    @Override
    public String getCommandName() {
        return "createProducer";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Producer name");
        String name = scanner.nextLine();
        System.out.println("Enter Producer country");
        String country = scanner.nextLine();
        customerService.post(new Producer(name, country));
    }
}
