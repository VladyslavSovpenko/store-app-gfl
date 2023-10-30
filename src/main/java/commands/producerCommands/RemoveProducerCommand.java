package commands.producerCommands;

import commands.AbstractCommand;
import entity.Producer;
import services.ProducerService;

import java.util.List;
import java.util.Scanner;

public class RemoveProducerCommand extends AbstractCommand {

    private static ProducerService customerService = ProducerService.getInstance();
    private static RemoveProducerCommand removeCustomerCommand = new RemoveProducerCommand();

    private RemoveProducerCommand() {
    }

    public static RemoveProducerCommand getInstance() {
        return removeCustomerCommand;
    }

    @Override
    public String getCommandName() {
        return "removeProducer";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Producer> allProducers = customerService.getAllEntities();
        if (!allProducers.isEmpty()) {
            allProducers.forEach(System.out::println);
            System.out.println("Enter Producer id to remove");
            String customerName = scanner.nextLine();
            customerService.delete(customerName);
        } else {
            System.out.println("Customers list is empty");
        }
    }
}
