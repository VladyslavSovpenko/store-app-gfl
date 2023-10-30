package commands.producerCommands;

import commands.AbstractCommand;
import entity.Producer;
import services.ProducerService;

import java.util.List;
import java.util.Scanner;

public class GetAllProducersCommand extends AbstractCommand {

    private static ProducerService producerService = ProducerService.getInstance();
    private static final GetAllProducersCommand getAllCustomersCommand = new GetAllProducersCommand();

    private GetAllProducersCommand() {
    }

    public static GetAllProducersCommand getInstance() {
        return getAllCustomersCommand;
    }


    @Override
    public String getCommandName() {
        return "getAllProducers";
    }

    @Override
    public void execute(Scanner scanner) {
        List<Producer> producers = producerService.getAllEntities();
        if (!producers.isEmpty()) {
            producers.forEach(System.out::println);
        } else {
            System.out.println("Producer's list is empty");
        }
    }
}
