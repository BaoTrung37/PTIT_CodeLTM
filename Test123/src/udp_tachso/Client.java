/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp_tachso;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author kuted
 */
public class Client {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket client = new DatagramSocket();
        String diachi = "";
        int port = 0;
        String ma = ";B18DCCN;";
        DatagramPacket dpReq = new DatagramPacket(ma.getBytes(),ma.getBytes().length,InetAddress.getByName(diachi),port);
        client.send(dpReq);
        byte[] buff = new byte[1024];
        DatagramPacket dpRecive = new DatagramPacket(buff,buff.length,InetAddress.getByName(diachi),port);
        client.receive(dpRecive);
        String str = (new String(dpRecive.getData())).trim();
        String s[] = str.split(";");
        String res = s[0] + ";";
        String[] strDsso = s[2].split(",");
        int n = Integer.parseInt(strDsso[1]);
        int []a = new int [10000];
        int []b = new int [10000];
        for(int i = 0; i < strDsso.length; i++){
            a[i] = Integer.parseInt(strDsso[i]);
            b[a[i]] = 1;
        }
        for(int i = 1; i <= n; i++){
            if(b[i] == 0){
                res += String.valueOf(i) + ",";
            }
        }
        String res2 = res.substring(0,res.length() - 1);
        DatagramPacket dpRes = new DatagramPacket(res2.getBytes(),res2.getBytes().length,InetAddress.getByName(diachi),port);
        client.send(dpRes);
        client.close();
    }
}
