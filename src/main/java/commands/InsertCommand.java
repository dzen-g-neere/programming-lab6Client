package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.IncorrectScriptException;
import exceptions.WrongArgumentException;
import labwork.LabWork;
import utility.LabWorkAsker;

/**
 * This is command 'insert'. Inserts a new element to collection.
 */
public class InsertCommand extends AbstractCommand {
    LabWorkAsker labWorkAsker;
    private Client client;

    public InsertCommand(Client client, LabWorkAsker labWorkAsker) {
        super("insert", " \"key\" - добавить новый элемент с заданным ключом");
        this.labWorkAsker = labWorkAsker;
        this.client = client;
    }

    /**
     * Execute of 'insert' command.
     */
    @Override
    public void execute(String argument) throws IncorrectScriptException {
//        Integer id,String name, Coordinates coordinates, Date creationDate, Long minimalPoint, long personalQualitiesMinimum, float averagePoint, Difficulty difficulty, Person author
        try {
            if (argument.isEmpty()) throw new WrongArgumentException();
            labWorkAsker.checkKey(argument.trim());
            LabWork labWork = new LabWork(
                    labWorkAsker.askID(),
                    argument,
                    labWorkAsker.askCoordinates(),
                    labWorkAsker.askDate(),
                    labWorkAsker.askMinimalPoint(),
                    labWorkAsker.askPersonalQualitiesMinimum(),
                    labWorkAsker.askAveragePoint(),
                    labWorkAsker.askDifficulty(),
                    labWorkAsker.askAuthor()
            );
            ExchangeClass exchangeClass = new ExchangeClass("insert", argument, labWork);
            client.send(exchangeClass);
        } catch (IncorrectScriptException e) {
            throw new IncorrectScriptException();
        } catch (WrongArgumentException e) {
            System.out.println("Ключ не может содержать символ ';', ключ не может быть пустой строкой");
        }
    }
}
