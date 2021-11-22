/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author kuted
 */
public class UDPClient {
    public static void main(String[] args) throws SocketException, IOException {
        // TODO code application logic here
        DatagramSocket client = new DatagramSocket();
        // gui chuoi can dao nguoc len server
        String str = "NGuyen Bao Trung";
        DatagramPacket dpReq = new DatagramPacket(str.getBytes(),str.length(),
                InetAddress.getByName("localhost"),2207);
        client.send(dpReq);
        
        byte[] buff = new byte[1024];
        DatagramPacket dpRes = new DatagramPacket(buff,buff.length);
        client.receive(dpRes);
        String strRes = new String(dpRes.getData()).trim();
        System.out.println("req str " + strRes);
    }
}
