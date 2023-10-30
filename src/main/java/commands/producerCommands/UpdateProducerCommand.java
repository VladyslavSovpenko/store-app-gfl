package commands.producerCommands;

import commands.AbstractCommand;
import entity.Producer;
import services.ProducerService;

import java.util.Scanner;

public class UpdateProducerCommand extends AbstractCommand {

    private static ProducerService producerService = ProducerService.getInstance();
    private static UpdateProducerCommand updateCustomerCommand = new UpdateProducerCommand();

    private UpdateProducerCommand() {
    }

    public static UpdateProducerCommand getInstance() {
        return updateCustomerCommand;
    }

    @Override
    public String getCommandName() {
        return "updateProducer";
    }

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Enter Producer name to find");
        String customerName = scanner.nextLine();

        System.out.println("Enter Producer`s name to update");
        String updatedName = scanner.nextLine();

        System.out.println("Enter Producer`s country to update");
        String updatedCountry = scanner.nextLine();

        Producer producer = new Producer(updatedName, updatedCountry);
        producerService.update(customerName, producer);
    }
}
