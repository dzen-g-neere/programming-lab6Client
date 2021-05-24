package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.IncorrectScriptException;
import exceptions.WrongArgumentException;
import labwork.LabWork;
import utility.LabWorkAsker;

/**
 * This is command 'replace_if_lowe'. Replaces element by key if new element is less than old one.
 */
public class ReplaceIfLowerCommand extends AbstractCommand implements Command {
    LabWorkAsker labWorkAsker;
    private Client client;
    public ReplaceIfLowerCommand(Client client, LabWorkAsker labWorkAsker) {
        super("replace_if_lowe", " \"key\" - заменить значение по ключу, если новое значение меньше старого");
        this.labWorkAsker = labWorkAsker;
        this.client = client;
    }

    /**
     * Execute of 'replace_if_lowe' command.
     */
    @Override
    public void execute(String argument) throws IncorrectScriptException {
        try {
            if (argument.isEmpty()) throw new WrongArgumentException();
            LabWork labWorkNew = new LabWork(
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
            ExchangeClass exchangeClass = new ExchangeClass("replace_if_lowe", argument, labWorkNew);
            client.send(exchangeClass);
        } catch (WrongArgumentException e) {
            System.out.println("Аргумент " + argument + " некорректен");
        }
    }
}

