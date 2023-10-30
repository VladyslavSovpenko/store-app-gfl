package utils;

import commands.AbstractCommand;
import commands.ReadFromFileCommand;
import commands.SaveToFileCommand;
import commands.producerCommands.*;
import commands.souvenirCommands.*;
import commands.specialCommands.*;

public interface Utils {

    String WELCOME_MESSAGE =
            "Welcome to MovieRentalApp.\n\n" +

                    "Enter `/saveToFile` to save to the File\n" +
                    "Enter `/readFromFile` to save to the File\n\n" +

                    "Enter `/createProducer` and write name to create new Producer\n" +
                    "Enter `/getAllProducers` to get all Producers\n" +
                    "Enter `/getProducer` to get Producer\n" +
                    "Enter `/updateProducer` to update Producer\n" +
                    "Enter `/removeProducer` to remove Producer from warehouse\n" +
                    "----------------------------------------------\n" +
                    "Enter `/createSouvenir` to create Souvenir\n" +
                    "Enter `/getAllSouvenirs` to get all Souvenirs\n" +
                    "Enter `/getSouvenir` to get Souvenir by title\n" +
                    "Enter `/updateSouvenir` to update Souvenir\n" +
                    "Enter `/removeSouvenir` to remove Souvenir\n" +
                    "----------------------------------------------\n" +
                    "Enter `/getInformationOfProducer` to get Souvenirs information of Producer\n" +
                    "Enter `/deleteProducerAndSouvenirs` to get delete Producer and his Souvenirs\n" +
                    "Enter `/getAllInformation` to get all info about Producers and his Souvenirs\n" +
                    "Enter `/getAllSouvenirsByYear` to get all info about Producers and his Souvenirs by the year\n" +
                    "Enter `/getProducerByYear` to get Producers  by the year\n" +
                    "Enter `/getProducersWithLowerPrice` to get Producers  with lower price\n" +
                    "Enter `/getSouvenirsByCountry` to get Producers  by country\n" +

                    "To leave - enter `exit`";

    AbstractCommand[] ABSTRACT_COMMANDS = {
            CreateProducerCommand.getInstance(),
            GetAllProducersCommand.getInstance(),
            GetProducerCommand.getInstance(),
            UpdateProducerCommand.getInstance(),
            RemoveProducerCommand.getInstance(),

            CreateSouvenirCommand.getInstance(),
            GetAllSouvenirsCommand.getInstance(),
            GetSouvenirCommand.getInstance(),
            RemoveSouvenirCommand.getInstance(),
            UpdateSouvenirCommand.getInstance(),

            GetSouvenirsOfProducerCommand.getInstance(),
            GetSouvenirsByCountryCommand.getInstance(),
            GetProducersLowerPriceCommand.getInstance(),
            GetAllInformationCommand.getInstance(),
            GetAllSouvenirsByYearCommand.getInstance(),
            GetProducerByYearCommand.getInstance(),
            DeleteProducerAndSouvenirsCommand.getInstance(),

            SaveToFileCommand.getInstance(),
            ReadFromFileCommand.getInstance()
    };

    String PRODUCER_ADDED = "Producer added";
    String PRODUCER_UPDATED = "Producer updated";
    String PRODUCER_REMOVED = "Producer removed";

    String SOUVENIR_ADDED =   "Souvenir added";
    String SOUVENIR_UPDATED = "Souvenir updated";
    String SOUVENIR_REMOVED = "Souvenir removed";

    String INFO_SAVED = "Info has been saved";
    String INFO_READ = "Info has been read";
}
