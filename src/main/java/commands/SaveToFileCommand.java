package commands;

import services.ReadWriteService;

import java.util.Scanner;

public class SaveToFileCommand extends AbstractCommand {

    private static ReadWriteService readWriteService = ReadWriteService.getInstance();
    private static SaveToFileCommand saveToFileCommand = new SaveToFileCommand();

    private SaveToFileCommand() {
    }

    public static SaveToFileCommand getInstance() {
        return saveToFileCommand;
    }

    @Override
    public String getCommandName() {
        return "saveToFile";
    }

    @Override
    public void execute(Scanner scanner) {
        readWriteService.saveToFile();
    }
}
