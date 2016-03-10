/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpcliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexis
 */
public class Udpcliente {

    /**
     * @param args the command line arguments
     */
    private static final int TOPORT = 1234;
    private static String TOMACHINE = "localhost";

    public static void main(String[] args) {
                try {
            System.out.println("CREATING DATAGRAM SOCKET");
            DatagramSocket datagramSocket =new DatagramSocket();
            System.out.println("......SENDING MESSAGE....");
            
            String message =">>>> Hello i am an udp client<<<<";
            DatagramPacket datagramPacket =new DatagramPacket (message.getBytes(),message.getBytes().length,InetAddress.getByName(TOMACHINE),TOPORT);
            datagramSocket.send(datagramPacket);
            System.out.println("..............MESSAGE SENT........");
            System.out.println(".......WAITING FOR RESPONSE......");
            byte [] response=new byte[40];
            datagramPacket =new DatagramPacket (response,response.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("........MESSAGE RECEIVED:"+new String(response));
            System.out.println("CLOSING SOCKET");
            datagramSocket.close();
            System.out.println("CLIENT FINISHED");
                    
                    

                    
        } catch (SocketException ex) {
            Logger.getLogger(Udpcliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Udpcliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Udpcliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
