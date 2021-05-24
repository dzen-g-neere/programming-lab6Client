package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;

/**
 * This is command 'remove_key'. Deletes element by key.
 */
public class RemoveKeyCommand extends AbstractCommand implements Command{
    private Client client;
    public RemoveKeyCommand(Client client) {
        super("remove_key", " \"key\" - удалить элемент из коллекции по его ключу");
        this.client = client;
    }
    /**
     * Execute of 'remove_key' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (argument.isEmpty()) throw new WrongArgumentException();
            ExchangeClass exchangeClass = new ExchangeClass("remove_key", argument, null);
            client.send(exchangeClass);
        }catch (WrongArgumentException e){
            System.out.println("Некорректный аргумент");
        }

    }
}
