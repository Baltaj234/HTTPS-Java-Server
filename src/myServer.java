/**
 * Java program to create a simple HTTP Server to demonstrate
 * how to use the ServerSocket and Socket class.
 * @author Baltaj Bhandal
 * @version 1.0
 */

    // Importing the java ServerSocket and Socket class
    import java.io.IOException;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.Date;


class myServer {

     public static void main(String args[]) throws IOException {

         // Create a server socket that listens on port 8080
         ServerSocket server = new ServerSocket(8080);
         System.out.println("Listening for connection on port 8080 ....");

         // Infinite loop to continuously accept incoming client connections
         while (true) {

             try (Socket socket = server.accept()) {

                 // Getting today's date
                 Date today = new Date();

                 // Prepare a basic HTTP response with status code 200 OK and the current date
                 String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;

                 // Send the response to the client
                 socket.getOutputStream()
                         .write(httpResponse.getBytes("UTF-8"));
             }
         }
     }

 }
