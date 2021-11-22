/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcp_char;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author kuted
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("203.162.10.109",2207);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String maSv = "B18DCCN;"; 
        out.write(maSv);
        String str = in.readLine();
//        String str = "dgU0o ch2k22lds0o";
        int []d = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            d[i] = 1;
        }
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) != ' ' && d[i] == 1){
                for(int j = i + 1; j < str.length(); j++){
                    if(str.charAt(i) == str.charAt(j)){
                        d[i]++;
                        d[j] = 0; 
                    }
                }
            }
        }
        String res = "";
        for(int i = 0; i < str.length(); i++){
            if(d[i] > 1){
                res = res + str.charAt(i) + ":" + String.valueOf(d[i]) + ",";
            }
        }
//        System.out.println(res);
        out.write(res);
        in.close();
        out.close();
        client.close();
    }
}
