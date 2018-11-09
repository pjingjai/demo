import java.net.*;
import java.io.*;
import java.lang.Thread ;

public class PacketReceiveDemo
{
 public static void main (String args[]) {

 System.out.println ("Binding to local port 3000, 4000");

try {
ThreadExtension t3 = new ThreadExtension(3000);
ThreadExtension t4 = new ThreadExtension(4000);
t3.start();
t4.start();
}
catch (Exception e)
 {
 System.err.println ("Error - " + e);
 }
}

}
 class ThreadExtension extends Thread {

 DatagramSocket socket;
 public ThreadExtension(int s) {
 try
 {
 	socket = new DatagramSocket(s);
 }
catch (Exception e)
 {
 System.err.println ("Error - " + e);
 }
 }


@Override
public void run() {
while (true) {
 System.out.println ("Bound to local port " + socket.getLocalPort());

 try
 {

 DatagramPacket packet = new DatagramPacket( new byte[256], 256 );
 socket.receive(packet);
 System.out.println ("Packet received!");
 InetAddress remote_addr = packet.getAddress();

 System.out.println ("Sent by : " +
remote_addr.getHostAddress() );
 System.out.println ("Sent from : " +
packet.getPort());

 // Display packet contents, by reading
 // from byte array
 ByteArrayInputStream bin = new
 ByteArrayInputStream (packet.getData());
 // Display only up to the length of the
 // original UDP packet
 for (int i=0; i < packet.getLength(); i++)
 {
 int data = bin.read();
 if (data == -1)
 break;
 else
 System.out.println( (char)
 data) ;
 }

 }
catch (Exception e)
 {
 System.err.println ("Error - " + e);
 }
}
}
 }
