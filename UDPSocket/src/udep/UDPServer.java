/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udep;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author kuted
 */
public class UDPServer {

    public static void main(String[] args) throws SocketException, IOException {
        
        try {
            DatagramSocket server = new DatagramSocket(2207);
             System.out.println("Server is running ...");
            byte[] dpData = new byte[2048];
            while(true){
                
            DatagramPacket packet = new DatagramPacket(dpData,dpData.length);
            server.receive(packet);
            String strRec = new String(packet.getData()).trim();
            System.out.println("Server nhan : " + strRec);
            String strRes = (new StringBuilder(strRec)).reverse().toString();
            DatagramPacket dpRes = new DatagramPacket(strRes.getBytes(),strRes.getBytes().length,
            packet.getAddress(),packet.getPort());
            server.send(dpRes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
