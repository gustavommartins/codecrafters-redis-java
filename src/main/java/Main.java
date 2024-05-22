import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
  public static void main(String[] args){
    System.out.println("Logs from your program will appear here!");
    Socket clientSocket = null;
    try(ServerSocket serverSocket = new ServerSocket(6379);) {
      serverSocket.setReuseAddress(true);
      clientSocket = serverSocket.accept();
      clientSocket.getOutputStream().write("+PONG\r\n".getBytes());
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    } finally {
      try {
        if (clientSocket != null) {
          clientSocket.close();
        }
      } catch (IOException e) {
        System.out.println("IOException: " + e.getMessage());
      }
    }
  }
}
