
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {

    public static void getMessage(Socket socket) throws Exception {
        InputStream in = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(in);
        Object object = ois.readObject();
        String resp = (String) object;
        System.out.println("resp : " + resp);
    }

    public static void sendMessage(Socket socket, String message) throws Exception {

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(message);
        getMessage(socket);
    }

    public static void main(String[] args) throws Exception {


        while (true) {
            Socket socket = new Socket("localhost", 8181);
            // ...

//                InputStream in = socket.getInputStream();
//                OutputStream outputStream = socket.getOutputStream();
//                ObjectInputStream ois = new ObjectInputStream(in);
//                ObjectOutputStream oos = new ObjectOutputStream(outputStream);
//                Object object = ois.readObject();
//                String resp = (String) object;
//
//                System.out.println("resp : " + resp);
//                String message = sc.nextLine();
//                oos.writeObject(message);
//                Object object2 = ois.readObject();
//                String resp2 = (String) object2;
//                System.out.println("resp : " + resp2);
            //socket.close();


            //getMessage(socket);
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            sendMessage(socket, message);
            getMessage(socket);

        }
        //sc.close();
    }
}
