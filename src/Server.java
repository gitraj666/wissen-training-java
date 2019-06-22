
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// java.net.*

public class Server {

    private static int reqCount = 0;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static List<Socket> clientsList = new ArrayList<>();
    private static ArrayList<String> message;

    public static Socket setSocket(Socket socket1) {
        socket1 = socket;
        clientsList.add(socket1);
        return socket1;
    }

    public static void send(String message) {
        for (Socket client : clientsList) {
            try {
                OutputStream outputStream = client.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                oos.writeObject(message);
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Runnable serve = () -> {
            //while(true) {
            try {
                //lock.lock();
                //String message;
                Socket socket1 = setSocket(socket);
                TimeUnit.SECONDS.sleep(3);
                reqCount++;
                //System.out.println("Socket "+socket1.getLocalAddress());

                OutputStream outputStream = socket1.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
                oos.writeObject("your request has been served count is " + reqCount);
                InputStream inputStream = socket1.getInputStream();
                ObjectInputStream oos_in = new ObjectInputStream(inputStream);
                Object object = oos_in.readObject();
                String resp = (String) object;
                send(resp);
                System.out.println(resp);
                oos.close();
                System.out.println("response sent back");

            } catch (Exception e) {
                e.printStackTrace();
            }
            //lock.unlock();
            //break;
            //}
        };
        serverSocket = new ServerSocket(8181);
        while (true) {
            //socket = null;
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            try {
                System.out.println("Server started...waiting for client");
                socket = serverSocket.accept();
//                for(Socket client: clientsList) {
//                    System.out.println(client);
//                }
                System.out.println("Request Accepted...");
                executorService.submit(serve);
            } catch (Exception e) {
                //socket.close();
                e.printStackTrace();
            }
        }
    }

}
