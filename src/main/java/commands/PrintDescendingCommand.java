package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;

/**
 * This is command 'print_descending'. Prints all elements in the decreasing order.
 */
public class PrintDescendingCommand extends  AbstractCommand implements Command{
    private Client client;
    public PrintDescendingCommand(Client client) {
        super("print_descending", " - вывести элементы коллекции в порядке убывания");
        this.client = client;
    }
    /**
     * Execute of 'print_descending' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            ExchangeClass exchangeClass = new ExchangeClass("print_descending", argument, null);
            client.send(exchangeClass);
        } catch (WrongArgumentException e) {
            System.out.println("Некорректный аргумент. Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
