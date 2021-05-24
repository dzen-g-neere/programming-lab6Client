package run;

import commands.*;
import connection.Client;
import utility.*;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * Main application class. Creates all instances and runs the program.
 *
 * @author Дмитрий Залевский P3112
 */
public class Main {

    public static void main(String[] args) {
        try {
            Scanner userScanner = new Scanner(System.in);
            //String address = "127.0.0.1";
            int port = 0;
            String input;
            Client client;
            //System.out.println("Введите адресс:");
            //address = consoleScanner.nextLine();
            System.out.print("Введите порт: ");
            input = userScanner.nextLine();
            try {
                port = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный порт");
                System.exit(1);
            }
            SocketAddress socketAddress = new InetSocketAddress(InetAddress.getByName("localhost"), port);
            DatagramSocket clientSocket = new DatagramSocket();
            client = new Client(clientSocket, socketAddress);
            System.out.println("Начало работы программы:");

            LabWorkAsker labWorkAsker = new LabWorkAsker(userScanner);
            CommandManager commandManager = new CommandManager(
                    new InsertCommand(client,labWorkAsker),
                    new ShowCommand(client),
                    new ExitCommand(),
                    new UpdateIDCommand(client, labWorkAsker),
                    new InfoCommand(client),
                    new ClearCommand(client),
                    new ExecuteScriptCommand(client),
                    new FilterGreaterThanAveragePointCommand(client),
                    new GroupCountingByCreationDateCommand(client),
                    new HelpCommand(client),
                    new PrintDescendingCommand(client),
                    new RemoveGreaterKey(client),
                    new RemoveKeyCommand(client),
                    new ReplaceIfGreaterCommand(client, labWorkAsker),
                    new ReplaceIfLowerCommand(client, labWorkAsker)
            );
            ConsoleManager consoleManager = new ConsoleManager(userScanner, commandManager, labWorkAsker);
            consoleManager.interectiveMode();
        } catch (IOException e) {

        }
    }

}
