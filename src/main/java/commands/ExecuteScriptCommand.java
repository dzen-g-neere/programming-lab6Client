package commands;

import connection.Client;
import connection.ExchangeClass;

/**
 * This is command 'execute_script'. It executes commands from script.
 */
public class ExecuteScriptCommand extends AbstractCommand implements Command{
    Client client;
    public ExecuteScriptCommand(Client client) {
        super("execute_script", " file_name - считать и исполнить скрипт из указанного файла. " +
                "В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме");
        this.client = client;
    }
    /**
     * Execute of 'execute_script' command.
     */
    @Override
    public void execute(String argument) {
        ExchangeClass exchangeClass = new ExchangeClass("execute_script",argument,null);
        client.send(exchangeClass);
    }
}
