package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;

/**
 * This is command 'clear'. Delete all elements of collection.
 */
public class ClearCommand extends AbstractCommand implements Command{
    Client client;
    public ClearCommand(Client client) {
        super("clear", " - очистить коллекцию");
        this.client = client;
    }
    /**
     * Execute of 'clear' command.
     */
    @Override
    public void execute(String argument){
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            ExchangeClass exchangeClass = new ExchangeClass("clear",argument,null);
            client.send(exchangeClass);
        } catch (WrongArgumentException e) {
            System.out.println("Некорректный аргумент. Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
