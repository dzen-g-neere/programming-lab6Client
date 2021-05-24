package commands;

import connection.Client;
import connection.ExchangeClass;
import exceptions.WrongArgumentException;

/**
 * This is command 'group_counting_by_creation_date'. Groups and print elements of collection by creationDate.
 */
public class GroupCountingByCreationDateCommand extends AbstractCommand implements Command{
    private Client client;
    public GroupCountingByCreationDateCommand(Client client) {
        super("group_counting_by_creation_date", " - сгруппировать элементы коллекции по значению поля creationDate, вывести количество элементов в каждой группе)");
        this.client = client;
    }
    /**
     * Execute of 'group_counting_by_creation_date' command.
     */
    @Override
    public void execute(String argument) {
        try {
            if (!argument.isEmpty()) {
                throw new WrongArgumentException();
            }
            ExchangeClass exchangeClass = new ExchangeClass("group_counting_by_creation_date",argument,null);
            client.send(exchangeClass);
        } catch (WrongArgumentException e) {
            System.out.println("Используйте: '" + getName() + "'");
        } catch (Exception e) {
            System.out.println("Ошибка. Повторите ввод.");
        }
    }
}
