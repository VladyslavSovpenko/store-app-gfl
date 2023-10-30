import handlers.CommandHandler;
import utils.Utils;

import java.util.Scanner;

public class StoreApp {
    private static final CommandHandler commandHandler = CommandHandler.getInstance();

    public static void main(String[] args) {
        System.out.println(Utils.WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        while (!"exit".equalsIgnoreCase(text)) {
            commandHandler.handleCommand(text, scanner);
            text = scanner.nextLine();
        }
    }
}
