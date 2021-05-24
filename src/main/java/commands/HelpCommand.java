package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;

/**
 * Command 'help'. Displays help for available commands.
 */
public class HelpCommand extends AbstractCommand implements Command {
    private Client client;

    public HelpCommand(Client client) {
        super("help", " - вывести справку по доступным командам");
        this.client = client;
    }

    /**
     * Execute of 'help' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            ExchangeClass exchangeClass = new ExchangeClass("help", argument, null);
            client.send(exchangeClass);
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
