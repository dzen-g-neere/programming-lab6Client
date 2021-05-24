package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;

/**
 * This is command 'info'. Prints information about collection.
 */
public class InfoCommand extends AbstractCommand implements Command{
    private Client client;
    public InfoCommand(Client client) {
        super("info", " - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)");
        this.client = client;
    }
    /**
     * Execute of 'info' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            ExchangeClass exchangeClass = new ExchangeClass("info", argument, null);
            client.send(exchangeClass);
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
