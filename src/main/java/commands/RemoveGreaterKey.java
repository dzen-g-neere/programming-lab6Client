package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;

/**
 * This is command 'remove_greater_key'. Remove elements which have key that is more than given.
 */
public class RemoveGreaterKey extends AbstractCommand implements Command{
    private Client client;
    public RemoveGreaterKey(Client client) {
        super("remove_greater_key", " - удалить из коллекции все элементы, ключ которых превышает заданный");
        this.client = client;
    }

    /**
     * Execute of 'remove_greater_key' command.
     */
    @Override
    public void execute(String argument) {

        try {
            if (argument.isEmpty()) throw new WrongArgumentException();
            ExchangeClass exchangeClass = new ExchangeClass("remove_greater_key", argument, null);
            client.send(exchangeClass);
        } catch (WrongArgumentException e){
            System.out.println("Некорректный аргумент");
        }
    }
}
