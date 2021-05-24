package commands;
import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;


/**
 * This is command 'show'. Prints all elements of collection.
 */
public class ShowCommand extends AbstractCommand implements Command{
    Client client;
    public ShowCommand(Client client) {
        super("show", " - вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.client = client;
    }

    /**
     * Execute of 'show' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            ExchangeClass exchangeClass = new ExchangeClass("show", argument, null);
            client.send(exchangeClass);
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
