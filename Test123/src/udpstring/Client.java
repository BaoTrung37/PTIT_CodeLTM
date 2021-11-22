/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udpstring;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author kuted
 */
public class Client {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket client = new DatagramSocket();
        byte[] buff = new byte[2048];
        String daichi = "";
        int port = 0;
        
        String code = ";B18DCCN;";
        DatagramPacket dpReq = new DatagramPacket(code.getBytes(),code.getBytes().length,InetAddress.getByName(daichi),port);
        client.send(dpReq);
        
        DatagramPacket dpRecive = new DatagramPacket(buff,buff.length,InetAddress.getByName(daichi),port);
        client.receive(dpRecive);
        String str = "asdasd;asdyh2ndaASuA822nd2DAsd2";
//        String str = (new String(dpRecive.getData())).trim();
        String res = str.substring(0,str.indexOf(";")+1);
        String s2 = str.substring(str.indexOf(";")+1);
        
        int n = s2.length();
//        HashMap<Character,Integer> map = new HashMap<>();
//        int max = 0;
//        for(int i = 0; i < s2.length(); i++){
//            if(map.get(s2.charAt(i)) == null){
//                map.put(s2.charAt(i), 1);
//                max = Math.max(max, 1);
//            }
//            else{
//                int x = map.get(s2.charAt(i)) + 1;
//                map.put(s2.charAt(i), x);
//                max = Math.max(x, max);
//            }
//        }
//         for(int i = 0; i < s2.length(); i++){
//            if(map.get(s2.charAt(i)) == max){
//                res += String.valueOf(s2.charAt(i)) + ":";
//                for(int j = 0; j < s2.length(); j++){
//                    if(s2.charAt(i) == s2.charAt(j)){
//                        res += String.valueOf(j + 1) + ",";
//                    }
//                }
//                break;
//            }
//        }
        int map[] = new int[10000];
        int max = 0;
        for(int i = 0; i < n; i++){
            map[s2.charAt(i) - '0'] += 1;
            max = map[s2.charAt(i) - '0'];
        }
        for(int i = 0; i < n; i++){
            if(map[s2.charAt(i) -'0'] == max){
                res += String.valueOf(s2.charAt(i)) + ":";
                for(int j = 0; j < n; j++){
                    if(s2.charAt(i) == s2.charAt(j)){
                        res += String.valueOf(j + 1) + ",";
                    }
                }
                break;
            }
        }
//        System.out.println(res);
        DatagramPacket dpRes = new DatagramPacket(res.getBytes(),res.getBytes().length,InetAddress.getByName(daichi),port);
        client.send(dpRes);
        client.close();
    }
}
