package connection;

import java.io.*;
import java.net.*;

public class Client {
    DatagramSocket socket;
    SocketAddress socketAddress;

    public Client(DatagramSocket socket, SocketAddress socketAddress) {
        this.socket = socket;
        this.socketAddress = socketAddress;
    }

    public void send(ExchangeClass exchangeClass) {
        byte[] sending;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(exchangeClass);
            out.flush();
            sending = bos.toByteArray();
            DatagramPacket packet = new DatagramPacket(sending, sending.length, socketAddress);
            socket.send(packet);
            //System.out.println(packet);
            //System.out.println("exchangeClass = " + exchangeClass);
            receive();
        } catch (PortUnreachableException e) {
            System.out.println("Порт недоступен");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receive() {
        byte[] message = new byte[65535]; //Массив байт, который мы получаем
        try {
            DatagramPacket packet = new DatagramPacket(message, message.length);
            socket.setSoTimeout(10000); //Задержка для возможности обработки запроса клиента
            socket.receive(packet);
            ExchangeClass exchangeClass = deserialize(message);
            System.out.println(exchangeClass.getAnswer());
        } catch (SocketTimeoutException e) {
            System.out.println("Время ожидания превышено");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ExchangeClass deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream b = new ByteArrayInputStream(bytes)) {
            try (ObjectInputStream o = new ObjectInputStream(b)) {
                return (ExchangeClass) o.readObject();
            }
        }
    }
}
