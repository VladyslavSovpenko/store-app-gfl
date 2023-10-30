package commands.specialCommands;

import commands.AbstractCommand;
import entity.Souvenir;
import services.SouvenirService;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetAllSouvenirsByYearCommand extends AbstractCommand {

    private static SouvenirService souvenirService = SouvenirService.getInstance();
    private static GetAllSouvenirsByYearCommand getAllSouvenirsByYearCommand =
            new GetAllSouvenirsByYearCommand();

    private GetAllSouvenirsByYearCommand() {
    }

    public static GetAllSouvenirsByYearCommand getInstance() {
        return getAllSouvenirsByYearCommand;
    }

    @Override
    public String getCommandName() {
        return "getAllSouvenirsByYear";
    }

    @Override
    public void execute(Scanner scanner) {
        Map<Integer, List<Souvenir>> souvenirsByYear = souvenirService.getAllEntities().stream()
                .collect(Collectors.groupingBy(souvenir -> souvenir.getCreationDate().getYear()));

        souvenirsByYear.forEach((year, yearSouvenirs) -> {
            System.out.println("Year: " + year);
            yearSouvenirs.forEach(souvenir ->
                    System.out.println("  Souvenir: " + souvenir.getName() + ", Price: " + souvenir.getPrice())
            );
            System.out.println();
        });
    }
}
