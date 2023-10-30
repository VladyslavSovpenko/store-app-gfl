package commands;

import services.ReadWriteService;

import java.util.Scanner;

public class ReadFromFileCommand extends AbstractCommand{

    private static ReadWriteService readWriteService = ReadWriteService.getInstance();
    private static ReadFromFileCommand readFromFileCommand = new ReadFromFileCommand();

    private ReadFromFileCommand() {
    }

    public static ReadFromFileCommand getInstance() {
        return readFromFileCommand;
    }

    @Override
    public String getCommandName() {
        return "readFromFile";
    }

    @Override
    public void execute(Scanner scanner) {
        readWriteService.readFromFile();
    }
}
