/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
        DatagramSocket server = new DatagramSocket(2207);
        System.out.println("Server is running ....");
        while(true){
            byte[] buff = new byte[1024];
            DatagramPacket dpReq = new DatagramPacket(buff,buff.length);
            server.receive(dpReq);
            String strReq = new String(dpReq.getData()).trim();
            System.out.println("req str " + strReq);
            String strRes = (new StringBuilder(strReq).reverse()).toString();
            DatagramPacket dqRes = new DatagramPacket(strRes.getBytes(),strRes.length(),
                    dpReq.getAddress(),dpReq.getPort()); 
            server.send(dqRes);
        }
    }
}
