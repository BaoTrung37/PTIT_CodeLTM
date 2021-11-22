
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udep;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author kuted
 */
public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket client = new DatagramSocket();
            
            String str = "trung bao";
            DatagramPacket dpReq = new DatagramPacket(str.getBytes(),str.getBytes().length,
                    InetAddress.getByName("localhost"),2207);
            client.send(dpReq);
            byte[] buff = new byte[2048];
            DatagramPacket dpRes = new DatagramPacket(buff, buff.length);
            client.receive(dpRes);
            String res = (new String(dpRes.getData())).trim();
            System.out.println("client : " + res);
        } catch (Exception e) {
             e.printStackTrace();
        }
    }
}
