package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.IncorrectScriptException;
import labwork.LabWork;
import utility.LabWorkAsker;

/**
 * This is command 'update'. Refreshes an element of collection which id equals given one.
 */
public class UpdateIDCommand extends AbstractCommand implements Command {
    LabWorkAsker labWorkAsker;
    Client client;

    public UpdateIDCommand(Client client, LabWorkAsker labWorkAsker) {
        super("update", " ID - обновить значение элемента коллекции, id которого равен заданному");
        this.labWorkAsker = labWorkAsker;
        this.client = client;
    }

    /**
     * Execute of 'update' command.
     */
    @Override
    public void execute(String argument) throws IncorrectScriptException {
        try {
            int i = Integer.parseInt(argument);
            LabWork labWork = new LabWork(
                    labWorkAsker.askID(),
                    labWorkAsker.askName(),
                    labWorkAsker.askCoordinates(),
                    labWorkAsker.askDate(),
                    labWorkAsker.askMinimalPoint(),
                    labWorkAsker.askPersonalQualitiesMinimum(),
                    labWorkAsker.askAveragePoint(),
                    labWorkAsker.askDifficulty(),
                    labWorkAsker.askAuthor()
            );
            ExchangeClass exchangeClass = new ExchangeClass("update", argument, labWork);
            client.send(exchangeClass);

        } catch (NumberFormatException e) {
            System.out.println("ID должен быть целым числом");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Непредвиденная ошибка");
        }
    }
}
