/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp_maxmin;

import java.io.IOException;
import java.net.SocketException;

/**
 *
 * @author kuted
 */
public class Client {
    public static void main(String[] args) throws SocketException, IOException {
//        DatagramSocket client = new DatagramSocket();
//        byte[] buff = new byte[2048];
//        String address = "203.162.10.109";
//        int port = 2207;
//        String ma = ";B18DCCN669;931";
//        DatagramPacket dpReq = new DatagramPacket(buff,buff.length,InetAddress.getByName(address),port);
//        client.receive(dpReq);
//        String str = (new String(dpReq.getData())).trim();

        String str = "1243;1,2,-3,4,5,6";
        String s1 = str.substring(0,str.indexOf(";")+1);
        String s2 = str.substring(str.indexOf(";")+1);
        System.out.println(s1);
        System.out.println(s2);
        String[] sres = s2.split(",");
        int []ds = new int [sres.length + 1];
        for(int i = 0; i < sres.length; i++){
            ds[i] = Integer.parseInt(sres[i]);
        }
        int max = ds[0];
        int min = ds[0];
        for(int i = 1; i < ds.length; i++){
            max = Math.max(ds[i], max);
            min = Math.min(ds[i], min);
        }
        String res = s1 + String.valueOf(max) + "," + String.valueOf(min);
        System.out.println(res);
//        DatagramPacket dpRes = new DatagramPacket(res.getBytes(),res.getBytes().length,InetAddress.getByName(address),port);
//        client.send(dpRes);
//        client.close();
    }
}
