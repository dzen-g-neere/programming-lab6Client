package commands;

import connection.Client;
import connection.ExchangeClass;

/**
 * This is command 'filter_greater_than_average_point'. Prints elements which 'averagePoint' is more than given.
 */
public class FilterGreaterThanAveragePointCommand extends AbstractCommand implements Command{
    private Client client;
    public FilterGreaterThanAveragePointCommand(Client client) {
        super("filter_greater_than_average_point", " averagePoint - вывести элементы, значение поля averagePoint которых больше заданного");
        this.client = client;
    }

    /**
     * Execute of 'filter_greater_than_average_point' command.
     */
    @Override
    public void execute(String argument) {
        float averagePoint;
        try {
            averagePoint = Float.parseFloat(argument);
            if (averagePoint <= 0){
                throw new NumberFormatException();
            }
            ExchangeClass exchangeClass = new ExchangeClass("filter_greater_than_average_point",argument,null);
            client.send(exchangeClass);
        } catch (NullPointerException e){
            System.out.println("Ошибка. Аргумент не может быть пустой строкой.");
        } catch (NumberFormatException e){
            System.out.println("Ошибка. Аргумент должен быть числом больше 0.");
        }

    }
}
