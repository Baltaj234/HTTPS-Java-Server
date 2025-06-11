/**
 * Java program to create a simple HTTP Server to demonstrate
 * how to use the ServerSocket and Socket class.
 * @author Baltaj Bhandal
 * @version 1.0
 */

    // Importing the java ServerSocket class

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.Date;


class myServer {

     public static void main(String args[]) throws IOException {

         ServerSocket server = new ServerSocket(8080);
         System.out.println("Listening for connection on port 8080 ....");
         while (true) {
             try (Socket socket = server.accept()) {
                 // Sending today's date to the client
                 Date today = new Date();
                 String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                 socket.getOutputStream()
                         .write(httpResponse.getBytes("UTF-8"));
             }
         }
     }

 }
